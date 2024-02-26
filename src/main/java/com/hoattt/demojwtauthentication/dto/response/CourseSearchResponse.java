package com.hoattt.demojwtauthentication.dto.response;

import com.hoattt.demojwtauthentication.dto.CourseDto;
import com.hoattt.demojwtauthentication.dto.request.CourseSearchRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CourseSearchResponse {
    Integer id;
    String name;
    BigDecimal price;
    Integer companyId;
}
