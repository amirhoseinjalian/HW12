package com.jalian.hw12.service.impl;
import com.jalian.hw12.base.service.impl.BaseEntityServiceImpl;
import com.jalian.hw12.domain.Adress;
import com.jalian.hw12.domain.Student;
import com.jalian.hw12.domain.Teacher;
import com.jalian.hw12.repository.TeacherRepository;
import com.jalian.hw12.service.TeacherService;
import java.util.List;
public class TeacherServiceImpl extends BaseEntityServiceImpl<Teacher, String, TeacherRepository> implements TeacherService {
    public TeacherServiceImpl(TeacherRepository repository) {
        super(repository);
    }

    @Override
    public List getStudents(Teacher teacher) {
        repository.getEntityManager().getTransaction().begin();
        List<Student> students = repository.getStudents(teacher);
        repository.getEntityManager().getTransaction().commit();
        return students;
    }

    @Override
    public Adress getAdress(Teacher teacher) {
        repository.getEntityManager().getTransaction().begin();
        Adress adress = repository.getAdress(teacher);
        repository.getEntityManager().getTransaction().begin();
        return adress;
    }
}