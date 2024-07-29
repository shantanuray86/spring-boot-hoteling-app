package com.hoteling.employees.service;

import java.util.Date;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.hoteling.employees.entity.Employee;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {


    private String secretKey ="4bb6d1dfbafb64a681139d1586b6f1160d18159afd57c8c79136d7490630407c";

    private long accessTokenExpire = 86400000;
	
    public String generateAccessToken(Employee user) {
        return generateToken(user, accessTokenExpire);
    }
	 private String generateToken(Employee user, long expireTime) {
	        String token = Jwts
	                .builder()
	                .subject(user.getUsername())
	                .issuedAt(new Date(System.currentTimeMillis()))
	                .expiration(new Date(System.currentTimeMillis() + expireTime ))
	                .signWith(getSigninKey())
	                .compact();

	        return token;
	    }
	 
	 private SecretKey getSigninKey() {
	        byte[] keyBytes = Decoders.BASE64URL.decode(secretKey);
	        return Keys.hmacShaKeyFor(keyBytes);
	    }
	 
	 private Claims extractAllClaims(String token) {
	        return Jwts
	                .parser()
	                .verifyWith(getSigninKey())
	                .build()
	                .parseSignedClaims(token)
	                .getPayload();
	    }
	 
	 public <T> T extractClaim(String token, Function<Claims, T> resolver) {
	        Claims claims = extractAllClaims(token);
	        return resolver.apply(claims);
	    }
	 
	 public String extractUsername(String token) {
	        return extractClaim(token, Claims::getSubject);
	    }


    public boolean isValid(String token, UserDetails user) {
        String username = extractUsername(token);



        return (username.equals(user.getUsername())) && !isTokenExpired(token);
    }
    
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }
    
    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
}
