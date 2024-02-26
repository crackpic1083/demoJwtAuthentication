package com.hoattt.demojwtauthentication.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "dbo_post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String title;
    String content;

}
