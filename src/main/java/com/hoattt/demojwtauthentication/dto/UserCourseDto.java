package com.hoattt.demojwtauthentication.dto;

import com.hoattt.demojwtauthentication.entity.Course;
import com.hoattt.demojwtauthentication.entity.User;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user_course")
@Data
public class UserCourseDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

}