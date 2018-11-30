package com.book.healthapp.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
		
	@Autowired
    private CustomAuthenticationProvider authProvider;

	@Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
	
	@Override
	protected void configure(AuthenticationManagerBuilder authBuilder) {
		System.out.println("authenticationProvider");
		authBuilder.authenticationProvider(this.authProvider);
	}

	/*@Override
	// так работает без oath2 с разделением доступов для доктора и пользователя
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("HttpSecurity");
		http
				.authorizeRequests()
				.antMatchers("/rx/new/**").hasAnyRole("DOCTOR")
				.antMatchers("/**").hasAnyRole("DOCTOR","USER")
				.and()
				.formLogin()
				.and()
				.csrf().disable();
	}*/

}