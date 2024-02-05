package com.hoattt.demojwtauthentication.repository;

import com.hoattt.demojwtauthentication.entity.Role;
import com.hoattt.demojwtauthentication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    User findByRole(Role role);

}
