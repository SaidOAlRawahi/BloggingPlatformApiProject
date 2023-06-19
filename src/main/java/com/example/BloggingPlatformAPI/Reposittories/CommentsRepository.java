package com.example.BloggingPlatformAPI.Reposittories;

import com.example.BloggingPlatformAPI.Models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository extends JpaRepository<Comment,Integer> {
}
