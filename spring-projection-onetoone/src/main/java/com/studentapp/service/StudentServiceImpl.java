package com.studentapp.service;

import com.studentapp.model.Student;
import com.studentapp.model.StudentDTO;
import com.studentapp.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class StudentServiceImpl implements IStudentService{

    private IStudentRepository iStudentRepository;

    @Autowired
    public StudentServiceImpl(IStudentRepository iStudentRepository) {
        this.iStudentRepository = iStudentRepository;
    }

    @Override
    public Student addStudent(Student student) {
        return iStudentRepository.save(student);
    }

    @Override
    public void updateStudent(Student student) {
        iStudentRepository.save(student);
    }

    @Override
    public void deleteStudent(int studentId) {
        iStudentRepository.deleteById(studentId);
    }

    @Override
    public Student getById(int studentId) {
        return iStudentRepository.findById(studentId).get();
    }

    @Override
    public List<Student> getAll() {
        // a class used for sorting by property
        // use static method "by" of sort
        return iStudentRepository.findAll(Sort.by("name")); // this is an inbuilt method
    }

    @Override
    public List<Student> getByDepartment(String department) {
        return iStudentRepository.findByDepartment(department);
    }

    @Override
    public List<Student> findByAddressCity(String city) {
        return iStudentRepository.findByAddressCity(city,Sort.by(Sort.Direction.ASC, "name")); // create the method with sort as parameter
    }

//    @Override
//    public List<Student> findByDepartmentAndCity(String department, String city) {
//        return iStudentRepository.findByDepartmentAndCity(department, city);
//    }

    @Override
    public List<Student> getByCity(String city) {
        return iStudentRepository.findByCity(city,Sort.by(Sort.Direction.DESC, "name"));
    }

//    @Override
//    public List<Student> getByDepAndCity(String department, String city) {
//        return iStudentRepository.findByDeptAndCity(department, city);
//    }

    @Override
    public List<Student> getByState(String department) {
        return iStudentRepository.findByState(department);
    }

    @Override
    @Transactional
    public StudentDTO getByStudentId(int studentId) {
        return iStudentRepository.getByStudentId(studentId);
    }

    @Override
    public int getCount(String city) {
        return iStudentRepository.getCount(city);
    }
}
