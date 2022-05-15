package com.studentapp.service;

import com.studentapp.model.Student;
import com.studentapp.model.StudentDTO;

import java.util.List;

public interface IStudentService {
    Student addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(int studentId);

    Student getById(int studentId);
    List<Student> getAll();


    List<Student> getByDepartment(String department);
    List<Student> findByAddressCity(String city);
//    List<Student> findByDepartmentAndCity(String department,String city);
    List<Student> getByCity(String city);
//    List<Student> getByDepAndCity(String department, String city);
    List<Student> getByState(String department);

    StudentDTO getByStudentId(int studentId);

    int getCount(String city);


}
