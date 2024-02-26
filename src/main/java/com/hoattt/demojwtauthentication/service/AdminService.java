package com.hoattt.demojwtauthentication.service;


import com.hoattt.demojwtauthentication.dto.request.UserDtoRequest;
import com.hoattt.demojwtauthentication.dto.request.UserSearchRequest;
import com.hoattt.demojwtauthentication.dto.response.CompanyCreateUpdateResponse;
import com.hoattt.demojwtauthentication.dto.response.UserDtoResponse;
import com.hoattt.demojwtauthentication.dto.response.UserSearchResponse;
import com.hoattt.demojwtauthentication.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdminService {
    //Admin add new user


    List<UserSearchResponse> findTest(Integer pageNumber, Integer pageSize, String sortDir, String sort, UserSearchRequest userSearchRequest);


    //Update User
    UserDtoResponse updateUser(Integer id, UserDtoRequest userDtoRequest);

    ResponseEntity<Void> deleteAccount(Integer id);

    ResponseEntity<UserDtoResponse> findById(Integer userId);

}
