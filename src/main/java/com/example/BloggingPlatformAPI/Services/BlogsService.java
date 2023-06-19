package com.example.BloggingPlatformAPI.Services;

import com.example.BloggingPlatformAPI.Models.Blog;
import com.example.BloggingPlatformAPI.Reposittories.BlogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogsService {
    @Autowired
    BlogsRepository blogsRepository;
    public Blog add(Blog blog) {
        return blogsRepository.save(blog);
    }
    public List<Blog> getAll(){
        return blogsRepository.findAll();
    }


}
