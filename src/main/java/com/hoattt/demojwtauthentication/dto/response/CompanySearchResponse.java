package com.hoattt.demojwtauthentication.dto.response;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class CompanySearchResponse {
    Integer id;
    String name;
    String email;
    BigDecimal courseProfit;
}
