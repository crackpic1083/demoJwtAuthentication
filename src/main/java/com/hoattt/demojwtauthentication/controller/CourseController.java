package com.hoattt.demojwtauthentication.controller;

import com.hoattt.demojwtauthentication.dto.request.CourseCreateUpdateRequest;
import com.hoattt.demojwtauthentication.dto.request.CourseSearchRequest;
import com.hoattt.demojwtauthentication.dto.response.CompanyCreateUpdateResponse;
import com.hoattt.demojwtauthentication.dto.response.CourseCreateUpdateResponse;
import com.hoattt.demojwtauthentication.dto.response.CourseSearchResponse;
import com.hoattt.demojwtauthentication.service.CompanyService;
import com.hoattt.demojwtauthentication.service.CourseService;
import com.hoattt.demojwtauthentication.utils.AppConstants;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;
    private final CompanyService companyService;


    //search By Id
    @GetMapping("/search/{id}")
    public ResponseEntity<CompanyCreateUpdateResponse> findCourseById(@PathVariable Integer id) {
        return courseService.findById(id);
    }


    @GetMapping ("/search")
    public List<CourseSearchResponse> getCourseByName(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) Integer pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @ModelAttribute CourseSearchRequest courseSearchRequest
    ) throws ParseException {
       return courseService.findCourseByCourseSearchRequest(pageNo, pageSize, sortDir, sortBy, courseSearchRequest);
    }

    //Okey
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public CourseCreateUpdateResponse addCourse(@Valid @RequestBody CourseCreateUpdateRequest courseCreateUpdateRequest) throws ParseException {
        return courseService.addCourse(courseCreateUpdateRequest);
    }

    //Okey
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody
    public CourseCreateUpdateResponse updateCourse(@Valid @RequestBody CourseCreateUpdateRequest courseCreateUpdateRequest) throws ParseException {
        return courseService.updateCourse(courseCreateUpdateRequest);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Integer id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }

}