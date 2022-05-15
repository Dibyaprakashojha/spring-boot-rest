package com.studentapp.repository;

import com.studentapp.model.Student;
import com.studentapp.model.StudentDTO;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentRepository extends JpaRepository<Student,Integer> {

    //derived
    List<Student> findByDepartment(String department);
    List<Student> findByAddressCity(String city, Sort sort);
//    List<Student> findByDepartmentAndCity(String department,String city);

//    @Query("from Student s inner join s.address a where s.department=?1 and a.city=?2")
//    List<Student> findByDeptAndCity(String department, String city);

    @Query("from Student s inner join s.address a where a.state=?1")
    List<Student> findByState(String state);

    @Query("from Student s inner join s.address a where a.city=?1")
    List<Student> findByCity(String city,Sort sort);

    // projection
    @Query("from Student s inner join s.address a where s.studentId=?1")
    StudentDTO getByStudentId(int studentId);

    // view -> from Student s inner join s.address a where s.department=?1 and a.city=?2

    // stored -> count of students from a particular city
    @Procedure(procedureName = "COUNT_OF_STUDENTS_BY_CITY")
    int getCount(String city);
}
