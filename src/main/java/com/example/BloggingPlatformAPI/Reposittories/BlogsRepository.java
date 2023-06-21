package com.example.BloggingPlatformAPI.Reposittories;

import com.example.BloggingPlatformAPI.Models.Blog;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlogsRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findByTitleContainingIgnoreCase(String title);
    List<Blog> findByTagsContainingIgnoreCase(String tag);
    @Query("SELECT * FROM blog AS b JOIN users AS u ON b.user_id = u.id WHERE u.id = :authorId;")
    List<Blog> findByAuthorId(Integer authorId);

}
