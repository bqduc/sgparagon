/**
 * 
 */
package net.brilliant.config.security;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import net.brilliant.auth.entity.AccessDecisionPolicy;
import net.brilliant.auth.entity.Authority;
import net.brilliant.auth.model.AccessDecision;
import net.brilliant.auth.service.AccessDecisionPolicyService;
import net.brilliant.common.CommonConstants;
import net.brilliant.common.ListUtility;

/**
 * @author ducbq
 *
 */
@Component
public class AuthorizationChecker {
	
	@Inject
	private AccessDecisionPolicyService accessDecisionPolicyService;

	private boolean doCheck(HttpServletRequest request, Authentication authentication) {
		if (authentication == null || CommonConstants.ANONYMOUS_USER.equals(authentication.getPrincipal())) {
			return false;
		}

		final String MY_ACCESSED_DECISION_POLICIES = "myAccessedDecisionPolicies";
		boolean hasAccessedPermission = false;
		List<AccessDecisionPolicy> accessDecisionPolicies = null;
		List<AccessDecisionPolicy> currentADPs = null; 
		PathMatcher pathMatcher = null;

		accessDecisionPolicies = (List<AccessDecisionPolicy>)request.getSession(false).getAttribute(MY_ACCESSED_DECISION_POLICIES);
    if (null==accessDecisionPolicies) {
    	accessDecisionPolicies = ListUtility.createDataList();
  		for (GrantedAuthority authority :authentication.getAuthorities()) {
  			currentADPs = accessDecisionPolicyService.getAccessDecisionPoliciesByAuthority((Authority)authority);
  			if (!currentADPs.isEmpty()) {
  	  		for (AccessDecisionPolicy accessDecisionPolicy :currentADPs) {
  	  			if (AccessDecision.ACCESS_GRANTED.equals(accessDecisionPolicy.getAccessDecision())) {
  	  				accessDecisionPolicies.add(accessDecisionPolicy);
  	  			}
  	  		}
  			}
  		}

  		request.getSession(false).setAttribute(MY_ACCESSED_DECISION_POLICIES, accessDecisionPolicies);
    }

		pathMatcher = new AntPathMatcher();
		for (AccessDecisionPolicy accessDecisionPolicy :accessDecisionPolicies) {
			if (pathMatcher.match(accessDecisionPolicy.getAccessPattern(), request.getRequestURI())) {
				hasAccessedPermission = true;
			}
		}
		return hasAccessedPermission;
	}

	public boolean check(HttpServletRequest request, Authentication authentication) {
		return this.doCheck(request, authentication);
	}

	/*
	public boolean check(HttpServletRequest request, Authentication authentication) {
		Object principalObj = authentication.getPrincipal();

		if (!(principalObj instanceof User)) {
			return false;
		}

		String authority = null;
		for (SecurityUrlMatcher matcher : urlMatcherRepository.findAll()) {
			if (new AntPathMatcher().match(matcher.getUrl(), request.getRequestURI())) {
				authority = matcher.getAuthority();
				break;
			}
		}

		String userId = ((User) authentication.getPrincipal()).getUserId();
		User loggedUser = userRepository.findByUserId(userId);

		List<String> authorities = loggedUser.getAuthority();

		if (authority == null || !authorities.contains(authority)) {
			return false;
		}
		return true;
	}*/
}
