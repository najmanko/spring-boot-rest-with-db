package cz.najman.controller;

import java.util.List;
import java.util.Random;

import cz.najman.service.StudentService;
import cz.najman.dao.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping("/list")
    public List<Student> listOfStudents(@RequestParam(value="name", defaultValue="World") String name) {
        return studentService.getAllStudents();
    }

    @RequestMapping("/student")
    public Student saveStudent(@RequestParam(value="name", defaultValue="Random") String name,
                               @RequestParam(value="age", defaultValue="20") int age) {
        Random random = new Random();
        String randomSurname = random.nextInt(100) + "";
        Student student = studentService.saveStudent(new Student(name, randomSurname, age));
        return student;
    }
}
