package com.hoattt.demojwtauthentication.service.impl;

import com.hoattt.demojwtauthentication.entity.Company;
import com.hoattt.demojwtauthentication.entity.Course;
import com.hoattt.demojwtauthentication.entity.User;
import com.hoattt.demojwtauthentication.repository.CompanyRepository;
import com.hoattt.demojwtauthentication.repository.CourseRepository;
import com.hoattt.demojwtauthentication.repository.UserCourseRepository;
import com.hoattt.demojwtauthentication.repository.UserRepository;
import com.hoattt.demojwtauthentication.service.PurchaseService;
import com.hoattt.demojwtauthentication.service.UserCourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final CompanyRepository companyRepository;
    private final UserCourseService userCourseService;

    @Transactional
    @Override
    public ResponseEntity<String> purchaseCourse(Integer buyerId, Integer courseId) {
        User userEntity = userRepository.findById(buyerId).orElseThrow(()
                -> new RuntimeException("Buyer not found"));
        Course courseEntity = courseRepository.findById(courseId).orElseThrow(()
                -> new RuntimeException("Course not found"));
        Company companyEntity = companyRepository.findById(courseEntity.getCompany().getId()).orElseThrow(()
                -> new RuntimeException("Company not found"));

        BigDecimal coursePrice = courseEntity.getPrice();
        //co du tien
        if (userEntity.getAccountBalance().compareTo(coursePrice) > 0) {
            //tru tien nguoi mua
            userEntity.setAccountBalance(userEntity.getAccountBalance().subtract(coursePrice));
            userRepository.save(userEntity);

            //cong tien cho cong ty
            companyEntity.setCourseProfit(companyEntity.getCourseProfit().add(coursePrice));
            companyRepository.save(companyEntity);

            userCourseService.insertUserCourse(userEntity.getId(), courseEntity.getId());

            //them thong tin vao bang user_company


        } else {
            throw new RuntimeException("Insufficient funds to purchase the course");
        }

        return ResponseEntity.ok("Purchase Successfully");
    }
}
