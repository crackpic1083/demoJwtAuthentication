package com.hoattt.demojwtauthentication.service;

import com.hoattt.demojwtauthentication.dto.request.CompanyCreateUpdateRequest;
import com.hoattt.demojwtauthentication.dto.request.CompanySearchRequest;
import com.hoattt.demojwtauthentication.dto.response.CompanyCreateUpdateResponse;
import com.hoattt.demojwtauthentication.dto.response.CompanySearchResponse;
import com.hoattt.demojwtauthentication.entity.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    //Create
    CompanyCreateUpdateResponse addCompany(CompanyCreateUpdateRequest companyCreateUpdateRequest);
    ResponseEntity<CompanyCreateUpdateResponse> findById(Integer companyId);

    //Read (find by name)
    List<CompanySearchResponse> search(Integer pageNumber, Integer pageSize, String sortDir, String sort, CompanySearchRequest companySearchRequest);

    //Update
    CompanyCreateUpdateResponse updateCompany(CompanyCreateUpdateRequest companyCreateUpdateRequest);

    //Delete
    ResponseEntity<Void> deleteCompany(Integer id);

}
