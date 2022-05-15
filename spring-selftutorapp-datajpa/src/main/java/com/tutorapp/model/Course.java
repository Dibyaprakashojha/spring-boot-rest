package com.tutorapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity

public class Course {
    @Id
    @GeneratedValue(generator = "course_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "course_gen",sequenceName = "course_seq",initialValue = 100,allocationSize = 1)
    @ToString.Exclude
    private Integer courseId;
    @Column(length = 50)
    private String courseName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "coursedetails_id") // this id will be added as foreign key in course table
    private CourseDetails details;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id") // this course_id will be added as foreign key in features table
    @ToString.Exclude
    private Set<Features> features; // one course can have many features like subtitles, quizez, assignments

    @ManyToOne
    @JoinColumn(name = "trainer_id") // this id will be added as foreign key in course table
    @ToString.Exclude
    private Trainer trainer;


    @ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinTable(name = "course_category",
            joinColumns = @JoinColumn(name = "course_id"),
    inverseJoinColumns = @JoinColumn(name = "category_id"))
    @ToString.Exclude
    private Set<Category> category;

    public Course(String courseName, CourseDetails details, Set<Features> features) {
        this.courseName = courseName;
        this.details = details;
        this.features = features;
    }
}
