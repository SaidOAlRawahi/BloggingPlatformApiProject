package com.example.BloggingPlatformAPI.Services;

import com.example.BloggingPlatformAPI.Models.Blog;
import com.example.BloggingPlatformAPI.Models.Comment;
import com.example.BloggingPlatformAPI.Models.User;
import com.example.BloggingPlatformAPI.Reposittories.BlogsRepository;
import com.example.BloggingPlatformAPI.Reposittories.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentsService {
    @Autowired
    CommentsRepository commentsRepository;
    @Autowired
    BlogsRepository blogsRepository;

    public List<Comment> getAll(){
        return commentsRepository.findAll();
    }

    public Comment add(Comment comment, Integer id){
        Comment newComment = new Comment();
        Blog parentBlog = blogsRepository.findById(id).orElse(null);
        if(parentBlog != null) {
            newComment.setAuthor(comment.getAuthor());
            newComment.setParentBlog(parentBlog);
            newComment.setContent(comment.getContent());
            newComment.setIsActive(true);
            newComment.setCreatedDate(new Date());
            newComment.setLastUpdated(newComment.getCreatedDate());
            return commentsRepository.save(newComment);
        }
        else {
            return null;
        }
    }
}
