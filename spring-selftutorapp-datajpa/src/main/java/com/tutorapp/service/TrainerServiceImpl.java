package com.tutorapp.service;

import com.tutorapp.model.Trainer;
import com.tutorapp.repository.ITrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerServiceImpl implements ITrainerService{
    @Autowired
    ITrainerRepository iTrainerRepository;

    @Override
    public Trainer addTrainer(Trainer trainer) {
        return iTrainerRepository.save(trainer);
    }

    @Override
    public void updateTrainer(Trainer trainer) {
        iTrainerRepository.save(trainer);
    }

    @Override
    public void deleteTrainer(int trainerId) {
        iTrainerRepository.deleteById(trainerId);
    }

    @Override
    public Trainer getById(int trainerID) {
        return iTrainerRepository.findById(trainerID).get();
    }

    @Override
    public List<Trainer> getByCourseNameContaining(String courseName) {
        return null;
    }

    @Override
    public List<Trainer> getByTechStackRatings(String techStack, double ratings) {
        return null;
    }

    @Override
    public List<Trainer> getBySubCategoryTopic(String subcategory, String topic) {
        return null;
    }

    @Override
    public List<Trainer> getBySubCategoryLevel(String subcategory, String level) {
        return null;
    }

    @Override
    public List<Trainer> getByTopic(String topic) {
        return null;
    }

    @Override
    public List<Trainer> getByTopicLevel(String topic, String level) {
        return null;
    }

    @Override
    public List<Trainer> getByTopicFeatures(String topic, String features) {
        return null;
    }

    @Override
    public List<Trainer> getByTopicLanguage(String topic, String language) {
        return null;
    }
}
