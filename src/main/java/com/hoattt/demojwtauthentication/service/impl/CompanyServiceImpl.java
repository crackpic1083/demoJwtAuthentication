package com.hoattt.demojwtauthentication.service.impl;

import com.hoattt.demojwtauthentication.dto.request.CompanyCreateUpdateRequest;
import com.hoattt.demojwtauthentication.dto.request.CompanySearchRequest;
import com.hoattt.demojwtauthentication.dto.response.CompanyCreateUpdateResponse;
import com.hoattt.demojwtauthentication.dto.response.CompanySearchResponse;
import com.hoattt.demojwtauthentication.dto.response.CourseSearchResponse;
import com.hoattt.demojwtauthentication.entity.Company;
import com.hoattt.demojwtauthentication.entity.Course;
import com.hoattt.demojwtauthentication.repository.CompanyRepository;
import com.hoattt.demojwtauthentication.service.CompanyService;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Data
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final ModelMapper modelMapper;
    @Override
    public CompanyCreateUpdateResponse addCompany(CompanyCreateUpdateRequest companyCreateUpdateRequest) {
        String email = companyCreateUpdateRequest.getEmail();
        if (companyRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Existed Company Email");
        }
        else {
            Company company = modelMapper.map(companyCreateUpdateRequest, Company.class);
            Company companyCreated = companyRepository.save(company);
            return modelMapper.map(companyCreated, CompanyCreateUpdateResponse.class);
        }
    }

    @Override
    public ResponseEntity<CompanyCreateUpdateResponse> findById(Integer companyId) {
        Optional<Company> companySearched = companyRepository.findById(companyId);
        if (companySearched.isPresent()) {
            CompanyCreateUpdateResponse companyDto = modelMapper.map(companySearched, CompanyCreateUpdateResponse.class);
            return ResponseEntity.ok(companyDto);
        } else {
            return ResponseEntity.notFound().build(); //tra ve 404 not found
        }
    }

    @Override
    public List<CompanySearchResponse> search(Integer pageNumber, Integer pageSize, String sortDir,
                                                         String sort, CompanySearchRequest companySearchRequest) {
        Pageable pageable = null;

        // Loại bỏ các khoảng trống thừa và ký tự không mong muốn
        if (sort != null) {
            sort = sort.trim();
        }

        // Loại bỏ các khoảng trống thừa và ký tự không mong muốn
        if (sortDir != null) {
            sortDir = sortDir.trim().toLowerCase(); // Chuyển đổi thành chữ thường để đảm bảo khớp enum
        }

        // Kiểm tra xem giá trị có hợp lệ không
        if (sort != null && !sort.isEmpty() && sortDir != null && !sortDir.isEmpty() && ("asc".equals(sortDir) || "desc".equals(sortDir))) {
            Sort.Direction direction = Sort.Direction.fromString(sortDir);
            pageable = PageRequest.of(pageNumber, pageSize, direction, sort);
        } else {
            pageable = PageRequest.of(pageNumber, pageSize);
        }

        List<Company> companies = companyRepository.search(pageable,companySearchRequest);

        //List entity -> List dto
        List<CompanySearchResponse> companySearchResponseList = new ArrayList<>();
        for(Company co:companies){
            ModelMapper modelMapper = new ModelMapper();
            CompanySearchResponse companySearchResponse = modelMapper.map(co, CompanySearchResponse.class);
            companySearchResponseList.add(companySearchResponse);
        }



        return companySearchResponseList;
    }

    @Override
    public CompanyCreateUpdateResponse updateCompany(CompanyCreateUpdateRequest companyCreateUpdateRequest) {
        Integer companyId = companyCreateUpdateRequest.getId();
        if (companyId == null) {
            throw new RuntimeException("Pls provide Company Id");
        } else {
            Optional<Company> company = companyRepository.findById(companyId);
            if (company.isEmpty()) {
                throw new RuntimeException("Can not find course with provided companyId");
            } else {
                Company company1 = modelMapper.map(companyCreateUpdateRequest, Company.class);
                Company companyUpdated = companyRepository.save(company1);
                return modelMapper.map(companyUpdated, CompanyCreateUpdateResponse.class);
            }
        }
    }

    @Override
    public ResponseEntity<Void> deleteCompany(Integer id) {
        companyRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
