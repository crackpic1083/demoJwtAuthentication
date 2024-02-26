package com.hoattt.demojwtauthentication.repository;

import com.hoattt.demojwtauthentication.dto.request.CourseSearchRequest;
import com.hoattt.demojwtauthentication.dto.request.UserSearchRequest;
import com.hoattt.demojwtauthentication.dto.response.UserDtoResponse;
import com.hoattt.demojwtauthentication.dto.response.UserSearchResponse;
import com.hoattt.demojwtauthentication.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<User, Integer> {
    //Admin add new user

    @Query(value = "SELECT p FROM User p " +
            "WHERE (:#{#userSearchRequest.name} IS NULL OR p.name ILIKE %:#{#userSearchRequest.name}%) " +
            "AND (:#{#userSearchRequest.email} IS NULL OR p.email ILIKE %:#{#userSearchRequest.email}%) " +
            "AND (:#{#userSearchRequest.accountBalance} IS NULL OR p.email <= :#{#userSearchRequest.accountBalance}) " +
            "AND (:#{#userSearchRequest.role} IS NULL OR p.role = :#{#userSearchRequest.role})" +
            "AND p.flag=true")
    List<User> findTest(Pageable pageable,
                        @Param("userSearchRequest") UserSearchRequest userSearchRequest);

    @Query("UPDATE User u SET u.flag = false WHERE u.id = :id")
    void updateFlag(@Param("id") Integer id);

}
