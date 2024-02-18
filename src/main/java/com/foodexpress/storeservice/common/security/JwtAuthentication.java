package com.foodexpress.storeservice.common.security;

public record JwtAuthentication(Long id, String accountId, String email, String nickname) {

}