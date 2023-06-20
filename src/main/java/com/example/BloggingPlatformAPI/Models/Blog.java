package com.example.BloggingPlatformAPI.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    User author;
    @JsonIgnore
    @OneToMany(mappedBy = "parentBlog", cascade = CascadeType.ALL)
    private List<Comment> comments;
}
