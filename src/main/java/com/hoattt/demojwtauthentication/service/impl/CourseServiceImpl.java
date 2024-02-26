package com.hoattt.demojwtauthentication.service.impl;

import com.hoattt.demojwtauthentication.dto.CourseDto;
import com.hoattt.demojwtauthentication.dto.request.CourseCreateUpdateRequest;
import com.hoattt.demojwtauthentication.dto.request.CourseSearchRequest;
import com.hoattt.demojwtauthentication.dto.response.CompanyCreateUpdateResponse;
import com.hoattt.demojwtauthentication.dto.response.CourseCreateUpdateResponse;
import com.hoattt.demojwtauthentication.dto.response.CourseSearchResponse;
import com.hoattt.demojwtauthentication.entity.Company;
import com.hoattt.demojwtauthentication.entity.Course;
import com.hoattt.demojwtauthentication.repository.CompanyRepository;
import com.hoattt.demojwtauthentication.repository.CourseRepository;
import com.hoattt.demojwtauthentication.service.CourseService;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Data
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;
    private final CompanyRepository companyRepository;

    @Override
    public CourseCreateUpdateResponse addCourse(CourseCreateUpdateRequest courseCreateUpdateRequest) throws ParseException {
        Integer companyId = courseCreateUpdateRequest.getCompanyId();
        if (companyId == null) {
            throw new RuntimeException("CompanyId must not be null");
        } else {
            Optional<Company> company = companyRepository.findById(companyId);
            if (company.isEmpty()) {
                throw new RuntimeException("Company Id does not exist");
            } else {
                Course course = modelMapper.map(courseCreateUpdateRequest, Course.class);
                Course courseCreated = courseRepository.save(course);
                // Trả về courseCreated thay vì mapp lại sang CourseCreateResponse
                return modelMapper.map(courseCreated, CourseCreateUpdateResponse.class);
            }
        }
    }


    @Override
    public ResponseEntity<CompanyCreateUpdateResponse> findById(Integer id) {
        Optional<Course> courseSearched = courseRepository.findById(id);
        if (courseSearched.isPresent()) {
            CompanyCreateUpdateResponse companyCreateUpdateResponse = modelMapper.map(courseSearched, CompanyCreateUpdateResponse.class);
            return ResponseEntity.ok(companyCreateUpdateResponse);
        } else {
            return ResponseEntity.notFound().build(); //tra ve 404 not found
        }
    }

    @Override
    public List<CourseSearchResponse> findCourseByCourseSearchRequest(Integer pageNumber,
                                            Integer pageSize,
                                            String sortDir,
                                            String sort,
                                            CourseSearchRequest courseSearchRequest) throws ParseException {
        Pageable pageable = null;

        if (sort != null) {
            sort = sort.trim();
        }

        if (sortDir != null) {
            sortDir = sortDir.trim().toLowerCase();
        }

        if (sort != null && !sort.isEmpty() && sortDir != null && !sortDir.isEmpty() && ("asc".equals(sortDir) || "desc".equals(sortDir))) {
            Sort.Direction direction = Sort.Direction.fromString(sortDir);
            pageable = PageRequest.of(pageNumber, pageSize, direction, sort);
        } else {
            pageable = PageRequest.of(pageNumber, pageSize);
        }

        List<Course> courses = courseRepository.findCourseByCourseSearchRequest(pageable,courseSearchRequest);

        //List entity -> List dto
        List<CourseSearchResponse> courseSearchResponseList = new ArrayList<>();
        for(Course c:courses){
            ModelMapper modelMapper = new ModelMapper();
            CourseSearchResponse courseSearchResponse = modelMapper.map(c, CourseSearchResponse.class);
            courseSearchResponseList.add(courseSearchResponse);
        }



        return courseSearchResponseList;
    }




    @Override
    public CourseCreateUpdateResponse updateCourse(CourseCreateUpdateRequest courseCreateUpdateRequest) throws ParseException {
        Integer courseId = courseCreateUpdateRequest.getId();
        if (courseId == null) {
            throw new RuntimeException("Pls provide Course Id");
        } else {
            Optional<Course> course = courseRepository.findById(courseId);
            if (course.isEmpty()) {
                throw new RuntimeException("Can not find course with provided courseId");
            } else {
                Integer companyId = courseCreateUpdateRequest.getCompanyId();
                if (companyId == null) {
                    throw new RuntimeException("CompanyId must not be null");
                } else {
                    Optional<Company> company = companyRepository.findById(companyId);
                    if (company.isEmpty()) {
                        throw new RuntimeException("Can not find Company with provided companyId");
                    } else {
                        Course course1 = modelMapper.map(courseCreateUpdateRequest, Course.class);
                        Course courseUpdated = courseRepository.save(course1);
                        // Trả về courseCreated thay vì mapp lại sang CourseCreateResponse
                        return modelMapper.map(courseUpdated, CourseCreateUpdateResponse.class);
                    }
                }
            }
        }
    }

    @Override
    public void deleteCourse(Integer id) {
        courseRepository.deleteById(id);
    }



}
