package com.hoattt.demojwtauthentication.dto.response;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class CourseCreateUpdateResponse {
    @Valid
    Integer id;
    @NotEmpty
    @Size(min = 2, message = "Course name should have at least 2 characters")
    String name;
    @Positive(message = "Price must be a positive number")
    BigDecimal price;
    Integer companyId;
}
