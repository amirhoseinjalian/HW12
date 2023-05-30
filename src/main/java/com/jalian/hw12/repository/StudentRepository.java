package com.jalian.hw12.repository;
import com.jalian.hw12.base.repository.BaseEntityRepository;
import com.jalian.hw12.domain.Adress;
import com.jalian.hw12.domain.Student;
import com.jalian.hw12.domain.Teacher;
import java.util.List;
import java.util.Set;
public interface StudentRepository extends BaseEntityRepository <Student, String> {
    List<Teacher> getTeachers(Student student);
    Set<Adress> getAdresses(Student student);
}