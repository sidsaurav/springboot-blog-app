package com.sidsaurav.springboot_blog_app.impl;

import com.sidsaurav.springboot_blog_app.payloads.ApiResponse;
import com.sidsaurav.springboot_blog_app.services.UserService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.sidsaurav.springboot_blog_app.entity.User;
import com.sidsaurav.springboot_blog_app.payloads.UserDto;
import com.sidsaurav.springboot_blog_app.repositories.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public List<UserDto> getAllUsers() {
        return userRepo.findAll().stream().map(e -> convertToDto(e)).collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(long userId) {
        return userRepo.findById(userId).map(e -> convertToDto(e)).orElse(null);
    }

    @Override
    public ApiResponse createUser(UserDto user) {
        User newUser = new User();
        newUser.setId(user.getId());
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setAbout(user.getAbout());
        userRepo.save(newUser);
        return new ApiResponse("User created successfully", true);
    }

    @Override
    public ApiResponse updateUser(UserDto user, long userId) {
        var userToUpdate = userRepo.findById(userId).orElse(null);
        if (userToUpdate == null) {
            return null;
        }

        userToUpdate.setName(user.getName());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPassword(user.getPassword());
        userToUpdate.setAbout(user.getAbout());

        userRepo.save(userToUpdate);
        return new ApiResponse("User updated successfully", true);
    }

    @Override
    public ApiResponse deleteUser(long userId) {
        userRepo.deleteById(userId);
        return new ApiResponse("User deleted successfully", true);
    }

    private UserDto convertToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setAbout(user.getAbout());
        return userDto;
    }

    private User convertToUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        return user;
    }

}
