package com.hoattt.demojwtauthentication.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class SigninRequest {
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    private String password;
}
