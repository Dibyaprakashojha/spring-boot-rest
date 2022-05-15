package com.tutorapp.service;

import com.tutorapp.model.Trainer;

import java.util.List;

public interface ITrainerService {
    Trainer addTrainer(Trainer trainer);
    void updateTrainer(Trainer trainer);
    void deleteTrainer(int trainerId);
    Trainer getById(int trainerID);

    List<Trainer> getByCourseNameContaining(String courseName);
    List<Trainer> getByTechStackRatings(String techStack, double ratings);


    List<Trainer> getBySubCategoryTopic(String subcategory, String topic);
    List<Trainer> getBySubCategoryLevel(String subcategory, String level);



    List<Trainer> getByTopic(String topic);
    List<Trainer> getByTopicLevel(String topic, String level);
    List<Trainer> getByTopicFeatures(String topic, String features);
    List<Trainer> getByTopicLanguage(String topic, String language);



}
