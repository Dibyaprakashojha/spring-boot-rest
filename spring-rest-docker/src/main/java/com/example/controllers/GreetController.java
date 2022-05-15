package com.example.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class GreetController {

    @RequestMapping("/greet")
    public String greetMessage() {
        return "Have a great day";
    }

    @GetMapping("/show/{choice}") //this is same as below
    public List<String> showCourses(@PathVariable("choice") String choice) {
        return Arrays.asList("Java","Spring","Node","CSS","Javascript")
                .stream().filter(course -> course.startsWith(choice)).collect(Collectors.toList());
    }
}

