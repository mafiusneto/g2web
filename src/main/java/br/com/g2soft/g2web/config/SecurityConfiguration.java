package br.com.g2soft.g2web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable();
		
		httpSecurity.httpBasic().and()
				.authorizeRequests()
					.antMatchers("/")
					.permitAll()
				.anyRequest()
					.authenticated()
					.and()
				.formLogin()
					.loginPage("/login")
					.failureUrl("/login?error").and()
					.logout().permitAll().logoutSuccessUrl("/login");
					
	}
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("admin").password("admin").roles("ADMIN")
                .and().withUser("user").password("user").roles("USER");;
    }
	
}
