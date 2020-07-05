/**
 * 
 */
package net.brilliant.auth.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import net.brilliant.auth.comp.JWTServiceImpl;
import net.brilliant.auth.core.AuthorizationServiceBase;
import net.brilliant.auth.domain.UserSecurityProfile;
import net.brilliant.auth.entity.AccessDecisionPolicy;
import net.brilliant.auth.entity.Authority;
import net.brilliant.auth.entity.UserAccountProfile;
import net.brilliant.auth.service.AccessDecisionPolicyService;
import net.brilliant.auth.service.AuthorityService;
import net.brilliant.auth.service.AuthorizationService;
import net.brilliant.comm.comp.Communicator;
import net.brilliant.comm.domain.CorpMimeMessage;
import net.brilliant.comm.global.CommunicatorConstants;
import net.brilliant.common.CommonUtility;
import net.brilliant.common.DateTimeUtility;
import net.brilliant.common.ListUtility;
import net.brilliant.exceptions.NgepAuthException;
import net.brilliant.exceptions.ObjectNotFoundException;
import net.brilliant.framework.entity.auth.AuthenticationDetails;
import net.brilliant.global.GlobalConstants;
import net.brilliant.model.ExecutionContext;

/**
 * @author ducbq
 *
 */
@Service
public class AuthorizationServiceImpl extends AuthorizationServiceBase implements AuthorizationService {
	@Inject
	private Communicator emailCommunicator;

	@Inject
	private JWTServiceImpl tokenProvider;

	@Inject
	private AuthorityService authorityService;

	@Inject
	private AccessDecisionPolicyService accessDecisionPolicyService;

	@Override
	public UserSecurityProfile authenticate(String ssoId, String password) throws NgepAuthException {
		return this.generateSecurityPrincipalProfile(ssoId, password);
	}

	@Override
	public UserSecurityProfile authenticate(String loginToken) throws NgepAuthException {
		return this.generateSecurityPrincipalProfile(loginToken, null);
	}

	@Override
	public UserSecurityProfile getActiveSecuredProfile() throws NgepAuthException {
		return this.getCurrentSecuredProfile();
	}

	@Override
	public boolean hasPermission(String target, String action) throws NgepAuthException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserSecurityProfile register(ExecutionContext context) throws NgepAuthException {
		String confirmLink = null;
		UserSecurityProfile registrationProfile = null;
		CorpMimeMessage mimeMessage = null;
		try {
			registrationProfile = userAccountService.register((UserAccountProfile)context.get(CommunicatorConstants.CTX_USER_ACCOUNT));

			mimeMessage = (CorpMimeMessage)context.get(CommunicatorConstants.CTX_MIME_MESSAGE);
			if (null==mimeMessage) {
				mimeMessage = CorpMimeMessage.builder()
						.subject(CommunicatorConstants.CTX_DEFAULT_REGISTRATION_SUBJECT)
						.recipients(new String[] {registrationProfile.getUserAccount().getEmail()})
						.build();
			}
			mimeMessage.setRecipients(new String[] {registrationProfile.getUserAccount().getEmail()});
			mimeMessage.getDefinitions().put(CommunicatorConstants.CTX_USER_TOKEN, registrationProfile.getUserAccount().getActivationKey());

			confirmLink = (String)mimeMessage.getDefinitions().get(GlobalConstants.CONFIG_APP_ACCESS_URL);
			mimeMessage.getDefinitions().put(CommunicatorConstants.CTX_USER_CONFIRM_LINK, new StringBuilder(confirmLink).append(registrationProfile.getUserAccount().getActivationKey()).toString());

			context.put(CommunicatorConstants.CTX_MIME_MESSAGE, mimeMessage);

			emailCommunicator.send(context);
		} catch (Exception e) {
			throw new NgepAuthException(e);
		}
		return registrationProfile;
	}

	@Override
	public UserAccountProfile getUserAccount(String ssoId) throws ObjectNotFoundException {
		return userAccountService.get(ssoId);
	}

