package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.RequestMatchers;

import com.example.security.JwtAuthenticationEntryPoint;
import com.example.security.JwtAuthenticationFilter;

@Configuration
public class SecurityConfig {
 

    @Autowired
    private JwtAuthenticationEntryPoint point;
    @Autowired
    private JwtAuthenticationFilter filter;
     @Autowired
     private UserDetailsService userDetailsService;
     @Autowired
     private PasswordEncoder passwordEncoder;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    	http.csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth
            .requestMatchers( "/api/productmaster", "/api/producttype","/api/productmaster/product/{Id}","/auth/getuserbyid/{Id}","/auth/getuser","/auth/update","/api/productmaster/updatequantitydecrase/{id}","/api/productmaster/updatequantityincrement/{id}").permitAll()
            .requestMatchers("/api/productmaster/getproductbylanguage/{Id}","/api/languageMaster/getlanguagebytypeid/{id}","/api/purchescontroller/getcartbycartid/{cartid}").permitAll()
            .requestMatchers("/auth/login","/auth/create-user","/api/cart","/api/myshelf","/api/cart/deleteAlL","/api/cart/deletecartbyid/{Id}","/api/purchescontroller").permitAll()
            .requestMatchers("/api/purchescontroller/delete/{id}","/api/Usermyshelf/add/{cartid}/{myshelfId}/{type}","/api/Usermyshelf/{id}","/api/history/{id}/{type}","/api/UserRentShelf/addRentShelf/{cartid}/{myshelfId}/{type}","/api/UserRentShelf/{id}","/api/Customer/{id}","/api/Customer/count/{id}").permitAll()
            .requestMatchers("/api/Publisher","/api/author","/api/Royalty/author/{id}","/api/Royalty/publisher/{id}","/api/backup/rent","/api/backup/buy").permitAll()
            .anyRequest().authenticated()
        )
        .exceptionHandling(ex -> ex.authenticationEntryPoint(point))
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
    http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
     @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider()
    {
    	DaoAuthenticationProvider provider =  new DaoAuthenticationProvider();
    	provider.setUserDetailsService(userDetailsService);
    	provider.setPasswordEncoder(passwordEncoder);
    	return provider;
    }
    
}