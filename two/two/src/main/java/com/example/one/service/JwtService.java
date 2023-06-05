package com.example.one.service;

import com.example.one.model.Color;
import com.example.one.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtService {

    private Log logger = LogFactory.getLog(this.getClass());

    @Value("${secret.key}")
    private String secretKey;

    private final Long expiredTime = 1000 * 60L * 60L * 3L; // 유효시간 3시간

    public String generateJwtToken(User user) {
        Date now = new Date();
        return Jwts.builder()
                .setSubject(user.getUserName()) // 보통 username
                .setHeader(createHeader())
                .setClaims(createClaims(user)) // 클레임, 토큰에 포함될 정보
                .setExpiration(new Date(now.getTime() + expiredTime)) // 만료일
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    private Map<String, Object> createHeader() {
        Map<String, Object> header = new HashMap<>();
        header.put("typ", "JWT");
        header.put("alg", "HS256"); // 해시 256 사용하여 암호화
        header.put("regDate", System.currentTimeMillis());
        return header;
    }

    private Map<String, Object> createClaims(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userName", user.getUserName()); // username
        claims.put("role", "normal"); // 인가정보
        return claims;
    }

    private Claims getClaims(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
    }

    public String getUserNameToken(String token) {
        return (String) getClaims(token).get("userName");
    }

}
