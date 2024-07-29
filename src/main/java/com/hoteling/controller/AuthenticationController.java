package com.hoteling.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hoteling.employees.entity.AuthenticationResponse;
import com.hoteling.employees.entity.Employee;
import com.hoteling.employees.service.AuthenticationService;

@RestController
public class AuthenticationController {
	
	 private final AuthenticationService authService;

	    public AuthenticationController(AuthenticationService authService) {
	        this.authService = authService;
	    }
	    
	    
	    @PostMapping("/register")
	    public ResponseEntity<AuthenticationResponse> register(@RequestBody Employee request) {
	        return ResponseEntity.ok(authService.register(request));
	    }
	    
	    @PostMapping("/login")
	    public ResponseEntity<AuthenticationResponse> login(
	            @RequestBody Employee request
	    ) {
	        return ResponseEntity.ok(authService.authenticate(request));
	    }

}
