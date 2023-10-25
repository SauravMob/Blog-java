package com.blog.service;

import com.blog.dto.CategoryResponse;
import com.blog.entities.Category;
import com.blog.repo.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    public List<Category> addCategory(CategoryResponse name) {
        var category = Category.builder()
                .name(name.getName())
                .build();
        categoryRepository.save(category);
        return categoryRepository.findAll();
    }

    public Category fetchCategory(Long id) {
        return categoryRepository.findById(id);
    }

    public Category updateCategory(Long id, String name) {
        var category = categoryRepository.findById(id);
        category.setName(name);
        categoryRepository.save(category);
        return category;
    }

    @Transactional
    public List<Category> deleteCategory(String name) {
        categoryRepository.deleteByName(name);
        return categoryRepository.findAll();
    }
}
