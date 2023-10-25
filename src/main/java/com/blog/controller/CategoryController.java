package com.blog.controller;

import com.blog.dto.CategoryResponse;
import com.blog.entities.Category;
import com.blog.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    @Operation(summary = "Fetch All Categories")
    public ResponseEntity<List<Category>> getAllCategory() {
        return ResponseEntity.ok(categoryService.getAllCategory());
    }

    @Operation(summary = "Create New Category")
    @PostMapping("/category")
    public ResponseEntity<List<Category>> addCategory(
            @RequestBody CategoryResponse name
    ) {
        return ResponseEntity.ok(categoryService.addCategory(name));
    }

    @GetMapping("/category/{id}")
    @Operation(summary = "Fetch Category By Id")
    public ResponseEntity<Category> fetchCategory(
            @RequestParam Long id
    ) throws Exception {
        return ResponseEntity.ok(categoryService.fetchCategory(id));
    }

    @PutMapping("/category/{id}")
    @Operation(summary = "Update Category Name")
    public ResponseEntity<Category> updateCategory(
            @RequestParam Long id,
            @RequestBody CategoryResponse name
    ) throws Exception {
        return ResponseEntity.ok(categoryService.updateCategory(id, name));
    }

    @DeleteMapping("/category/{id}")
    @Operation(summary = "Delete Category By Id")
    public ResponseEntity<List<Category>> deleteCategory(
            @RequestParam Long id
    ) {
        return ResponseEntity.ok(categoryService.deleteCategory(id));
    }
}
