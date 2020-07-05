/**
 * 
 */
package net.brilliant.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ducbq
 *
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
	/*@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(CommonUtility.LOCALE_VIETNAMESE); // change this
		return localeResolver;
	}*/

  @Bean
  public PasswordEncoder passwordEncoder() {
  	//return encryptoReporistory.getSCryptPasswordEncoder();
  	return new BCryptPasswordEncoder();/*virtualPasswordEncoder*/
  }
}
