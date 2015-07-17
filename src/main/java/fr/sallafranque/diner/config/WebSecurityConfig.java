package fr.sallafranque.diner.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.AuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/inscription").permitAll()
			.anyRequest().authenticated()
			.and().formLogin().loginProcessingUrl("/login").defaultSuccessUrl("/utilisateur/courant", true).permitAll()
			.and().logout().permitAll();
		
		http.csrf().disable();
		
		http.exceptionHandling().authenticationEntryPoint(new AuthenticationEntryPoint() {

	        @Override
	        public void commence(HttpServletRequest request, HttpServletResponse response,
	                AuthenticationException authException) throws IOException, ServletException {
	            if (authException != null) {
	                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	                response.getWriter().print("Access denied");
	            }
	        }
	    });
		
		super.configure(http);
	}

	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.userDetailsService(userDetailsService);
		auth.jdbcAuthentication().dataSource(dataSource);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/webjars/**").antMatchers("/css/**").antMatchers("/js/**");
	}

}
