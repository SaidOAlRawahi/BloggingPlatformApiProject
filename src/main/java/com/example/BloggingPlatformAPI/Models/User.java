package com.example.BloggingPlatformAPI.Models;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class User extends BaseModel{
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    Integer id;
    String userName;
    String email;
    String password;
    @OneToMany(mappedBy = "blogOwner", cascade = CascadeType.ALL)
    private List<Blog> blogs;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Comment> comments;
}
