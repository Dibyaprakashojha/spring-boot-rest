package com.tutorapp.repository;

import com.tutorapp.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITrainerRepository extends JpaRepository<Trainer,Integer> {
//
//    List<Trainer> getByCourseNameContaining(String courseName);
//    List<Trainer> getByTechStackRatings(String techStack, double ratings);
//
//    @Query("from Trainer t inner join t.sub")
//    List<Trainer> getBySubCategoryTopic(String subcategory, String topic);
//    List<Trainer> getBySubCategoryLevel(String subcategory, String level);
//
//
//
//    List<Trainer> getByTopic(String topic);
//    List<Trainer> getByTopicLevel(String topic, String level);
//    List<Trainer> getByTopicFeatures(String topic, String features);
//    List<Trainer> getByTopicLanguage(String topic, String language);
}
