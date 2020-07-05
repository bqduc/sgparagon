/**
 * 
 */
package net.brilliant.config.jwt;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import net.brilliant.auth.comp.jwt.JsonWebTokenService;

/**
 * @author ducbq
 *
 */
public class JwtSecurityConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
  private JsonWebTokenService jwtTokenProvider;

  public JwtSecurityConfigurer(JsonWebTokenService jwtTokenProvider) {
      this.jwtTokenProvider = jwtTokenProvider;
  }

  @Override
  public void configure(HttpSecurity http) throws Exception {
      JwtTokenFilter customFilter = new JwtTokenFilter(jwtTokenProvider);
      http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
  }
}
