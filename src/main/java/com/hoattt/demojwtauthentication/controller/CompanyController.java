package com.hoattt.demojwtauthentication.controller;

import com.hoattt.demojwtauthentication.dto.request.CompanyCreateUpdateRequest;
import com.hoattt.demojwtauthentication.dto.request.CompanySearchRequest;
import com.hoattt.demojwtauthentication.dto.response.CompanyCreateUpdateResponse;
import com.hoattt.demojwtauthentication.dto.response.CompanySearchResponse;
import com.hoattt.demojwtauthentication.entity.Company;
import com.hoattt.demojwtauthentication.service.CompanyService;
import com.hoattt.demojwtauthentication.utils.AppConstants;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/company")
@RequiredArgsConstructor
@Validated
public class CompanyController {
    private final CompanyService companyService;


    //GetByID
    @GetMapping("/find/{id}")
    public ResponseEntity<CompanyCreateUpdateResponse> findById(@PathVariable Integer id){
        return companyService.findById(id);
    }

    @GetMapping("/search")
    public List<CompanySearchResponse> getCompanyByName(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) Integer pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @ModelAttribute CompanySearchRequest companySearchRequest
    ) {
        return companyService.search(pageNo,pageSize,sortDir,sortBy,companySearchRequest);
    }


    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public CompanyCreateUpdateResponse addCompany(@Valid @RequestBody CompanyCreateUpdateRequest companyCreateUpdateRequest) throws ParseException {
        return companyService.addCompany(companyCreateUpdateRequest);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody
    public CompanyCreateUpdateResponse updateCompany(@Valid @RequestBody CompanyCreateUpdateRequest companyCreateUpdateRequest) throws ParseException {
        return companyService.updateCompany(companyCreateUpdateRequest);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Integer id) {
        return companyService.deleteCompany(id);
    }




}
