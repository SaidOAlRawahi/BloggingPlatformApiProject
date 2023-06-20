package com.example.BloggingPlatformAPI.Reposittories;

import com.example.BloggingPlatformAPI.Models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlogsRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findByTitleContainingIgnoreCase(String title);
    List<Blog> findByTagsContainingIgnoreCase(String tag);
    List<Blog> findByAuthorId(Integer authorId);

}
