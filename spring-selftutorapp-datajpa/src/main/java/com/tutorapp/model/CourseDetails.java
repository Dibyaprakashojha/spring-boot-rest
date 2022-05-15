package com.tutorapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class CourseDetails {
    @Id
    @GeneratedValue(generator = "coursedetails_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "coursedetails_gen",sequenceName = "coursedetails_seq",initialValue = 74,allocationSize = 2)
    @ToString.Exclude
    private Integer coursedetailsId;
    @Column(length = 40)
    private String language;
    private double ratings;
    private double fees;
    private String description;
    private int durationInHours;
    private String level; // Beginner, Intermediate, Expert - enum

    public CourseDetails(String language, double ratings, double fees, String description, int durationInHours, String level) {
        this.language = language;
        this.ratings = ratings;
        this.fees = fees;
        this.description = description;
        this.durationInHours = durationInHours;
        this.level = level;
    }
}
