package com.example.miniproject.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	  http.cors().disable()
          .addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
          .authorizeRequests()  
          .antMatchers(HttpMethod.POST).permitAll()//allow CORS option calls
          .antMatchers(HttpMethod.GET).permitAll()//allow CORS option calls
          .antMatchers("/dashboard/**").permitAll()
          .antMatchers("/api/offer/getImage/**").permitAll()
          .antMatchers("/auth/api/**").permitAll()
          .anyRequest().authenticated();
  http
          .csrf().disable();

}
@Bean
public BCryptPasswordEncoder passwordEncoder(){
  return new BCryptPasswordEncoder();
}


}