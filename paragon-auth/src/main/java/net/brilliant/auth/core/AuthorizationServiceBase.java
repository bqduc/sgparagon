/**
 * 
 */
package net.brilliant.auth.core;

import javax.inject.Inject;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import net.brilliant.auth.domain.UserSecurityProfile;
import net.brilliant.auth.entity.UserAccountPrivilege;
import net.brilliant.auth.entity.UserAccountProfile;
import net.brilliant.auth.service.UserAccountService;
import net.brilliant.common.CommonConstants;
import net.brilliant.common.CommonUtility;
import net.brilliant.exceptions.EcosExceptionCode;
import net.brilliant.exceptions.NgepAuthException;

/**
 * @author ducbq
 *
 */
public abstract class AuthorizationServiceBase {
	@Inject
	protected UserAccountService userAccountService;

	protected UserSecurityProfile generateSecurityPrincipalProfile(String authenticateToken, String password) throws NgepAuthException {
		UserAccountProfile userAccount = null;
		UserSecurityProfile securityAccountProfile = null;
		if (CommonUtility.isEmpty(password)) {
			userAccount = this.userAccountService.getUserAccount(authenticateToken);
		} else {
			userAccount = this.userAccountService.getUserAccount(authenticateToken, password);
		}

		if (null==userAccount)
			throw new NgepAuthException(EcosExceptionCode.ERROR_INVALID_PROFILE, "There is empty authentication user account");

		securityAccountProfile = UserSecurityProfile.builder()
		.userAccount(userAccount)
		.build();
		for (UserAccountPrivilege userAccountPrivilege :userAccount.getPrivileges()) {
			securityAccountProfile.addGrantedAuthority(userAccountPrivilege.getAuthority());
		}

		return securityAccountProfile;
	}

	protected UserSecurityProfile getCurrentSecuredProfile() throws NgepAuthException {
		UserSecurityProfile fetchedResponse = null;
		Object systemPrincipal = getSystemPrincipal();
		UserAccountProfile userAccount = null;
		if (systemPrincipal instanceof User || systemPrincipal instanceof UserAccountProfile) {
			userAccount = this.userAccountService.get(((User)systemPrincipal).getUsername());
			fetchedResponse = UserSecurityProfile
			.builder()
			.displayName(new StringBuilder(userAccount.getFirstName()).append(CommonConstants.STRING_SPACE).append(userAccount.getLastName()).toString())
			.userAccount(userAccount)
			.build();
		} else if (systemPrincipal instanceof String){ //Anonymous user - Not logged in
			if (CommonConstants.ANONYMOUS_USER.equalsIgnoreCase((String)systemPrincipal)) {
				fetchedResponse = UserSecurityProfile.builder()
						.displayName((String)systemPrincipal)
						.build();
			} else {
				userAccount = this.userAccountService.get((String)systemPrincipal);
				fetchedResponse = UserSecurityProfile
				.builder()
				.displayName(new StringBuilder(userAccount.getFirstName()).append(CommonConstants.STRING_SPACE).append(userAccount.getLastName()).toString())
				.userAccount(userAccount)
				.build();
			}
		}
		return fetchedResponse;
	}

	protected Authentication getAuthentication() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication;
	}

	protected Object getAuthenticationPrincipal() {
		Authentication authentication = this.getAuthentication();
		return (null != authentication)? authentication.getPrincipal():null;
	}

	protected Object getSystemPrincipal() {
		Authentication authentication = this.getAuthentication();
		if (null==authentication)
			return null;

		if (authentication.getPrincipal() instanceof String) {
			return authentication.getPrincipal();
		}

		return authentication.getPrincipal();
	}

}
