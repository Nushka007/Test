package com.myblogmicroservices.post.controller;

import com.myblogmicroservices.post.entity.Post;
import com.myblogmicroservices.post.repository.PostRepository;
import com.myblogmicroservices.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")

public class PostController {

  private PostService postService;

  public PostController(PostService postService) {
    this.postService = postService;
  }

  @PostMapping
  public ResponseEntity<Post>savePost(@RequestBody Post post){
    Post newPost = postService.savePost(post);
    return new ResponseEntity<>(newPost, HttpStatus.CREATED) ;
  }

  @GetMapping("{postId}")
  public Post getPostById(@PathVariable String postId ){
   Post post = postService.findById(postId);
   return post;
  }

}
