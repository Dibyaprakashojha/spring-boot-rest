package com.studentapp.model;

public interface StudentDTO {
    String getName();
    String getDepartment();
    AddressDTO getAddress();
    //nested interface
    interface AddressDTO {
        String getCity();
    }
}
