package com.ecom.ecommerce.config;

import com.ecom.ecommerce.security.CustomUserDetailsService;
import com.ecom.ecommerce.security.JwtAuthenticationEntryPoint;
import com.ecom.ecommerce.security.JwtAuthenticationFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers(HttpMethod.POST, "/api/auth/signout")
                .hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
                .antMatchers("/api/auth/**").permitAll()
                //----------------BRAND-------------------------------------------------//
                .antMatchers(HttpMethod.GET,"/api/brand").hasAnyAuthority("ROLE_ADMIN","ROLE_USER")
                .antMatchers("/api/brand/**").hasAuthority("ROLE_ADMIN")
                //----------------category and sub-category-----------------------------//
                .antMatchers(HttpMethod.GET,"/api/category").hasAnyAuthority("ROLE_ADMIN","ROLE_USER")
                .antMatchers(HttpMethod.GET,"/api/category/sub").hasAnyAuthority("ROLE_ADMIN","ROLE_USER")
                .antMatchers("/api/category/**").hasAuthority("ROLE_ADMIN")
                //------------------------size------------------------------------------//
                .antMatchers(HttpMethod.GET,"/api/size").hasAnyAuthority("ROLE_ADMIN","ROLE_USER")
                .antMatchers("/api/size/**").hasAuthority("ROLE_ADMIN")
                //-------------------------product--------------------------------------//
                // .antMatchers(HttpMethod.GET,"/api/product").hasAnyAuthority("ROLE_ADMIN","ROLE_USER")
                // .antMatchers("/api/product/**").hasAuthority("ROLE_ADMIN")
                // //-------------------------cart-----------------------------------------//  
                // .antMatchers("/api/cart").hasAuthority("ROLE_USER")
                // //-------------------------order-----------------------------------------//
                // .antMatchers("/api/order").hasAuthority("ROLE_USER")
                // //-----------------------------------------------------------------------//
                // .antMatchers("/api/payment").hasAuthority("ROLE_USER")
                // //-------------------------order history---------------------------------//
                // .antMatchers("/api/history").hasAuthority("ROLE_USER")
                .anyRequest().authenticated();

        // Add our custom JWT security filter
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

    }
}