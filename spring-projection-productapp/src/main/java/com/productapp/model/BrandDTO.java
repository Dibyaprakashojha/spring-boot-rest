package com.productapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

// use only the properties that you want to retrieve
// should have ONLY PARAMETERIZED CONSTRUCTOR
// should have only GETTER METHODS
// should have ONLY tOString
// the properties name should be same as domain model

@AllArgsConstructor
@Getter
@ToString
public class BrandDTO {
    String name;
    double price;

}
