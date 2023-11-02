package com.blog.controller;

import com.blog.entities.Post;
import com.blog.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    @Operation(summary = "Fetch All Posts")
    public ResponseEntity<List<Post>> fetchAllPosts(Long userId) {
        return ResponseEntity.ok(postService.fetchAllPosts(userId));
    }

    @Operation(summary = "Create New Post")
    @PostMapping("/posts")
    public ResponseEntity<List<Post>> addPost(
            @RequestBody Post post
    ) {
        return ResponseEntity.ok(postService.addPosts(post));
    }

    @GetMapping("/post/{id}")
    @Operation(summary = "Fetch Post By Id")
    public ResponseEntity<Post> fetchPost(
            @RequestParam Long id
    ) throws Exception {
        return ResponseEntity.ok(postService.fetchPosts(id));
    }

    @PutMapping("/post/{id}")
    @Operation(summary = "Update Post Name")
    public ResponseEntity<Post> updateCategory(
            @RequestParam Long id,
            @RequestBody Post post
    ) throws Exception {
        return ResponseEntity.ok(postService.updatePosts(id, post));
    }

    @DeleteMapping("/post/{id}")
    @Operation(summary = "Delete Post By Id")
    public ResponseEntity<List<Post>> deleteCategory(
            @RequestParam Long id
    ) {
        return ResponseEntity.ok(postService.deletePost(id));
    }
}
