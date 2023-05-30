package com.jalian.hw12.service;
import com.jalian.hw12.base.service.BaseEntityService;
import com.jalian.hw12.domain.Adress;
import com.jalian.hw12.domain.Student;
import com.jalian.hw12.domain.Teacher;
import java.util.List;
import java.util.Set;
public interface StudentService extends BaseEntityService<Student, String> {
    List<Teacher> getTeachers(Student student);
    Set<Adress> getAdresses(Student student);
}
