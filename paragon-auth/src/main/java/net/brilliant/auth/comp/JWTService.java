/**
 * 
 */
package net.brilliant.auth.comp;

import javax.servlet.http.HttpServletRequest;

import net.brilliant.framework.entity.auth.AuthenticationDetails;

/**
 * @author ducbq
 *
 */
public interface JWTService {
  /**
  * Generate the JWeb token base on the authentication detail. The generated token will be expired in 7 days from generated time
  * @param authenticationDetails The authentication detail object to be generated. 
  * @return String Generated JWeb token.
  */
  String generateToken(AuthenticationDetails authenticationDetails);

  /**
  * Generate the JWeb token base on the authentication detail. The generated token will be expired in 20 years from generated time, can be considered as indefinite. 
  * @param authenticationDetails The authentication detail object to be generated. 
  * @return String Generated JWeb token.
  */
  String generateIndefiniteToken(AuthenticationDetails authenticationDetails);

  /**
  * Generate the JWeb token base on the authentication detail. The generated token will be expired in 7 days from generated time
  * @param jWebToken The web token string to be generated to authentication details object. 
  * @return AuthenticationDetails Generated AuthenticationDetails.
  */
  AuthenticationDetails generateAuthenticationDetails(String jWebToken);

  /**
  * Validate the token is indefinite or not
  * @param jWebToken The web token string to be checked. 
  * @return Boolean True if corrected, otherwise false.
  */
  boolean isIndefiniteToken(String jWebToken);

  /**
  * Validate the JWeb token is corrected or not. 
  * @param jWebToken The web token string to be validated. 
  * @return Boolean True if corrected, otherwise false.
  */
  boolean validateToken(String jWebToken);

  String resolveToken(HttpServletRequest req);
}
