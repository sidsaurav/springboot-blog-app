package com.sidsaurav.springboot_blog_app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "User") //optional
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private long id;
    @Column(name = "name", nullable = false, length = 100)
    
    private String name;
    private String email;
    private String password;
    private String about;
}
