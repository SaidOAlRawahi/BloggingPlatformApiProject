package com.example.BloggingPlatformAPI.Services;

import com.example.BloggingPlatformAPI.Models.User;
import com.example.BloggingPlatformAPI.Reposittories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UsersService {
    @Autowired
    UsersRepository usersRepository;

    public User add(User user){
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setUserName(user.getUserName());
        newUser.setPassword(user.getPassword());
        newUser.setIsActive(true);
        newUser.setCreatedDate(new Date());
        newUser.setLastUpdated(newUser.getCreatedDate());
        return usersRepository.save(newUser);
    }
    public List<User>getAll(){
        return usersRepository.findAll();
    }
}
