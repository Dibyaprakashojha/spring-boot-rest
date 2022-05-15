package com.studentapp.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Address {
    @Id
    @GeneratedValue(generator = "add_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "add_gen",sequenceName = "add_sequence",initialValue = 10,allocationSize = 10)
    private Integer addressId;
    @Column(length = 20)
    private String city;
    @Column(length = 20)
    private String state;

    public Address(String city, String state) {
        this.city = city;
        this.state = state;
    }
}
