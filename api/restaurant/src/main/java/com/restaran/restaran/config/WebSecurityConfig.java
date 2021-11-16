package com.restaran.restaran.config;

import com.restaran.restaran.service.CustomDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    PasswordEncoder passwordEncoder;

    @Autowired
    CustomDetailsService cds;

    public WebSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
       // http
              //  .authorizeRequests()
              //  .antMatchers("/hellouser").permitAll()
               // .and()
               // .oauth2ResourceServer()
               // .jwt();



    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth.userDetailsService();
        //auth.inMemoryAuthentication().withUser("user").password(passwordEncoder.encode("password") ).roles("USER");
        auth.userDetailsService(cds);
    }

    //@Bean
   // public UserDetailsService userDetailsService() {
      //  return new InMemoryUserDetailsManager(
          //      User.withUsername("user1")
            //            .password(passwordEncoder.encode("password1"))
            //            .roles("USER")
              //          .build()
      //  );
   // }
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}