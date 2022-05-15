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
public class Features {
    @Id
    @GeneratedValue(generator = "feature_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "feature_gen",sequenceName = "feature_seq",initialValue = 100,allocationSize = 1)
    @ToString.Exclude
    private Integer featuresId;
    @Column(length = 50)
    private String featureName;

    public Features(String featureName) {
        this.featureName = featureName;
    }
}
