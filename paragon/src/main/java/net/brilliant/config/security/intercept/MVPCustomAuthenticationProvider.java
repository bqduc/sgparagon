package net.brilliant.config.security.intercept;

import java.util.ArrayList;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import net.brilliant.common.CommonUtility;
import net.brilliant.exceptions.NgepAuthException;
import net.brilliant.framework.component.CompCore;

/**
 * Created by aLeXcBa1990 on 24/11/2018.
 * 
 */
@Component
public class MVPCustomAuthenticationProvider extends CompCore implements AuthenticationProvider {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4215721965758008601L;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		Authentication authenticateResp = null;
		try {
			if (authentication.getName().length() < 150) {
				authenticateResp = authenticateBySsoId(authentication.getName(), authentication.getCredentials().toString());
			} else {
				authenticateResp = authenticateByToken(authentication.getName());
			}
		} catch (NgepAuthException cae) {
			log.error(cae);
			throw cae;
		}
		return authenticateResp;
	}

	@Override
	public boolean supports(Class<? extends Object> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

	private Authentication authenticateBySsoId(String ssoId, String password) throws NgepAuthException {
		Authentication authObject = null;
		try {
			if ("admin".equals(ssoId) && "admin".equals(password)) {
				authObject = buildAuthentication();
			}
		} catch (Exception uae) {
			throw new NgepAuthException(uae);
		}

		return authObject;
	}

	private Authentication authenticateByToken(String token) throws NgepAuthException {
		final String tokenVerifier = "ZXlKaGJHY2lPaUpJVXpVeE1pSjkuZXlKemRXSWlPaUl5TnlOemRXSnpZM0pwWW1WeUxuSmxjM1J5YVdOMFpXUWlMQ0pwWVhRaU9qRTFPVEU1TWpFM05EVXNJbVY0Y0NJNk1qVXpPRFV5TURFME5YMC40UVAyVTFVNHZPWF94UUZNaFZDcmVpS3lPdUdZYldma1k2cXQ0Q09IRGJoQ0ptYS1ZNnZFZXU4MjR0WXEzMVFENFZQWDk1MEk5eHJOUWg4UWlHVzgwUQ==";
		Authentication authByToken = null;
		try {
			if (tokenVerifier.equals(token)){
				authByToken = buildAuthentication();
			}
		} catch (Exception e) {
			throw new NgepAuthException(e);
		}

		return authByToken;
	}

	private Authentication buildAuthentication(){
		return new UsernamePasswordAuthenticationToken(CommonUtility.STRING_BLANK, CommonUtility.STRING_BLANK, new ArrayList<>());
	}
}
