package com.hoattt.demojwtauthentication.service.impl;

import com.hoattt.demojwtauthentication.dto.request.UserDtoRequest;
import com.hoattt.demojwtauthentication.dto.request.UserSearchRequest;
import com.hoattt.demojwtauthentication.dto.response.CompanyCreateUpdateResponse;
import com.hoattt.demojwtauthentication.dto.response.CourseSearchResponse;
import com.hoattt.demojwtauthentication.dto.response.UserDtoResponse;
import com.hoattt.demojwtauthentication.dto.response.UserSearchResponse;
import com.hoattt.demojwtauthentication.entity.Company;
import com.hoattt.demojwtauthentication.entity.Course;
import com.hoattt.demojwtauthentication.entity.User;
import com.hoattt.demojwtauthentication.repository.AdminRepository;
import com.hoattt.demojwtauthentication.service.AdminService;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Data
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<UserSearchResponse> findTest(Integer pageNumber, Integer pageSize, String sortDir, String sort, UserSearchRequest userSearchRequest) {
        Pageable pageable = null;

        // Loại bỏ các khoảng trống thừa và ký tự không mong muốn
        if (sort != null) {
            sort = sort.trim();
        }

        // Loại bỏ các khoảng trống thừa và ký tự không mong muốn
        if (sortDir != null) {
            sortDir = sortDir.trim().toLowerCase(); // Chuyển đổi thành chữ thường để đảm bảo khớp enum
        }

        // Kiểm tra xem giá trị có hợp lệ không
        if (sort != null && !sort.isEmpty() && sortDir != null && !sortDir.isEmpty() && ("asc".equals(sortDir) || "desc".equals(sortDir))) {
            Sort.Direction direction = Sort.Direction.fromString(sortDir);
            pageable = PageRequest.of(pageNumber, pageSize, direction, sort);
        } else {
            pageable = PageRequest.of(pageNumber, pageSize);
        }
        List<User> users = adminRepository.findTest(pageable, userSearchRequest);

        //List entity -> List dto
        List<UserSearchResponse> userSearchResponseList = new ArrayList<>();
        for (User u : users) {
            ModelMapper modelMapper = new ModelMapper();
            UserSearchResponse userSearchResponse = modelMapper.map(u, UserSearchResponse.class);
            userSearchResponseList.add(userSearchResponse);
        }


        return userSearchResponseList;
    }


    @Override
    public UserDtoResponse updateUser(Integer id, UserDtoRequest userDtoRequest) {
        User updateUser = adminRepository.findById(id).orElse(null);
        updateUser.setEmail(userDtoRequest.getEmail());
        updateUser.setName(userDtoRequest.getName());
        updateUser.setAccountBalance(userDtoRequest.getAccountBalance());
        updateUser.setRole(userDtoRequest.getRole());

        User userUpdated = adminRepository.save(updateUser);
        return modelMapper.map(userUpdated, UserDtoResponse.class);

    }

    @Override
    public ResponseEntity<Void> deleteAccount(Integer id) {
        Optional<User> user = adminRepository.findById(id);
        if (user.isEmpty()) {
            throw new RuntimeException("Can not find User");
        } else {
            adminRepository.updateFlag(id);
            return ResponseEntity.noContent().build();
        }
    }

    @Override
    public ResponseEntity<UserDtoResponse> findById(Integer userId) {
        Optional<User> userSearched = adminRepository.findById(userId);
        if (userSearched.isPresent()) {
            UserDtoResponse userDtoResponse = modelMapper.map(userSearched, UserDtoResponse.class);
            return ResponseEntity.ok(userDtoResponse);
        } else {
            return ResponseEntity.notFound().build(); //tra ve 404 not found
        }
    }
}
