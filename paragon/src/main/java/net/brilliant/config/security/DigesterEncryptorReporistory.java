/**
 * 
 */
package net.brilliant.config.security;

import java.security.SecureRandom;
import java.util.regex.Pattern;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author ducbq
 *
 */
@Component
public class DigesterEncryptorReporistory {
	public PasswordEncoder getSCryptPasswordEncoder() {
		int cpuCost = (int) Math.pow(2, 14); // factor to increase CPU costs
		int memoryCost = 8;      // increases memory usage
		int parallelization = 1; // currently not supported by Spring Security
		int keyLength = 32;      // key length in bytes
		int saltLength = 64;     // salt length in bytes

		SCryptPasswordEncoder sCryptPasswordEncoder = new SCryptPasswordEncoder(
		  cpuCost, 
		  memoryCost,
		  parallelization,
		  keyLength,
		  saltLength);
		
		return sCryptPasswordEncoder;
	}

	public PasswordEncoder getBCryptPasswordEncoder() {
		int strength = 10; // work factor of bcrypt
		 BCryptPasswordEncoder bCryptPasswordEncoder =
		  new BCryptPasswordEncoder(strength, new SecureRandom());
		
		return bCryptPasswordEncoder;
	}
	
	/*public static void main(String[] args) {
		String regex = "^$$e0801$$*?=";//"^$e0801$ =$";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		
		PasswordEncoder passwordEncoder = new DigesterEncryptorReporistory().getSCryptPasswordEncoder();
		String passBase = "KhongLamPassword";
		String encoded = "";
		for (int i = 0; i < 10; i++) {
			encoded = passwordEncoder.encode(new StringBuilder(passBase).append(i).toString());
			System.out.println(pattern.matcher(encoded).find() + "\t" + encoded);
		}
	}*/
}
