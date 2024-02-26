package com.hoattt.demojwtauthentication.controller;

import com.hoattt.demojwtauthentication.dto.request.SignUpRequest;
import com.hoattt.demojwtauthentication.dto.request.UserDtoRequest;
import com.hoattt.demojwtauthentication.dto.request.UserSearchRequest;
import com.hoattt.demojwtauthentication.dto.response.CompanyCreateUpdateResponse;
import com.hoattt.demojwtauthentication.dto.response.SignUpResponse;
import com.hoattt.demojwtauthentication.dto.response.UserDtoResponse;
import com.hoattt.demojwtauthentication.dto.response.UserSearchResponse;
import com.hoattt.demojwtauthentication.entity.User;
import com.hoattt.demojwtauthentication.service.AdminService;
import com.hoattt.demojwtauthentication.service.AuthenticationService;
import com.hoattt.demojwtauthentication.utils.AppConstants;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@PreAuthorize("hasRole('ADMIN')")
@SecurityRequirement(name="bearerAuth")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;
    private final AuthenticationService authenticationService;


    @PostMapping ("/adduser")
    public ResponseEntity<SignUpResponse> signup(@Valid @RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(authenticationService.signup(signUpRequest));
    }

    //delete account
    @DeleteMapping("/deleteuser")
    public ResponseEntity<Void> deleteUser(Integer id){
        return adminService.deleteAccount(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDtoResponse> findById(@PathVariable Integer id){
        return adminService.findById(id);
    }

    @GetMapping("/search")
    public List<UserSearchResponse> findTest(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) Integer pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @ModelAttribute UserSearchRequest userSearchRequest) {
        return adminService.findTest(pageNo,pageSize,sortDir,sortBy,userSearchRequest);
    }


    @PutMapping("/update/{id}")
    public UserDtoResponse updateUser(@PathVariable(name = "id") Integer id,@Valid @RequestBody UserDtoRequest userDtoRequest){
        return adminService.updateUser(id, userDtoRequest);
    }


}
