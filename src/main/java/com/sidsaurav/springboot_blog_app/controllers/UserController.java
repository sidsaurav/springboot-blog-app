package com.sidsaurav.springboot_blog_app.controllers;

import com.sidsaurav.springboot_blog_app.payloads.ApiResponse;
import com.sidsaurav.springboot_blog_app.payloads.UserDto;
import com.sidsaurav.springboot_blog_app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path="/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    ResponseEntity<List<UserDto>> getAllUsers(){
       var allUsersList = userService.getAllUsers();
       return new ResponseEntity<List<UserDto>>(allUsersList, HttpStatus.ACCEPTED);
    }

    @GetMapping(path="/{id}")
    ResponseEntity<UserDto> getSingleUser(@PathVariable long id){
        var userToReturn = userService.getUserById(id);
        return new ResponseEntity<UserDto>(userToReturn, HttpStatus.ACCEPTED);
    }

    @PostMapping
    ResponseEntity<ApiResponse> createUser(@RequestBody UserDto user){
        var res = userService.createUser(user);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @PutMapping(path="/{id}")
    ResponseEntity<?> updateUser(@PathVariable long id, @RequestBody UserDto user){
        var res = userService.updateUser(user, id);
        return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path="/{id}")
    ResponseEntity<?> deleteUser(@PathVariable long id){
        var res = userService.deleteUser(id);
//        return new ResponseEntity<>(Map.of("message","User deleted successfully", "anotherMessage","for testing purpose"), HttpStatus.ACCEPTED);
        return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
    }

}
