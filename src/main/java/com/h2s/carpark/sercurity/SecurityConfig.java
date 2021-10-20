package com.h2s.carpark.sercurity;

import com.h2s.carpark.sercurity.jwt.JwtTokenAfterFilter;
import com.h2s.carpark.sercurity.jwt.JwtTokenBeforeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomUserDetailsService customUserDetailsSevice;

    @Autowired
    private JwtTokenBeforeFilter jwtTokenBeforeFilter;

    @Autowired
    private JwtTokenAfterFilter jwtTokenAfterFilter;

    @Bean
    public PasswordEncoder passwordEncoder(){
        // Round crypt password is 12
        return new BCryptPasswordEncoder(12);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .cors().and().csrf().disable()
                .addFilterBefore(jwtTokenBeforeFilter, BasicAuthenticationFilter.class)
                .addFilterAfter(jwtTokenAfterFilter,BasicAuthenticationFilter.class);
        http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
        auth.userDetailsService(customUserDetailsSevice)
                .passwordEncoder(passwordEncoder());
    }
}
