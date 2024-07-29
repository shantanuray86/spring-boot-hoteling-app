package com.hoteling.employees.service;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hoteling.employees.entity.AuthenticationResponse;
import com.hoteling.employees.entity.Employee;
import com.hoteling.employees.repository.EmployeeRepository;

@Service
public class AuthenticationService {

	    private final EmployeeRepository repository;
	    private final PasswordEncoder passwordEncoder;
	    private final JwtService jwtService;
	    private final AuthenticationManager authenticationManager;

	    public AuthenticationService(EmployeeRepository repository,
	                                 PasswordEncoder passwordEncoder,
	                                 JwtService jwtService,
	                                 AuthenticationManager authenticationManager) {
	        this.repository = repository;
	        this.passwordEncoder = passwordEncoder;
	        this.jwtService = jwtService;
	        this.authenticationManager = authenticationManager;
	    }
	    
	    
	    public AuthenticationResponse register(Employee request) {

	        // check if user already exist. if exist than authenticate the user
	        if(repository.findByEmail(request.getEmail()).isPresent()) {
	            return new AuthenticationResponse(null,"User already exist");
	        }

	        Employee user = new Employee();
	        user.setName(request.getName());
	        user.setEmail(request.getEmail());
	        user.setPhoneNumber(request.getPhoneNumber());
	        user.setPassword(passwordEncoder.encode(request.getPassword()));


	        user.setRole(request.getRole());

	        user = repository.save(user);

	        String accessToken = jwtService.generateAccessToken(user);


	        return new AuthenticationResponse(accessToken, "User registration was successful");

	    }
	    
	    public AuthenticationResponse authenticate(Employee request) {
	        authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(
	                        request.getUsername(),
	                        request.getPassword()
	                )
	        );

	        Employee user = repository.findByEmail(request.getEmail()).orElseThrow();
	        String accessToken = jwtService.generateAccessToken(user);




	        return new AuthenticationResponse(accessToken, "User login was successful");

	    }

	   
	  

	   
}
