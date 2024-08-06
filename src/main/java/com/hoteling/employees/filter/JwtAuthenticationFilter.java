package com.hoteling.employees.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.hoteling.employees.exceptions.Status;
import com.hoteling.employees.service.JwtService;
import com.hoteling.employees.service.UserDetailsServiceImp;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;
import java.io.PrintWriter;
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{
	
	private Gson gson = new Gson();
	@Autowired
JwtService jwtService;
	
	@Autowired
HandlerExceptionResolver handlerExceptionResolver;
	
	@Autowired
UserDetailsServiceImp userDetailsService;


//	    public JwtAuthenticationFilter(JwtService jwtService, UserDetailsServiceImp userDetailsService,HandlerExceptionResolver handlerExceptionResolver) {
//	        this.jwtService = jwtService;
//	        this.userDetailsService = userDetailsService;
//	        this.handlerExceptionResolver = handlerExceptionResolver;
//	    }

	    @Override
	    protected void doFilterInternal(
	            @NonNull HttpServletRequest request,
	             @NonNull HttpServletResponse response,
	             @NonNull FilterChain filterChain)
	            throws ServletException, IOException {

	        String authHeader = request.getHeader("Authorization");
	        
	        

	        if(authHeader == null || !authHeader.startsWith("Bearer ")) {

        	System.out.println(request.getRequestURI());
        	String url = request.getRequestURI();
        	
	        if(url.equals("/register") || url.equals("/login")) {
	        	   System.out.println("drrtdd"+ request.getRequestURI());
	        	   filterChain.doFilter(request,response);
	           }else {
	        	   Status st = new Status();
	        	   st.setCode("401");
	               st.setMessage("unauthorized");
	               st.setStatus("Error");
	             
	        	   //response.toString().getWriter().set.write("hehehe Unauthorized");
	        	   response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	        	   
	        	   String employeeJsonString = this.gson.toJson(st);

	               PrintWriter out = response.getWriter();
	               response.setContentType("application/json");
	               response.setCharacterEncoding("UTF-8");
	               out.print(employeeJsonString);
	               out.flush(); 
	           }

	            return;
	        }

	        try {
	        String token = authHeader.substring(7);
	        String username = jwtService.extractUsername(token);

	        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

	            UserDetails userDetails = userDetailsService.loadUserByUsername(username);


	            if(jwtService.isValid(token, userDetails)) {
	                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
	                        userDetails, null, userDetails.getAuthorities()
	                );

	                authToken.setDetails(
	                        new WebAuthenticationDetailsSource().buildDetails(request)
	                );

	                SecurityContextHolder.getContext().setAuthentication(authToken);
	            }
	        }
	        filterChain.doFilter(request, response);
	        } catch (Exception exception) {
	            handlerExceptionResolver.resolveException(request, response, null, exception);
	        }

	    }
}
