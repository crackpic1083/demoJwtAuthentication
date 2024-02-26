package com.hoattt.demojwtauthentication.repository;

import com.hoattt.demojwtauthentication.dto.UserCourseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCourseRepository extends JpaRepository<UserCourseDto, Integer> {
}
