package com.example.BloggingPlatformAPI.Services;

import com.example.BloggingPlatformAPI.Models.Blog;
import com.example.BloggingPlatformAPI.Models.User;
import com.example.BloggingPlatformAPI.Reposittories.BlogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BlogsService {
    @Autowired
    BlogsRepository blogsRepository;
    public Blog add(Blog blog) {
        Blog newBlog = new Blog();
        newBlog.setTags(blog.getTags());
        newBlog.setContent(blog.getContent());
        newBlog.setTitle(blog.getTitle());
        newBlog.setIsActive(true);
        newBlog.setCreatedDate(new Date());
        newBlog.setLastUpdated(newBlog.getCreatedDate());
        return blogsRepository.save(newBlog);
    }
    public Blog edit(Blog blog, Integer id) {
        Blog editedBlog = blogsRepository.findById(id).get();
        editedBlog.setTags(blog.getTags());
        editedBlog.setContent(blog.getContent());
        editedBlog.setTitle(blog.getTitle());
        editedBlog.setLastUpdated(new Date());
        return blogsRepository.save(editedBlog);
    }

    public void delete(Integer id){
        blogsRepository.deleteById(id);
    }

    public List<Blog> getAll(){
        return blogsRepository.findAll();
    }

    public List<Blog> getBlogs(Integer id, String title, String tag, Integer authorId) {
        List<Blog> blogs = new ArrayList<>();
        if (id != null){
            if(blogsRepository.existsById(id)){
                blogs.add(blogsRepository.findById(id).get());
            }
        }
        if (title != null){
            if(!blogsRepository.findByTitleContainingIgnoreCase(title).isEmpty()){
                blogs.addAll(blogsRepository.findByTitleContainingIgnoreCase(title));
            }
        }
        if (tag != null){
            if(!blogsRepository.findByTagsContainingIgnoreCase(tag).isEmpty()){
                blogs.addAll(blogsRepository.findByTagsContainingIgnoreCase(tag));
            }
        }
        if (authorId != null){
            if(!blogsRepository.findByAuthorId(authorId).isEmpty()){
                blogs.addAll(blogsRepository.findByAuthorId(authorId));
            }
        }
        return blogs;
    }



}
