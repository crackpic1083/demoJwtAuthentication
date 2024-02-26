package com.hoattt.demojwtauthentication.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class CompanyCreateUpdateRequest {
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

    public CompanyCreateUpdateRequest(String companyUnitTest, String mail, BigDecimal courseProfit) {
    }
}
