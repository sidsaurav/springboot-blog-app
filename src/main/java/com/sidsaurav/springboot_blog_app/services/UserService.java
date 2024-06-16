package com.sidsaurav.springboot_blog_app.services;

import java.util.List;

import com.sidsaurav.springboot_blog_app.payloads.ApiResponse;
import com.sidsaurav.springboot_blog_app.payloads.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    List<UserDto> getAllUsers();

    UserDto getUserById(long userId);

    ApiResponse createUser(UserDto user);

    ApiResponse updateUser(UserDto user, long userId);

    ApiResponse deleteUser(long userId);

}
