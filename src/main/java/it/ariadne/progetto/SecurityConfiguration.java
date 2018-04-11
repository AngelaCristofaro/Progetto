package it.ariadne.progetto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import it.ariadne.progetto.dao.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    MyUserDetailsService uds;
//	
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
//		auth.userDetailsService(uds);
//	}
	
    @Bean
    UserDetailsService customUserService() {
        return new MyUserDetailsService();
    }
	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
          .withUser("admin@admin.it").password("admin12345").roles("ADMIN");
        auth.userDetailsService(customUserService()); 
	}
	
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .authorizeRequests().and().formLogin()
      .loginPage("/login_utente")
      .loginProcessingUrl("/j_spring_security_check")
      .defaultSuccessUrl("/")
      .failureUrl("/login_utente?error=true")
      .usernameParameter("username")
      .passwordParameter("password");
    http.authorizeRequests().and().logout().logoutUrl("/j_spring_security_logout").logoutSuccessUrl("/login_utente?logout=true");
    http.csrf().disable();
    http.authorizeRequests().antMatchers("/login_utente").permitAll();
    http.authorizeRequests().antMatchers("/gestisci_risorse").access("hasRole('ADMIN')");
    http.authorizeRequests().antMatchers("/gestione_utenti").access("hasRole('ADMIN')");
    http.authorizeRequests().antMatchers("/all-prenotazioni").access("hasRole('ADMIN')");
    http.authorizeRequests().antMatchers("/save-prenotazione").authenticated();
    

}
}
