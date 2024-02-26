package com.hoattt.demojwtauthentication.mapper;

import com.hoattt.demojwtauthentication.dto.request.CompanyCreateUpdateRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapper {

    @Bean
    public org.modelmapper.ModelMapper modelMapper(CompanyCreateUpdateRequest request) {
        return new org.modelmapper.ModelMapper();
    }
}
