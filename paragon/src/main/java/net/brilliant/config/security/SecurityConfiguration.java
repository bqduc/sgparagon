/*
 * Copyright 2016-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.brilliant.config.security;

import javax.inject.Inject;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

import net.brilliant.auth.comp.jwt.JsonWebTokenService;
import net.brilliant.common.CommonConstants;
import net.brilliant.config.jwt.JwtSecurityConfigurer;
import net.brilliant.servlet.ServletConstants;

/**
 * Spring Security Configuration.
 *
 * @author ducbq
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Inject 
	protected DigesterEncryptorReporistory encryptoReporistory;

	@Inject
	private AuthenticationProvider globalAuthenticationProvider;

	@Inject
	private AccessDeniedHandler customAccessDeniedHandler;

  @Inject
  private CustomAuthenticationSuccessHandler authenticationSuccessHandler;
  
  @Inject
  private CustomAuthenticationFailureHandler authenticationFailureHandler;

  @Inject
  private JsonWebTokenService jwtTokenProvider;

	@Configuration
	@Order(1)
	public class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
		protected void configure(HttpSecurity http) throws Exception {
			// rest Login
			http.antMatcher(CommonConstants.REST_API + "**").authorizeRequests().anyRequest().fullyAuthenticated()/*.hasRole("ADMIN")*/
			.and()
			//.apply(new JwtConfigurer(jwtTokenProvider))
			.httpBasic().and().csrf()
					.disable()
			
					.apply(new JwtSecurityConfigurer(jwtTokenProvider))
			;
			
      CharacterEncodingFilter filter = new CharacterEncodingFilter();
      filter.setEncoding("UTF-8");
      filter.setForceEncoding(true);
      http.addFilterBefore(filter, CsrfFilter.class);			
		}
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(this.globalAuthenticationProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		configureAppSecurity(http);
	}

	private String[] unauthorizedMatchers() {
		String[] unauthorizedPatterns = new String[] { 
				ServletConstants.servletUrlMapping+"/**", 
				"/protected/**", 
				"/*", 
				"/public/**", 
				"/resources/**", 
				"/includes/**", 
				"/pages/public/**", 
				"/auth/register/**",
				"/login.xhtml", 
				"/javax.faces.resource/**"
		};
		return unauthorizedPatterns;
	}

  protected void configureAppSecurity(HttpSecurity http) throws Exception {
  	http
   		.csrf().disable()
      .authorizeRequests()
       	.antMatchers(unauthorizedMatchers()).permitAll()
       	.anyRequest().access("@authorizationChecker.check(request, authentication)")
      .and()
      	.formLogin()
      	.failureHandler(this.authenticationFailureHandler)
       	.successHandler(this.authenticationSuccessHandler)
        .loginPage("/login.xhtml")
        .failureUrl("/login.xhtml?authfailed=true").permitAll()
        .permitAll()
      .and()
      	.logout()
       		.logoutUrl("/j_spring_security_logout")
       		.logoutSuccessUrl("/index.jsf")
       		.invalidateHttpSession(true)
       		.deleteCookies("JSESSIONID")
          .permitAll()
      .and()
      	.authenticationProvider(this.globalAuthenticationProvider)
      	.exceptionHandling().accessDeniedHandler(this.customAccessDeniedHandler)

      .and()
      	.sessionManagement()
      	;
  }
}
