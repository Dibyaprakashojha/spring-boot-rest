package com.tutorapp.service;

import com.tutorapp.model.Category;
import com.tutorapp.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements ICategoryService{
    @Autowired
    ICategoryRepository iCategoryRepository;

    @Override
    public Category addCategory(Category category) {
        return iCategoryRepository.save(category);
    }

    @Override
    public void updateCategory(Category category) {
        iCategoryRepository.save(category);
    }

    @Override
    public void deleteCategory(int categoryId) {
        iCategoryRepository.deleteById(categoryId);
    }

    @Override
    public Category getById(int categoryID) {
        return iCategoryRepository.findById(categoryID).get();
    }

    @Override
    public List<Category> getByTopic(String topic) {
        return null;
    }

    @Override
    public List<Category> getByLanguage(String language) {
        return null;
    }
}
