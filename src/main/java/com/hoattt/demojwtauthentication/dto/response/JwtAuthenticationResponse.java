package com.hoattt.demojwtauthentication.dto.response;

import lombok.Data;

@Data
public class JwtAuthenticationResponse {
    private String token;
    private String refreshtoken;
}
