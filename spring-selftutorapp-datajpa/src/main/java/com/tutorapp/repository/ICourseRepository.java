package com.tutorapp.repository;

import com.tutorapp.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseRepository extends JpaRepository<Course,Integer> {

//    List<Course> findByCategory(String category);
//    @Query("from Course c inner join c.category cat where cat.categoryName=?1 " +
//            "inner join c.details cd where cd.level=?2")
//    List<Course> findByCategoryLevel(String category, String level);
//    List<Course> findByCategorySub(String category, String subcategory);
//
//
//    List<Course> findBySubCategory(String subcategory);
//    List<Course> findBySubCategoryTopic(String subcategory, String topic);
//    List<Course> findBySubCategoryLevel(String subcategory, String level);
//
//
//    List<Course> findByLanguage(String language);
//    List<Course> findByLanguageRatings(String language, double ratings);
//
//    List<Course> findByTopic(String topic);
//    List<Course> findByTopicFeatures(String topic, String features);
//    List<Course> findByTopicLevel(String topic, String level);
//
//    List<Course> findByTrainer(String trainerName);
}
