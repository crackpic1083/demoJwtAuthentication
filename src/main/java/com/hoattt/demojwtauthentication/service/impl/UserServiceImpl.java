package com.hoattt.demojwtauthentication.service.impl;

import com.hoattt.demojwtauthentication.dto.UserDto;
import com.hoattt.demojwtauthentication.dto.request.UserDtoRequest;
import com.hoattt.demojwtauthentication.dto.response.UserDtoResponse;
import com.hoattt.demojwtauthentication.entity.User;
import com.hoattt.demojwtauthentication.repository.UserRepository;
import com.hoattt.demojwtauthentication.service.UserService;
import com.sun.security.auth.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserDetailsService userDetailsService(){
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return userRepository.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }


    @Override
    public UserDtoResponse updateUser(UserDtoRequest userDtoRequest) {
        Integer userId = userDtoRequest.getId();
        if (userId == null) {
            throw new RuntimeException("Pls provide User Id");
        } else {
            Optional<User> user = userRepository.findById(userId);
            if (user.isEmpty()) {
                throw new RuntimeException("Can not find user with provided userId");
            } else {
                User user1 = modelMapper.map(userDtoRequest, User.class);
                User userUpdated = userRepository.save(user1);
                return modelMapper.map(userUpdated, UserDtoResponse.class);
            }
        }
    }

}
