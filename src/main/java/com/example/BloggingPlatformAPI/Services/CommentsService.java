package com.example.BloggingPlatformAPI.Services;

import com.example.BloggingPlatformAPI.Models.Comment;
import com.example.BloggingPlatformAPI.Reposittories.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsService {
    @Autowired
    CommentsRepository commentsRepository;

    public List<Comment> getAll(){
        return commentsRepository.findAll();
    }
}
