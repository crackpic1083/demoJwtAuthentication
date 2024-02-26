package com.hoattt.demojwtauthentication.dto.response;

import com.hoattt.demojwtauthentication.entity.Role;
import lombok.Data;

@Data
public class UserSearchResponse {
    Integer id;
    String name;
    String email;
    Role role;
}
