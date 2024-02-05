package com.hoattt.demojwtauthentication.service;

import com.hoattt.demojwtauthentication.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {

    UserDetailsService userDetailsService();
}
