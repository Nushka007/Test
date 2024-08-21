package com.myblogmicroservices.post.repository;

import com.myblogmicroservices.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, String> {

}