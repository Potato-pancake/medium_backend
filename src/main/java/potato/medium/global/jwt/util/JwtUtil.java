package potato.medium.global.jwt.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import potato.medium.global.jwt.auth.AuthDetailsService;
import potato.medium.global.jwt.auth.AuthDetails;

import java.util.Collections;

@Component
@RequiredArgsConstructor
public class JwtUtil {

    private final AuthDetailsService authDetailsService;

    @Value("${jwt.secret_key}")
    private String secretKey;

    @Value("${jwt.prefix}")
    private String prefix;

    public String resolveJwt(HttpServletRequest request) {
        String bearer = request.getHeader("Authentication");

        if(bearer == null || !bearer.startsWith(prefix)) {
            return null;
        }

        return bearer.split(" ")[1].trim();
    }

    public Authentication getAuthentication(String token) {
        AuthDetails authDetails = (AuthDetails) authDetailsService.loadUserByUsername(extractUserId(token));
        return new UsernamePasswordAuthenticationToken(authDetails, token, Collections.emptyList());
    }

    public Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private String extractUserId(String token) {
        return getClaims(token).get("userId").toString();
    }
}
