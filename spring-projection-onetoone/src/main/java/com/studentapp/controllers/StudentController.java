package com.studentapp.controllers;

import com.studentapp.model.Student;
import com.studentapp.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student-api")
public class StudentController {
    @Autowired
    IStudentService iStudentService;

//    @PostMapping("/students")
//    public ResponseEntity<Void> addStudent(@RequestBody Student student) {
//        iStudentService.addStudent(student);
//        return ResponseEntity.status(HttpStatus.CREATED).build();
//
//    }
//
//    @DeleteMapping("/students/student-id/{productId}")
//    public ResponseEntity<Void> deleteStudent(@PathVariable("productId") int productId) {
//        iStudentService.deleteStudent(productId);
//        ResponseEntity<Void> responseEntity =
//                ResponseEntity.status(HttpStatus.OK)
//                        .header("desc", "deleting one student by id")
//                        .build();
//        return responseEntity;
//    }
//
//    @PutMapping("/students")
//    public ResponseEntity<Void> updateStudent(@RequestBody Student student) {
//        iStudentService.updateStudent(student);
//        ResponseEntity<Void> responseEntity =
//                ResponseEntity.status(HttpStatus.ACCEPTED).build();
//        return responseEntity;
//    }
//
//    @GetMapping("/students/student-id/{productId}")
//    public ResponseEntity<Student> getById(@PathVariable("productId") int productId) {
//        Student student = iStudentService.getById(productId);
//        return ResponseEntity.ok().header("desc", "get by id").body(student);
//    }
//
//    @GetMapping("/students")
//    public ResponseEntity<List<Student>> getAll() {
//        List<Student> students = iStudentService.getAll();
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("desc", "getting all students");
//        headers.add("info", "get all method called");
//        ResponseEntity<List<Student>> productResponseEntity =
//                new ResponseEntity(students, headers, HttpStatus.OK);
//        return productResponseEntity;
//    }
//
//    @GetMapping("/students/category/{category}")
//    public ResponseEntity<List<Student>> getByCategory(@PathVariable("category") String category) {
//        List<Student> students = iStudentService.getByCategory(category);
//        return ResponseEntity.ok().header("desc", "get by category").body(students);
//    }
//
//    @GetMapping("/students/choice/{choice}")
//    public ResponseEntity<List<Student>> getByChoice(@PathVariable("choice") String choice) {
//        List<Student> students = iStudentService.getByChoice(choice);
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("desc", "get by choice");
//        ResponseEntity<List<Student>> productResponse = ResponseEntity.ok().headers(httpHeaders).body(students);
//        return productResponse;
//    }
//
//    @GetMapping("/students/price/{price}")
//    public ResponseEntity<List<Student>> getByPriceLessThan(@PathVariable("price") double price) {
//        List<Student> students = iStudentService.getByPriceLessThan(price);
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("desc", "get by price");
//        return ResponseEntity.ok().headers(httpHeaders).body(students);
//
//    }
//
//    @GetMapping("/students/brand-start/{brand}")
//    public ResponseEntity<List<Student>> getByBrandStartingWith(@PathVariable("brand") String brand) {
//        List<Student> students = iStudentService.getByBrandStartingWith(brand);
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("desc", "get by brand");
//        ResponseEntity<List<Student>> productResponse = ResponseEntity.ok().headers(httpHeaders).body(students);
//        return productResponse;
//    }
//
//    @GetMapping("/students/brand/{brand}")
//    public ResponseEntity<List<BrandDTO>> getByBrand(@PathVariable("brand") String brand) {
//        List<BrandDTO> students = iStudentService.getByBrand(brand);
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("desc", "get by brand");
//        return ResponseEntity.ok().headers(httpHeaders).body(students);
//    }
//
//    @GetMapping("/students/category/{category}/price/{price}")
//    public ResponseEntity<List<CategoryDTO>> getByCategoryAndPriceLessThan(@PathVariable("category") String category, @PathVariable("price") double price) {
//        List<CategoryDTO> students = iStudentService.getByCategoryAndPriceLessThan(category, price);
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("desc", "get by category and price");
//        return ResponseEntity.ok().headers(httpHeaders).body(students);
//    }
//
//    @GetMapping("/students/name/{name}")
//    public ResponseEntity<StudentDetails> getByName(@PathVariable("name") String name) {
//        StudentDetails students = iStudentService.getByName(name);
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("desc", "get by name");
//        return ResponseEntity.ok().headers(httpHeaders).body(students);
//    }
//
//    @GetMapping("/students/all")
//    public ResponseEntity<List<StudentView>> getAllStudents() {
//        List<StudentView> students = iStudentService.getAllStudents();
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("desc", "get all");
//        return ResponseEntity.ok().headers(httpHeaders).body(students);
//    }
//
//    @GetMapping("/students/all/brand/{brand}")
//    public ResponseEntity<List<StudentBrandView>> getByBrandStudent(@PathVariable("brand") String brand) {
//        List<StudentBrandView> students = iStudentService.getByBrandStudent(brand);
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("desc", "get by brand View");
//        return ResponseEntity.ok().headers(httpHeaders).body(students);
//    }
//
//    @GetMapping("/students/all/brandex/{brand}")
//    public ResponseEntity<List<String>> getAllStudentsBrandEx(@PathVariable("brand") String brand) {
//        List<StudentDetailsEx> students = iStudentService.findByBrand(brand);
//        HttpHeaders httpHeaders = new HttpHeaders();
//        List<String> pdata = new ArrayList<>();
//        for (StudentDetailsEx prod:students) {
//            String data = prod.getStudent();
//            pdata.add(data);
//        }
//        httpHeaders.add("desc", "get by brand open projection");
//        ResponseEntity<List<String>> productResponse = ResponseEntity.ok().headers(httpHeaders).body(pdata);
//        return productResponse;
//    }
//
//    @GetMapping("/students/get-all")
//    public ResponseEntity<List<Student>> readAllStudents() {
//        List<Student> students = iStudentService.readAllStudents();
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("desc", "get all by stored procedure");
//        return ResponseEntity.ok().headers(httpHeaders).body(students);
//    }
//
//    @GetMapping("/students/all/read-brand/{brand}")
//    public ResponseEntity<List<Student>> readByBrandStudent(@PathVariable("brand") String brand) {
//        List<Student> students = iStudentService.readByBrand(brand);
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("desc", "get by brand Procedure");
//        return ResponseEntity.ok().headers(httpHeaders).body(students);
//    }
//    @GetMapping("/students/total-cost/{brand}")
//    public ResponseEntity<Double> getTotalCost(@PathVariable("brand") String brand) {
//        double student = iStudentService.getTotalCost(brand);
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("desc", "total cost by brand Stored-Procedure");
//        return ResponseEntity.ok().headers(httpHeaders).body(student);
//    }

    @GetMapping("/students/count/{city}")
    public ResponseEntity<Double> getCount(@PathVariable("city") String city) {
        double count = iStudentService.getCount(city);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "count of students by Stored-Procedure");
        return ResponseEntity.ok().headers(httpHeaders).body(count);
    }



}
