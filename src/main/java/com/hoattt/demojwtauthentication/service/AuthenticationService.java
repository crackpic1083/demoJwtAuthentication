package com.hoattt.demojwtauthentication.service;

import com.hoattt.demojwtauthentication.dto.response.JwtAuthenticationResponse;
import com.hoattt.demojwtauthentication.dto.request.RefreshTokenRequest;
import com.hoattt.demojwtauthentication.dto.request.SignUpRequest;
import com.hoattt.demojwtauthentication.dto.request.SigninRequest;
import com.hoattt.demojwtauthentication.dto.response.SignUpResponse;
import com.hoattt.demojwtauthentication.entity.User;

public interface AuthenticationService {
    SignUpResponse signup(SignUpRequest signUpRequest);

    JwtAuthenticationResponse signin(SigninRequest signinRequest);

    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
