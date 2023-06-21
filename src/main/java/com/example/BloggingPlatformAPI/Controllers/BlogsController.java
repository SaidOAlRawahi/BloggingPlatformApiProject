package com.example.BloggingPlatformAPI.Controllers;

import com.example.BloggingPlatformAPI.Models.Blog;
import com.example.BloggingPlatformAPI.Models.Comment;
import com.example.BloggingPlatformAPI.Models.User;
import com.example.BloggingPlatformAPI.Services.BlogsService;
import com.example.BloggingPlatformAPI.Services.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
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
            @RequestParam(required = false) Integer authorId) {
        List<Blog> retrievedBlogs =  blogsService.getBlogs(id, title, tag, authorId);
        Set<Blog> blogs = new HashSet<>();
        blogs.addAll(retrievedBlogs);

        Map<String, Set<Blog>> response = new HashMap<>();
        response.put("blogs", blogs);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<String> add(@RequestBody Blog blog){
        blogsService.add(blog);
        return ResponseEntity.status(HttpStatus.CREATED).body("blog Added Successfully");
    }
    @PutMapping("/{blogId}")
    public ResponseEntity<String> edit(@RequestBody Blog blog, @PathVariable("blogId") Integer id){
        blogsService.edit(blog,id);
        return ResponseEntity.ok("Blog edited successfully");
    }

    @DeleteMapping("/{blogId}")
    public ResponseEntity<String> edit(@PathVariable("blogId") Integer id){
        blogsService.delete(id);
        return ResponseEntity.ok("Blog deleted successfully");
    }
    @GetMapping("/comments/all")
    public ResponseEntity<Map<String, List<Comment>>> getAllComments() {
        List<Comment> comments = commentsService.getAll();

        Map<String, List<Comment>> response = new HashMap<>();
        response.put("comments", comments);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/{blogId}/comments")
    public ResponseEntity<String> addComment(@RequestBody Comment comment, @PathVariable("blogId") Integer blogId) {
        Comment newComment = commentsService.add(comment, blogId);
        if (newComment != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Comment added successfully");
        }
        else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No blog with such Id");
        }
    }
}
