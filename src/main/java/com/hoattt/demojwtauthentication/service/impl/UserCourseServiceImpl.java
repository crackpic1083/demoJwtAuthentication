package com.hoattt.demojwtauthentication.service.impl;

import com.hoattt.demojwtauthentication.dto.UserCourseDto;
import com.hoattt.demojwtauthentication.entity.Course;
import com.hoattt.demojwtauthentication.repository.CourseRepository;
import com.hoattt.demojwtauthentication.repository.UserCourseRepository;
import com.hoattt.demojwtauthentication.repository.UserRepository;
import com.hoattt.demojwtauthentication.service.UserCourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserCourseServiceImpl implements UserCourseService {
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final UserCourseRepository userCourseRepository;
    @Override
    public void insertUserCourse(Integer userId, Integer courseId) {
        UserCourseDto userCourse = new UserCourseDto();
        userCourse.setUser(userRepository.findById(userId).orElseThrow());
        userCourse.setCourse(courseRepository.findById(courseId).orElseThrow());
        userCourseRepository.save(userCourse);
    }
}
