package com.accel.counsel.security;

import com.accel.counsel.model.UserEntity;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenProvider {
    private static final String SECRET_KEY = "securekey123";

    public String createToken(UserEntity userEntity) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + 86400000); // 1 day

        return Jwts.builder()
                .setSubject(Long.toString(userEntity.getId()))
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    public Long validateTokenAndGetUserId(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
        return Long.parseLong(claims.getSubject());
    }
}
