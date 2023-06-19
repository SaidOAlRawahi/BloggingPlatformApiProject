package com.example.BloggingPlatformAPI.Models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Comment extends BaseModel{
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    Integer id;
    String content;
    @ManyToOne
    @JoinColumn(name = "user_id")
    User author;
    @ManyToOne
    @JoinColumn(name = "blog_id")
    Blog parentBlog;
}
