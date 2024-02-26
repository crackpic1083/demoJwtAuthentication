package com.hoattt.demojwtauthentication.service;

import com.hoattt.demojwtauthentication.dto.request.UserDtoRequest;
import com.hoattt.demojwtauthentication.dto.response.UserDtoResponse;
import com.hoattt.demojwtauthentication.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserDetailsService userDetailsService();
    UserDtoResponse updateUser(UserDtoRequest user);
}
