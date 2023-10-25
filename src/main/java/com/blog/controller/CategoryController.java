package com.blog.controller;

import com.blog.dto.CategoryResponse;
import com.blog.entities.Category;
import com.blog.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public ResponseEntity<List<Category>> getAllCategory() {
        return ResponseEntity.ok(categoryService.getAllCategory());
    }

    @PostMapping("/category")
    public ResponseEntity<List<Category>> addCategory(
            @RequestBody CategoryResponse name
    ) {
        return ResponseEntity.ok(categoryService.addCategory(name));
    }

    @GetMapping("/fetch-category")
    public ResponseEntity<Category> fetchCategory(
            @RequestParam Long id
    ) {
        return ResponseEntity.ok(categoryService.fetchCategory(id));
    }

    @PutMapping("/edit-category")
    public ResponseEntity<Category> updateCategory(
            @RequestParam Long id,
            @RequestBody String name
    ) {
        return ResponseEntity.ok(categoryService.updateCategory(id, name));
    }

    @DeleteMapping("/delete-category")
    public ResponseEntity<List<Category>> deleteCategory(
            @RequestBody String name
    ) {
        return ResponseEntity.ok(categoryService.deleteCategory(name));
    }
}
