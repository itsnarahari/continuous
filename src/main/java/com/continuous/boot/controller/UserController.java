package com.continuous.boot.controller;


import com.continuous.boot.models.Users;
import com.continuous.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/users", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = "application/json")
    public ResponseEntity saveUsers(@RequestParam(value = "files") MultipartFile[] files) throws Exception {
        for (MultipartFile file : files) {
            userService.saveUsers(file);
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/users", produces = "application/json")
    public CompletableFuture<ResponseEntity> findAllUsers() {
        return userService.findAllUsers().thenApply(ResponseEntity::ok);
    }

    @GetMapping(value = "/getUsersByThread", produces = "application/json")
    public ResponseEntity getUsers() {
        CompletableFuture<List<Users>> users1 = userService.findAllUsers();
        CompletableFuture<List<Users>> users2 = userService.findAllUsers();
        CompletableFuture<List<Users>> users3 = userService.findAllUsers();
        CompletableFuture.allOf(users1, users2, users3).join();
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping(value = "/powerMock", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = "application/json")
    public ResponseEntity utilsResponse(@RequestBody Users users) {
        return new ResponseEntity(userService.staticMockTest(users), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> test() {
        return new ResponseEntity("done", HttpStatus.OK);
    }
}