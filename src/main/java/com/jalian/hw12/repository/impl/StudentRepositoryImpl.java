package com.jalian.hw12.repository.impl;
import com.jalian.hw12.base.repository.impl.BaseEntityRepositoryImpl;
import com.jalian.hw12.domain.Adress;
import com.jalian.hw12.domain.Student;
import com.jalian.hw12.domain.Teacher;
import com.jalian.hw12.repository.StudentRepository;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Set;
public class StudentRepositoryImpl extends BaseEntityRepositoryImpl <Student, String> implements StudentRepository {
    public StudentRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }
    @Override
    public Class<Student> getEntityClass() {
        return Student.class;
    }

    @Override
    public List<Teacher> getTeachers(Student student) {
        Query query = entityManager.createQuery("select t from Teacher t join t.students s where s.id = " + student.getId());
        return query.getResultList();
    }

    @Override
    public Set<Adress> getAdresses(Student student) {
        Query query = entityManager.createQuery("select s from Adress s where s.id = " + student.getId());
        return (Set<Adress>) query.getResultList();
    }
}