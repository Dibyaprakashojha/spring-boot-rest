package com.tutorapp.service;

import com.tutorapp.model.Course;

import java.util.List;

public interface ICourseService {
    Course addCourse(Course course);
    void updateCourse(Course course);
    void deleteCourse(int courseId);
    Course getById(int courseID);

    List<Course> getByCategory(String category);
    List<Course> getByCategoryLevel(String category, String level);
    List<Course> getByCategorySub(String category, String subcategory);


    List<Course> getBySubCategory(String subcategory);
    List<Course> getBySubCategoryTopic(String subcategory, String topic);
    List<Course> getBySubCategoryLevel(String subcategory, String level);


    List<Course> getByLanguage(String language);
    List<Course> getByLanguageRatings(String language, double ratings);

    List<Course> getByTopic(String topic);
    List<Course> getByTopicFeatures(String topic, String features);
    List<Course> getByTopicLevel(String topic, String level);

    List<Course> getByTrainer(String trainerName);








}
