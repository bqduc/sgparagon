package net.brilliant.config.security.intercept;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import net.brilliant.auth.intercept.CustomAuthenticationProvider;
import net.brilliant.framework.component.CompCore;

/**
 * Created by aLeXcBa1990 on 24/11/2018.
 * 
 */
@Named
@Component
public class GlobalAuthenticationProvider extends CompCore implements AuthenticationProvider {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8355652678792800184L;

	@Inject
	private CustomAuthenticationProvider customAuthenticationProvider;

	@Inject
	private MVPCustomAuthenticationProvider mvpCustomAuthenticationProvider;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		Authentication authObject = customAuthenticationProvider.authenticate(authentication);
		if (null==authObject){
			authObject = mvpCustomAuthenticationProvider.authenticate(authentication);
		}
		return authObject;
	}

	@Override
	public boolean supports(Class<? extends Object> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}
}
