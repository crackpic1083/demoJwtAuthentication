package com.hoattt.demojwtauthentication.dto.request;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class CompanySearchRequest {
    String name;
    String email;
    BigDecimal courseProfit;
}
