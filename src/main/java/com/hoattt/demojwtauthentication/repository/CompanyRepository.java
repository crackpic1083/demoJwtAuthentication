package com.hoattt.demojwtauthentication.repository;

import com.hoattt.demojwtauthentication.dto.request.CompanySearchRequest;
import com.hoattt.demojwtauthentication.entity.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
    //find company by name
    @Query(value = "Select c from Company c " +
            "where (:#{#companySearchRequest.name} is null or c.name ilike %:#{#companySearchRequest.name}%) " +
            "AND (:#{#companySearchRequest.email} is null or c.name ilike %:#{#companySearchRequest.email}%) " +
            "AND (:#{#companySearchRequest.courseProfit} is null or c.name <= :#{#companySearchRequest.name})")
    List<Company> search(Pageable pageable, @Param("companySearchRequest") CompanySearchRequest companySearchRequest);


    boolean existsByEmail(String email);
}
