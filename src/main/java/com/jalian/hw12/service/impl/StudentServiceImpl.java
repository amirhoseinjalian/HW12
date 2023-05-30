package com.jalian.hw12.service.impl;
import com.jalian.hw12.base.service.impl.BaseEntityServiceImpl;
import com.jalian.hw12.domain.Adress;
import com.jalian.hw12.domain.Student;
import com.jalian.hw12.domain.Teacher;
import com.jalian.hw12.repository.StudentRepository;
import com.jalian.hw12.service.StudentService;
import java.util.List;
import java.util.Set;
public class StudentServiceImpl extends BaseEntityServiceImpl<Student, String, StudentRepository> implements StudentService {
    public StudentServiceImpl(StudentRepository repository) {
        super(repository);
    }

    @Override
    public List<Teacher> getTeachers(Student student) {
        repository.getEntityManager().getTransaction().begin();
        List<Teacher> teachers = repository.getTeachers(student);
        repository.getEntityManager().getTransaction().commit();
        return teachers;
    }

    @Override
    public Set<Adress> getAdresses(Student student) {
        repository.getEntityManager().getTransaction().begin();
        Set<Adress> adresses = repository.getAdresses(student);
        repository.getEntityManager().getTransaction().commit();
        return adresses;
    }
}
