package com.example.E_Commerce.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
@Service
public class JwtUtil {
    private static String SECRET_KEY = "a4aefdcc6d5b5ee348dfcf3545fb490958a9b456b2ca8c2415e9" +
            "876d0819a999d66f806f5c156c73219c4ed228a5a5ecc7f7a2661fcd88b471226062894" +
            "614fc6c7f718629d5ec4ec9a26898143a6ac15c97b4623c7bb57a27aa6a2aa65d4e4" +
            "f2fc9db786df11fd4514c374efc213b1f957d3438767bc7b9ab535ea10f62" +
            "037b7dc1625f2660d52d19e7e9ba0d751269f8179ef95e4983c1db92f681da9da125b70073" +
            "031db221b0ad291c6b8e3a97fa7dd79417a737219f2e405173c9972a13ca216713dd6d1564a65e8a01" +
            "c0e17dbce1c43c54db2a13" +
            "254d4b1f3bf917a5c8a1c777d40188a47b32065520e6b83d9201049341d6126b50d1a62f413cc7976e";


    public String generateToken(UserDetails userDetails) {
        Map<String, Object> map = new HashMap<>();
        String role = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(", "));
        map.put("role", role);
        return Jwts.builder()
                .addClaims(map)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() +60* 60*60*24))
                .setSubject(userDetails.getUsername())
                .signWith(getSignKey() , SignatureAlgorithm.HS256)
                .compact();
    }
    private Key getSignKey(){
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    public String extractUsername(String jwt) {
        return extractClaim(jwt, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean isTokenValid(String token , UserDetails userDetails){
        final String userName = extractUsername(token);
        return (userName.equals(userDetails.getUsername()))&& !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token , Claims::getExpiration);
    }
}
