package com.sidsaurav.springboot_blog_app.services;

import java.util.List;

import com.sidsaurav.springboot_blog_app.payloads.UserDto;

public interface UserService {

    List<UserDto> getAllUsers();

    UserDto getUserById(long userId);

    UserDto createUser(UserDto user);

    UserDto updateUser(UserDto user, long userId);

    void deleteUser(long userId);

}
