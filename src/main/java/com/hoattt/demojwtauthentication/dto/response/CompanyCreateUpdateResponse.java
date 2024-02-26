package com.hoattt.demojwtauthentication.dto.response;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class CompanyCreateUpdateResponse {
    @Valid
    Integer id;

    @NotEmpty
    @Size(min = 2, message = "Course name should have at least 2 characters")
    String name;

    @NotNull
    @Email
    String email;

    @NotNull
    @PositiveOrZero(message = "Course_profit must not be negative")
    BigDecimal courseProfit;
}
