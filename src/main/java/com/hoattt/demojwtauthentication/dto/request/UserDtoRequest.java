package com.hoattt.demojwtauthentication.dto.request;

import com.hoattt.demojwtauthentication.entity.Role;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserDtoRequest {

    @Valid
    Integer id;
    @NotEmpty
    @Size(min = 2, message = "user name should have at least 2 characters")
    private String name;

    @NotEmpty
    @Email
    private String email;

    @Positive(message = "Account Balance must be a positive number")
    private BigDecimal accountBalance;

    @NotNull(message = "Role must be provided")
    private Role role;
}