	@Override
	public UserSecurityProfile confirmByToken(String token) throws ObjectNotFoundException {
		UserSecurityProfile confirmedSecurityAccountProfile = UserSecurityProfile.builder().build();
		UserAccountProfile confirnUserAccount = null;
		AuthenticationDetails userDetails = tokenProvider.generateAuthenticationDetails(token);
		if (userDetails != null) {
			confirnUserAccount = this.getUserAccount(userDetails.getSsoId());
		}

		confirnUserAccount.addPrivilege(authorityService.getMinimumUserAuthority());
		confirnUserAccount.setActivated(Boolean.TRUE);
		confirnUserAccount.setVisible(Boolean.TRUE);
		confirnUserAccount.setActivationDate(DateTimeUtility.getSystemDateTime());

		userAccountService.save(confirnUserAccount);
		confirmedSecurityAccountProfile.setUserAccount(confirnUserAccount);
		return confirmedSecurityAccountProfile;
	}

	@Override
	public List<AccessDecisionPolicy> getAccessDecisionPolicies(String accessPattern) throws ObjectNotFoundException {
		return accessDecisionPolicyService.getAccessDecisionPolicies(accessPattern);
	}

	@Override
	public List<AccessDecisionPolicy> getAccessDecisionPolicies(AuthenticationDetails authenticationDetails) throws ObjectNotFoundException {
		List<AccessDecisionPolicy> accessDecisionPolicies = ListUtility.createDataList();
		List<AccessDecisionPolicy> currentADPs = null; 
		for (GrantedAuthority authority :authenticationDetails.getAuthorities()) {
			currentADPs = accessDecisionPolicyService.getAccessDecisionPoliciesByAuthority((Authority)authority);
			if (!currentADPs.isEmpty()) {
				accessDecisionPolicies.addAll(currentADPs);
			}
		}
		return accessDecisionPolicies;
	}

	@Override
	public boolean hasAccessDecisionPolicy(FilterInvocation filterInvocation, Authentication authentication) {
		final String MY_ACCESSED_DECISION_POLICIES = "myAccessedDecisionPolicies";
		boolean hasAccessedPermission = false;
		List<AccessDecisionPolicy> accessDecisionPolicies = null;
		List<AccessDecisionPolicy> currentADPs = null; 
		PathMatcher pathMatcher = null;

		accessDecisionPolicies = (List<AccessDecisionPolicy>)filterInvocation.getHttpRequest().getSession(false).getAttribute(MY_ACCESSED_DECISION_POLICIES);
    if (null==accessDecisionPolicies) {
    	accessDecisionPolicies = ListUtility.createDataList();
  		for (GrantedAuthority authority :authentication.getAuthorities()) {
  			currentADPs = accessDecisionPolicyService.getAccessDecisionPoliciesByAuthority((Authority)authority);
  			if (!currentADPs.isEmpty()) {
  				accessDecisionPolicies.addAll(currentADPs);
  			}
  		}

  		filterInvocation.getHttpRequest().getSession(false).setAttribute(MY_ACCESSED_DECISION_POLICIES, accessDecisionPolicies);
    }

		pathMatcher = new AntPathMatcher();
		for (AccessDecisionPolicy accessDecisionPolicy :accessDecisionPolicies) {
			if (pathMatcher.match(accessDecisionPolicy.getAccessPattern(), filterInvocation.getRequestUrl())) {
				hasAccessedPermission = true;
			}
		}

		return hasAccessedPermission;
	}

	@Override
	public UserAccountProfile saveSecurityAccountProfile(UserAccountProfile securityAccountProfile) throws NgepAuthException {
		if (CommonUtility.isEmpty(securityAccountProfile.getPassword())) {
			UserAccountProfile verifySecurityAccountProfile = this.userAccountService.getObject(securityAccountProfile.getId());
			securityAccountProfile.setPassword(verifySecurityAccountProfile.getPassword());
		}
		this.userAccountService.save(securityAccountProfile);
		return securityAccountProfile;
	}
}
