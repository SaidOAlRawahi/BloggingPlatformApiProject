package com.example.BloggingPlatformAPI.Models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Blog extends BaseModel {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    Integer id;
    String title;
    String content;
    @ElementCollection
    Set<String> tags;
    @ManyToOne
    @JoinColumn(name = "user_id")
    User blogOwner;
    @OneToMany(mappedBy = "parentBlog", cascade = CascadeType.ALL)
    private List<Comment> comments;
}
