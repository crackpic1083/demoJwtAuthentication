package com.hoattt.demojwtauthentication.repository;

import com.hoattt.demojwtauthentication.dto.request.CourseSearchRequest;
import com.hoattt.demojwtauthentication.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    //Read
    @Query(value = "Select co from Course co where (:#{#courseSearchRequest.name} is null or co.name ilike %:#{#courseSearchRequest.name}%) " +
            "and (:#{#courseSearchRequest.price} is null or co.price <= :#{#courseSearchRequest.price})" +
            "and (:#{#courseSearchRequest.companyName} is null or co.company.name ilike %:#{#courseSearchRequest.companyName}%)")
    List<Course> findCourseByCourseSearchRequest(Pageable pageable,
                                  @Param("courseSearchRequest")CourseSearchRequest courseSearchRequest);


//    @Query(value = "Select co from Course co where (:#{#courseSearchRequest.name} is null or co.name ilike %:#{#courseSearchRequest.name}%) " +
//            "and (:#{#courseSearchRequest.priceMax} is null or co.price <= :#{#courseSearchRequest.priceMax})" +
//            "and (:#{#courseSearchRequest.priceMin} is null or co.price >= :#{#courseSearchRequest.priceMin})" +
//            "and (:#{#courseSearchRequest.company.name} is null or co.company.name ilike %:#{#courseSearchRequest.company.name}%)")
//    Page<Course> findCourseByName(Pageable pageable, @Param("courseSearchRequest") CourseSearchRequest courseSearchRequest);
}
