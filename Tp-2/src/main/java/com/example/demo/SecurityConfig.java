package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity //(debug = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	 @Autowired
	 UserService userDetailsService;
	
	 @Override
	 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 auth.userDetailsService(userDetailsService);
	 }
	 @Override
	 protected void configure(HttpSecurity http) throws Exception {
		 http.csrf().disable();
		 //attribution du provider d’authentification
		 http.authenticationProvider(getProvider());
		 //la page login est accessible à tous sans login préalable (heureusement…)
		 http.authorizeRequests().antMatchers( "/login").permitAll();
		 //toutes les autres pages nécessitent une authentification
		 http.authorizeRequests().antMatchers("/*").authenticated();
		 http.authorizeRequests().antMatchers("/suite").authenticated();
		 //définition des champs du formulaire : à réspecter dans le formulaire.
		 //les noms utilisés doivent être rigoureusement les mêmes.
		 http.authorizeRequests().and().formLogin()
			 .loginProcessingUrl("/j_spring_security_check")
			 .loginPage("/login")
			 .failureForwardUrl("/erreur")
			 .defaultSuccessUrl("/suite" , true)
			 .usernameParameter("j_username")
			 .passwordParameter("j_password")
			 .and()
		    .logout()
	 		.logoutUrl("/logout")
	 //à mettre à la place de ci-dessus pour personnaliser le logout
	 //.logoutSuccessHandler(new AuthentificationLogoutSuccessHandler())
	 .invalidateHttpSession(true);
	 //a mettre à la place des autres paramètre du login pour personnalisation
	 //http.authorizeRequests().and().formLogin().successHandler(new AuthentificationLoginSuccessHandler());
	 System.out.println("conf HttpSecurity: " );
	 }
 //méthode qui retourne le provider pour l’authentification, issu de la classe AppAuthProvider
 //classe qui possède le code de traitement nom et password.
 @Bean
 public AuthenticationProvider getProvider() {
	 AppAuthProvider provider = new AppAuthProvider();
	 provider.setUserDetailsService(userDetailsService);
	 System.out.println("conf: getProvider");
	 return provider;
 }
}