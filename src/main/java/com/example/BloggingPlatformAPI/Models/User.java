package com.example.BloggingPlatformAPI.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User extends BaseModel{
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    Integer id;
    String username;
    String email;
    String password;
    @JsonIgnore
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Blog> blogs;
}
