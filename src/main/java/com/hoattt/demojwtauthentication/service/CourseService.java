package com.hoattt.demojwtauthentication.service;

import com.hoattt.demojwtauthentication.dto.request.CourseCreateUpdateRequest;
import com.hoattt.demojwtauthentication.dto.request.CourseSearchRequest;
import com.hoattt.demojwtauthentication.dto.response.CompanyCreateUpdateResponse;
import com.hoattt.demojwtauthentication.dto.response.CourseCreateUpdateResponse;
import com.hoattt.demojwtauthentication.dto.response.CourseSearchResponse;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.util.List;

public interface CourseService {
    //Create
    CourseCreateUpdateResponse addCourse(CourseCreateUpdateRequest courseCreateUpdateRequest) throws ParseException;

    ResponseEntity<CompanyCreateUpdateResponse> findById(Integer id);

    //Read
    List<CourseSearchResponse> findCourseByCourseSearchRequest(Integer pageNumber,
                                                              Integer pageSize,
                                                              String sortDir,
                                                              String sort,
                                                              CourseSearchRequest courseSearchRequest) throws ParseException;

    //Update
    CourseCreateUpdateResponse updateCourse(CourseCreateUpdateRequest courseCreateUpdateRequest) throws ParseException;

    //Delete
    void deleteCourse(Integer id);


}
