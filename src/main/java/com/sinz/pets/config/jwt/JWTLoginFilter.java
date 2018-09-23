package com.sinz.pets.config.jwt;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {

	 public JWTLoginFilter(String url, AuthenticationManager authManager) {
	    super(new AntPathRequestMatcher(url));
	    setAuthenticationManager(authManager);
	  }

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
			throws AuthenticationException, IOException, ServletException {
		
		AccountCredentials creds = new ObjectMapper()
		        .readValue(req.getInputStream(), AccountCredentials.class);
		
		    		
		    return getAuthenticationManager().authenticate(
		        new UsernamePasswordAuthenticationToken(
		            creds.getUserName(),
		            creds.getPassword(),
		           // Arrays.asList(new SimpleGrantedAuthority("ADMIN"))
		            Collections.emptyList()
		        )
		    );
		
	}
	
	@Override
	  protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
	      Authentication auth) throws IOException, ServletException {
		
	    TokenAuthenticationService
	        .addAuthentication(res, auth.getName());
	  }

}
