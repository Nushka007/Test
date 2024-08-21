package com.myblogmicroservices.post.service;

import com.myblogmicroservices.post.entity.Post;
import com.myblogmicroservices.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
@Service
public class PostService {


    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post savePost(Post post){
        String postId = UUID.randomUUID().toString();
        post.setId(postId);
        Post savedPost = postRepository.save(post);
        return savedPost;
    }

    public Post findById(String postId) {
        Optional<Post> byId = postRepository.findById(postId);
        Post post;
        if (byId.isPresent()) {
            post = byId.get();
        } else {
            return null;
        }
        return post;
    }
}
