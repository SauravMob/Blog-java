package com.blog.repo;

import com.blog.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    Optional<Post> findById(Long id);

    @Query(value = "select * from test.post where user_id=:userId", nativeQuery = true)
    List<Post> findByUserId(Long userId);

    void deleteById(Long id);
}
