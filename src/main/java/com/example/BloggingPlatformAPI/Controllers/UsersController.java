package com.example.BloggingPlatformAPI.Controllers;

import com.example.BloggingPlatformAPI.Models.User;
import com.example.BloggingPlatformAPI.Services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/register")
public class UsersController {
    @Autowired
    UsersService usersService;


    @PostMapping
    public ResponseEntity<String> add(@RequestBody User user){
        usersService.add(user);
        return ResponseEntity.ok("User registered successfully");
    }
}
