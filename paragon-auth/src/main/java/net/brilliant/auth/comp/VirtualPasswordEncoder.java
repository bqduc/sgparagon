package net.brilliant.auth.comp;
/**
 * 
 *//*
package net.paramount.auth.comp;

import javax.inject.Named;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import net.paramount.auth.constants.AuxGlobalConstants;

*//**
 * @author ducbq
 *
 *//*
@Named("virtualPasswordEncoder")
@Component
public class VirtualPasswordEncoder implements PasswordEncoder extends BCryptPasswordEncoder {
	private final static PasswordEncoder innnerPasswordEncoder = new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();

	@Override
	public String encode(CharSequence plainTextPassword) {
		String hashed = BCrypt.hashpw(preConstructPassword(plainTextPassword.toString()), BCrypt.gensalt(12));
		return hashed;
	}

	@Override
	public boolean matches(CharSequence plainTextPassword, String encodedPassword) {
		String upgradedPassword = this.encode(plainTextPassword);
		return BCrypt.checkpw(upgradedPassword, encodedPassword);
	}


	
	@Override
	public String encode(CharSequence plainTextCredential) {
		String upgradedCredential = this.preConstructPassword(plainTextCredential.toString());
		return getPasswordEncoder().encode(upgradedCredential);
	}

	@Override
	public boolean matches(CharSequence plainTextCredential, String encodedCredential) {
		String upgradedCredential = this.encode(plainTextCredential);
		return getPasswordEncoder().matches(upgradedCredential, encodedCredential);
	}

	private String preConstructPassword(String rawPassword) {
		return rawPassword;//new StringBuilder(rawPassword).append(AuxGlobalConstants._SALT_EXTENDED).toString();
	}

	private PasswordEncoder getPasswordEncoder() {
		return innnerPasswordEncoder;//new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
	}
}
*/