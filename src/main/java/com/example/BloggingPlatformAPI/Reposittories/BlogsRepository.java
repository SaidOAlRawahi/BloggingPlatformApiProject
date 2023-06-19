package com.example.BloggingPlatformAPI.Reposittories;

import com.example.BloggingPlatformAPI.Models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogsRepository extends JpaRepository<Blog,Integer> {
}
