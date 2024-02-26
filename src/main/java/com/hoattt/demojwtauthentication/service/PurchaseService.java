package com.hoattt.demojwtauthentication.service;

import org.springframework.http.ResponseEntity;

public interface PurchaseService {
    public ResponseEntity<String> purchaseCourse(Integer userId, Integer courseId);
}
