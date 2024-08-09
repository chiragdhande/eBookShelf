package com.example.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.io.IOException;
import io.jsonwebtoken.security.SignatureException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private Logger logger = LoggerFactory.getLogger(OncePerRequestFilter.class);

    @Autowired
    private JwtHelper jwtHelper;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // Authorization
        logger.info("Inside the JWT Authentication filter...");

        String requestHeader = request.getHeader("Authorization");
        logger.info("Header: {}", requestHeader);

        String username = null;
        String token = null;
              System.out.println("UserDetailsService");
        if (requestHeader != null && requestHeader.startsWith("Bearer")) {
            // Extracting the token
            token = requestHeader.substring(7);
            logger.info("Token: {}", token);

            try {
                // Validate the token and extract the username
                username = this.jwtHelper.getUsernameFromToken(token);

            } catch (SignatureException e) {
                // SignatureException indicates an issue with the JWT signature
                logger.error("Invalid token signature: {}", e.getMessage());
                handleInvalidToken(response, "Invalid token signature");
                return; // Return to avoid further processing after handling the exception
            } catch (IllegalArgumentException | ExpiredJwtException | MalformedJwtException e) {
                // Handle other JWT-related exceptions
                logger.error("JWT Exception: {}", e.getMessage());
                handleInvalidToken(response, "Invalid JWT");
                return; // Return to avoid further processing after handling the exception
            } catch (Exception e) {
                // Handle other exceptions
                logger.error("Exception: {}", e.getMessage());
                e.printStackTrace();
                handleInvalidToken(response, "Internal server error");
                return; // Return to avoid further processing after handling the exception
            }

        } else {
            logger.info("Invalid Header Value !! ");
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            // Fetch user details from username
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
            Boolean validateToken = this.jwtHelper.validateToken(token, userDetails);

            if (validateToken) {
                // Set the authentication
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else {
                logger.info("Validation fails !!");
            }
        }
        System.out.println("qqq");
        try {
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            // Handle other exceptions if needed
            logger.error("Exception during filter chain processing: {}", e.getMessage());
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    private void handleInvalidToken(HttpServletResponse response, String message) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        try {
			response.getWriter().write("{\"error\": \"" + message + "\"}");
		} catch (java.io.IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
