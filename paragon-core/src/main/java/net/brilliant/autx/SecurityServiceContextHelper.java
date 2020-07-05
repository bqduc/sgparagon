/**
 * 
 */
package net.brilliant.autx;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import net.brilliant.common.CommonUtility;
import net.brilliant.framework.component.CompCore;

/**
 * @author ducbq
 *
 */
@Component
public class SecurityServiceContextHelper extends CompCore {
	/**
	 * 
	 */
	private static final long serialVersionUID = -153276755116994867L;

	public String getAuthenticationName() {
		String authenticationName = CommonUtility.STRING_BLANK;
		Authentication auth = getAuthentication();
		if (null != auth) {
			authenticationName = auth.getName();
		}
		return authenticationName;
	}

	public Authentication getAuthentication() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication;
	}

	public Object getAuthenticationPrincipal() {
		Authentication authentication = this.getAuthentication();
		return (null != authentication)? authentication.getPrincipal():null;
	}
}
