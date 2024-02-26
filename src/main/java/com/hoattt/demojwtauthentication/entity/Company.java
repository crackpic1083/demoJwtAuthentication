package com.hoattt.demojwtauthentication.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@Builder
@Table(name = "company")
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//    @NotBlank(message = "Name is mandatory")
//    @Size(min = 3, message = "Name must be at least 3 characters long")
//    @Pattern(regexp = "\\S+", message = "Name cannot contain only spaces")
    private String name;
//    @NotBlank(message = "Email can not be empty")
//    @Email(message = "Invalid Email")
    private String email;
    private BigDecimal courseProfit;

}
