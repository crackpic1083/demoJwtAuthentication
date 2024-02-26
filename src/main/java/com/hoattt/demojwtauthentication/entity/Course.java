package com.hoattt.demojwtauthentication.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "dbo_course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
