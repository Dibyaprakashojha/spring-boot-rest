package com.tutorapp;

import com.tutorapp.model.*;
import com.tutorapp.service.ICategoryService;
import com.tutorapp.service.ICourseService;
import com.tutorapp.service.ITrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SpringSelftutorappDatajpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringSelftutorappDatajpaApplication.class, args);
	}

	@Autowired
	ICourseService courseService;

	@Autowired
	ITrainerService trainerService;

	@Autowired
	ICategoryService categoryService;

	@Override
	public void run(String... args) throws Exception {
//		Trainer trainer1 = new Trainer("Sripriya", 4.9, 12, 550, TechStack.FULLSTACK.name());
//		Trainer trainer2 = new Trainer("Awadhesh", 3.8, 5, 60, TechStack.FULLSTACK.name());
//		Trainer trainer3 = new Trainer("Abuthair", 3.5, 2, 35, TechStack.FULLSTACK.name());
//		Trainer trainer4 = new Trainer("Madhu", 3.7, 3, 62, TechStack.CLOUD_COMPUTING.name());
//		Trainer trainer5 = new Trainer("Sandeep", 3.9, 4, 94, TechStack.CLOUD_COMPUTING.name());
//		Trainer trainer6 = new Trainer("Sikindar", 3.3, 3, 62, TechStack.DATABASE.name());
//		Trainer trainer7 = new Trainer("Baba", 3.1, 4, 94, TechStack.DATABASE.name());
//		Trainer trainer8 = new Trainer("Febina", 4.9, 12, 550, TechStack.TESTING.name());
//		Trainer trainer9 = new Trainer("Ashfaq", 3.8, 5, 89, TechStack.BACKEND.name());
//		Trainer trainer10 = new Trainer("Suresh", 3.5, 2, 42, TechStack.FULLSTACK.name());
//		Trainer trainer11 = new Trainer("Sindhu", 3.7, 3, 71, TechStack.BACKEND.name());
//		Trainer trainer12 = new Trainer("Shamili", 3.9, 4, 99, TechStack.CLOUD_COMPUTING.name());
//		Trainer trainer13 = new Trainer("Dibya", 4.3, 8, 246, TechStack.FULLSTACK.name());
//		Trainer trainer14 = new Trainer("Akash", 3.1, 4, 58, TechStack.TESTING.name());
//		Trainer trainer15 = new Trainer("Vivek", 3.1, 4, 127, TechStack.DATABASE.name());

//		trainerService.addTrainer(trainer1);
//		trainerService.addTrainer(trainer2);
//		trainerService.addTrainer(trainer3);
//		trainerService.addTrainer(trainer4);
//		trainerService.addTrainer(trainer5);
//		trainerService.addTrainer(trainer6);
//		trainerService.addTrainer(trainer7);
//		trainerService.addTrainer(trainer8);
//		trainerService.addTrainer(trainer9);
//		trainerService.addTrainer(trainer10);
//		trainerService.addTrainer(trainer11);
//		trainerService.addTrainer(trainer12);
//		trainerService.addTrainer(trainer13);
//		trainerService.addTrainer(trainer14);
//		trainerService.addTrainer(trainer15);

		SubCategory sub1 = new SubCategory("Web Development", Topic.ANGULAR.getTopicName());
		SubCategory sub2 = new SubCategory("Programming", Topic.SPRING.getTopicName());
		SubCategory sub3 = new SubCategory("Database Design", Topic.MONGO_DB.getTopicName());
		SubCategory sub4 = new SubCategory("Software Testing", Topic.SELENIUM.getTopicName());
		SubCategory sub5 = new SubCategory("Data Science", Topic.PYTHON.getTopicName());

		Set<SubCategory> subCategories1 = new HashSet<>(Arrays.asList(sub1,sub2,sub3,sub4,sub5));
//		categoryService.addCategory(new Category("Development",subCategories1));

		Features features1 = new Features("Sub-titles");
		Features features2 = new Features("Quizzes");
		Features features3 = new Features("Coding");
		Features features4 = new Features("Practice");
		Set<Features> featuresSet = new HashSet<>(Arrays.asList(features1,features2,features3,features4));


		CourseDetails details1 = new CourseDetails("English", 4.5, 670, "Basic Course in Java", 60, Level.BEGINNER.name());

		Course course1 = new Course("Java for Beginners in 10 days", details1, featuresSet);
		Trainer trainer1 = trainerService.getById(20);
		course1.setTrainer(trainer1);

		courseService.addCourse(course1);
	}
}
