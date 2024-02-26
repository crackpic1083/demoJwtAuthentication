package com.hoattt.demojwtauthentication.dto.request;

import com.hoattt.demojwtauthentication.entity.Company;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CourseSearchRequest {
    String name;
    BigDecimal price;
    String companyName;
}
