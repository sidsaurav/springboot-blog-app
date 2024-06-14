package com.sidsaurav.springboot_blog_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sidsaurav.springboot_blog_app.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

}
