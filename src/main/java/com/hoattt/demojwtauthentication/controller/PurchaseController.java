package com.hoattt.demojwtauthentication.controller;

import com.hoattt.demojwtauthentication.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/purchase")
@RequiredArgsConstructor
public class PurchaseController {
    private final PurchaseService purchaseService;
    @GetMapping("/{buyerId}/{courseId}")
    public void purchaseProcess(@PathVariable Integer buyerId, @PathVariable Integer courseId) {
        purchaseService.purchaseCourse(buyerId, courseId);
    }
}
