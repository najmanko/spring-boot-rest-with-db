package hello.dao;

import org.springframework.data.repository.Repository;

import java.util.List;

public interface StudentRepository extends Repository<Student, Long> {

    List<Student> findAll();

    Student findByNameIgnoringCase(String name);

    Student save(Student student);

}
