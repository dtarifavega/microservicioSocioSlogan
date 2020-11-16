
package com.hiberus.prueba.socio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	/*
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.authorizeRequests()
         .antMatchers("/h2-console/**").permitAll()
         .antMatchers("/index.xhtml").permitAll()
        //.antMatchers("/listar/**").access("hasRole('ROLE_VIEW')")
        //.antMatchers("/crear/**").access("hasRole('ROLE_UPDATE')")
        //.antMatchers("/delete/**").access("hasRole('ROLE_DELETE')")
        //.anyRequest().authenticated()
        //.and()
        //.httpBasic()
        .and()
        .logout()
        .permitAll();

        http.csrf().disable();
        http.headers().frameOptions().disable();

    }
    */
	
	 
	 
	    @Configuration
		@Order(1)                                                        
		public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
			protected void configure(HttpSecurity http) throws Exception {
				http.authorizeRequests()
	
		        .antMatchers("/delete/**").access("hasRole('ROLE_DELETE')")                             
						.and()
					.httpBasic();
			}
		}

		

    
    
    @Bean
    public UserDetailsService userDetailsService() {

        User.UserBuilder users = User.withDefaultPasswordEncoder();
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(users.username("pepe").password("pepe").roles("VIEW").build());
        manager.createUser(users.username("admin").password("admin").roles("VIEW","UPDATE", "DELETE").build());
        manager.createUser(users.username("juan").password("juan").roles("VIEW", "UPDATE").build());
        return manager;

    }
    
   
}