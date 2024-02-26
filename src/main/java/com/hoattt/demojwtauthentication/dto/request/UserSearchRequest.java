package com.hoattt.demojwtauthentication.dto.request;

import com.hoattt.demojwtauthentication.entity.Role;
import lombok.Data;

@Data
public class UserSearchRequest {
    String name;
    String email;
    String accountBalance;
    String getAccountBalance;
    Role role;
}
