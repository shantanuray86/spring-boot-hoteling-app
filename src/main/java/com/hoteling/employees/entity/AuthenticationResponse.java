package com.hoteling.employees.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthenticationResponse {
	  @JsonProperty("access_token")
	    private String accessToken;

	    @JsonProperty("refresh_token")
	    private String refreshToken;

	    @JsonProperty("message")
	    private String message;

	    public AuthenticationResponse(String accessToken, String message) {
	        this.accessToken = accessToken;
	        this.message = message;

	    }

	    public String getAccessToken() {
	        return accessToken;
	    }



	    public String getMessage() {
	        return message;
	    }
}
