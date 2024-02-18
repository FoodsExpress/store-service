package com.foodexpress.storeservice.common.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
public class Jwt {

    private final String issuer;
    private final Algorithm algorithm;

    private final JWTVerifier jwtVerifier;

    public Jwt(String issuer, String secretKey) {
        this.issuer = issuer;
        this.algorithm = Algorithm.HMAC512(secretKey);
        this.jwtVerifier = JWT.require(algorithm).withIssuer(issuer).build();
    }

    public Claims verify(String token) throws JWTVerificationException {
        return new Claims(jwtVerifier.verify(token));
    }

    @Data
    public static class Claims {

        private Long id;
        private String accountId;
        private String email;
        private String nickname;
        private String[] roles;
        private Date iat;
        private Date exp;

        private Claims() {/*empty*/}

        Claims(DecodedJWT decodedJWT) {
            Claim idClaim = decodedJWT.getClaim(JwtInfo.ID.name());
            if (!idClaim.isNull()) {
                this.id = idClaim.asLong();
            }
            Claim accountIdClaim = decodedJWT.getClaim(JwtInfo.ACCOUNT_ID.name());
            if (!accountIdClaim.isNull()) {
                this.accountId = accountIdClaim.asString();
            }
            Claim emailClaim = decodedJWT.getClaim(JwtInfo.EMAIL.name());
            if (!emailClaim.isNull()) {
                this.email = emailClaim.asString();
            }

            Claim nicknameClaim = decodedJWT.getClaim(JwtInfo.NICKNAME.name());
            if (!nicknameClaim.isNull()) {
                this.nickname = nicknameClaim.asString();
            }

            Claim rolesClaim = decodedJWT.getClaim(JwtInfo.ROLES.name());
            if (!rolesClaim.isNull()) {
                this.roles = rolesClaim.asArray(String.class);
            }
            this.iat = decodedJWT.getIssuedAt();
            this.exp = decodedJWT.getExpiresAt();
        }

    }

}