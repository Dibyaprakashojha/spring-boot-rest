package com.tutorapp.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Trainer {
    @Id
    @GeneratedValue(generator = "trainer_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "trainer_gen",sequenceName = "trainer_seq",initialValue = 20,allocationSize = 1)
    @ToString.Exclude
    private Integer trainerId;

    @Column(length = 40)
    private String trainerName;

    private double ratings;

    private int experience;

    private int numberOfStudents;

    private String techStack; // enum

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "trainer_id") // trainer_id will be added to course table
    @ToString.Exclude
    private Set<Course> courses;

    public Trainer(String trainerName, double ratings, int experience, int numberOfStudents, String techStack) {
        this.trainerName = trainerName;
        this.ratings = ratings;
        this.experience = experience;
        this.numberOfStudents = numberOfStudents;
        this.techStack = techStack;
    }





}
