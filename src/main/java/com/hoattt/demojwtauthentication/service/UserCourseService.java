package com.hoattt.demojwtauthentication.service;

import com.hoattt.demojwtauthentication.dto.UserCourseDto;

public interface UserCourseService {
    void insertUserCourse(Integer userId, Integer courseId);
}
