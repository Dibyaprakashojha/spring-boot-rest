package com.tutorapp.repository;

import com.tutorapp.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category,Integer> {

//
//    List<Category> getByTopic(String topic);
//    List<Category> getByLanguage(String language);
}
