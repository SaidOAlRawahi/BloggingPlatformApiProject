package com.example.BloggingPlatformAPI.Controllers;

import com.example.BloggingPlatformAPI.Models.Blog;
import com.example.BloggingPlatformAPI.Models.Comment;
import com.example.BloggingPlatformAPI.Services.BlogsService;
import com.example.BloggingPlatformAPI.Services.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("api/blogs")
public class BlogsController {
    @Autowired
    BlogsService blogsService;
    @Autowired
    CommentsService commentsService;

    @GetMapping("/all")
    public ResponseEntity<Map<String, List<Blog>>> getAllBlogs() {
        List<Blog> blogs = blogsService.getAll();

        Map<String, List<Blog>> response = new HashMap<>();
        response.put("blogs", blogs);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Map<String,Set<Blog>>> getBlogs(
            @RequestParam(required = false) Integer id,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String tag,
            @RequestParam(required = false) Integer authorId
    ) {
        List<Blog> retrievedBlogs =  blogsService.getBlogs(id, title, tag, authorId);
        Set<Blog> blogs = new HashSet<>();
        blogs.addAll(retrievedBlogs);

        Map<String, Set<Blog>> response = new HashMap<>();
        response.put("blogs", blogs);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/comments/all")
    public ResponseEntity<Map<String, List<Comment>>> getAllComments() {
        List<Comment> comments = commentsService.getAll();

        Map<String, List<Comment>> response = new HashMap<>();
        response.put("comments", comments);

        return ResponseEntity.ok(response);
    }

}
