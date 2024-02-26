package com.hoattt.demojwtauthentication.mapper;

import com.hoattt.demojwtauthentication.dto.request.CompanyCreateUpdateRequest;
import com.hoattt.demojwtauthentication.dto.response.CompanyCreateUpdateResponse;
import com.hoattt.demojwtauthentication.dto.response.CompanySearchResponse;
import com.hoattt.demojwtauthentication.entity.Company;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@AllArgsConstructor
@Configuration
public class CompanyMapper {
    private ModelMapper modelMapper;

    public CompanyMapper() {

    }

    public Company toCompany(CompanyCreateUpdateRequest request) {
        return modelMapper.map(request, Company.class);
    }

    public CompanyCreateUpdateResponse toCompanyCreateUpdateResponse(Company company){
        return modelMapper.map(company, CompanyCreateUpdateResponse.class);
    }

    public CompanyCreateUpdateResponse toCompanyCreateUpdateResponse1(Optional<Company> company){
        return modelMapper.map(company, CompanyCreateUpdateResponse.class);
    }

    public CompanySearchResponse toCompanySearchResponse(Company company){
        return modelMapper.map(company, CompanySearchResponse.class);
    }
}
