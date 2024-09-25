package com.example.moodie.util;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.example.moodie.entity.User;
import java.util.Date;

@Component
public class JwtProvider {

    @Value("${jwt.secret}")
    private String secretKey;

    private static String SECRET_KEY;

    @PostConstruct
    public void init() {
        System.out.println("Initializing JwtConfig with secretKey: " + secretKey);
        SECRET_KEY = secretKey;
    }

    public static String getSecretKey() {
        return SECRET_KEY;
    }

    public static String generateToken(User user) throws JOSEException {
        JWSSigner signer = new MACSigner(SECRET_KEY);

        // Add claims
        JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                .subject(user.getUserId().toString()) // subject - unique username
                .issuer("moodie.tv") // issuer claim
                .claim("scope", serializeRoles(user)) // custom claim for user's roles
                .expirationTime(new Date(new Date().getTime() + 86400000)) // expiration time: 1 day
                .issueTime(new Date()) // issue time
                .jwtID("unique-jwt-id-" + user.getUserId()) // JWT ID
                .build();

        // Create and sign the JWT
        SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS512), claimsSet);
        signedJWT.sign(signer);

        // Serialize the signed JWT to a compact, URL-safe string
        return signedJWT.serialize();
    }

    private static String serializeRoles(User user) {
        StringBuilder scope = new StringBuilder(); // Sử dụng StringBuilder để thay đổi giá trị chuỗi

        user.getRoles().forEach(item -> {
            scope.append(item.getRole().getRoleName()).append(" ");
        });

        return scope.toString().trim(); // Trả về chuỗi và loại bỏ khoảng trắng thừa
    }


}
