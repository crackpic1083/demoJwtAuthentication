package com.hoattt.demojwtauthentication.service;

import com.hoattt.demojwtauthentication.dto.JwtAuthenticationResponse;
import com.hoattt.demojwtauthentication.dto.RefreshTokenRequest;
import com.hoattt.demojwtauthentication.dto.SignUpRequest;
import com.hoattt.demojwtauthentication.dto.SigninRequest;
import com.hoattt.demojwtauthentication.entity.User;

public interface AuthenticationService {
    User signup(SignUpRequest signUpRequest);

    JwtAuthenticationResponse signin(SigninRequest signinRequest);

    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
