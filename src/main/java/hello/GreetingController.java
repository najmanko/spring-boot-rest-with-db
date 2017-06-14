package hello;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

import hello.dao.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import hello.service.StudentService;

@RestController
public class GreetingController {

    @Autowired
    StudentService studentService;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/list")
    public List<Student> listOfStudents(@RequestParam(value="name", defaultValue="World") String name) {
        return studentService.getAllStudents();
    }

    @RequestMapping("/student")
    public Student saveStudent(@RequestParam(value="name", defaultValue="Random") String name) {
        Random random = new Random();
        String randomSurname = random.nextInt(100) + "";
        Student student = studentService.saveStudent(new Student(name, randomSurname));
        return student;
    }
}
