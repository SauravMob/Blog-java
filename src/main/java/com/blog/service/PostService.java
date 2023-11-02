package com.blog.service;

import com.blog.entities.Post;
import com.blog.exception.IdNotFoundException;
import com.blog.repo.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<Post> fetchAllPosts(Long userId) {
        return postRepository.findByUserId(userId);
    }

    public List<Post> addPosts(Post p) {
        var post = Post.builder()
                .category(p.getCategory())
                .tags(p.getTags())
                .created_on(Instant.now())
                .details(p.getDetails())
                .image(p.getImage())
                .user_id(p.getUser_id())
                .title(p.getTitle())
                .updated_on(Instant.now())
                .build();
        postRepository.save(post);
        return postRepository.findAll();
    }

    public Post fetchPosts(Long id) throws IdNotFoundException {
        Optional<Post> post = postRepository.findById(id);
        if (post.isEmpty()) {
            throw new IdNotFoundException("Post with " + id + " not found");
        }
        return post.get();
    }

    public Post updatePosts(Long id, Post p) throws IdNotFoundException {
        Optional<Post> post = postRepository.findById(id);

        if (post.isEmpty()) {
            throw new IdNotFoundException("Post with " + id + " not found");
        }

        Post existingPost = post.get();

        existingPost.setCategory(p.getCategory());
        existingPost.setDetails(p.getDetails());
        existingPost.setUpdated_on(Instant.now());
        existingPost.setImage(p.getImage());
        existingPost.setTitle(p.getTitle());

        return postRepository.save(existingPost);
    }

    @Transactional
    public List<Post> deletePost(Long id) {
        postRepository.deleteById(id);
        return postRepository.findAll();
    }
}
