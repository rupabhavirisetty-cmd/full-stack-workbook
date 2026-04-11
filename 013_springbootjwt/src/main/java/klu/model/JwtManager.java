package klu.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;


@Service
public class JwtManager {
	public final String SECRET_KEY = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
	public final SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
	
	//Generate JWT
	public String generateJWT(String username) throws Exception{
		//Dictionary in the form of key-value pair
		Map<String, String> payload = new HashMap<String, String>();
		payload.put("username", username);
		return Jwts.builder()
				.claims(payload)
				.issuedAt(new Date())
				.expiration(new Date(new Date().getTime() + 86400000))
				.signWith(key)
				.compact();			
	}
	
	//Validate JWT
	public Map<String, String> ValidateJWT(String token) throws Exception{
		Claims claims = Jwts.parser()
				            .verifyWith(key)
				            .build()
				            .parseSignedClaims(token)
				            .getPayload();
		
		Date expiration = claims.getExpiration();
		Map<String, String> payload = new HashMap<String, String>();
		if(expiration == null || expiration.before(new Date())) {
			payload.put("code", "401");
			payload.put("msg", "Invalid Token!");
		}
		
//			return "Ivalid Token";
		
//		Map<String, String> payload = new HashMap<String, String>();
		else {
			payload.put("code", "200");
		    payload.put("username", claims.get("username",String.class));
		}
		return payload;
	}
}
