package com.tutorapp.service;

import com.tutorapp.model.Category;

import java.util.List;

public interface ICategoryService {
    Category addCategory(Category category);
    void updateCategory(Category category);
    void deleteCategory(int categoryId);
    Category getById(int categoryID);

    List<Category> getByTopic(String topic);
    List<Category> getByLanguage(String language);

}
