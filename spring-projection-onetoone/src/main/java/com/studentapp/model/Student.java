package com.studentapp.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Student {
    @Column(length = 30)
    private String name;
    @Id
    @GeneratedValue(generator = "stud_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "stud_gen",sequenceName = "stud_sequence",initialValue = 1,allocationSize = 1)
    private Integer studentId;
    @Column(length = 30)
    private String department;

    //when the parent ref. is saved then all the child ref. is saved automatically using casade
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    public Student(String name, String department, Address address) {
        this.name = name;
        this.department = department;
        this.address = address;
    }
}
