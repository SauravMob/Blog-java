package com.blog.service;

import com.blog.dto.CategoryResponse;
import com.blog.entities.Category;
import com.blog.exception.IdNotFoundException;
import com.blog.repo.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

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

    public Category fetchCategory(Long id) throws IdNotFoundException{
        Optional<Category> category = categoryRepository.findById(id);

        if (category.isEmpty()) {
            throw new IdNotFoundException("Category with " + id + " not found");
        }

        return category.get();
    }

    public Category updateCategory(Long id, CategoryResponse name) throws IdNotFoundException {
        Optional<Category> category = categoryRepository.findById(id);
        Category newCategory = new Category();

        if (category.isEmpty()) {
            throw new IdNotFoundException("Category with " + id + " not found");
        }

        newCategory.setId(id);
        newCategory.setName(name.getName());
        return categoryRepository.save(newCategory);
    }

    @Transactional
    public List<Category> deleteCategory(Long id) {
        categoryRepository.deleteById(id);
        return categoryRepository.findAll();
    }
}
