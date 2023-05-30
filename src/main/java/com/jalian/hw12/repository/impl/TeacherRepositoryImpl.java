package com.jalian.hw12.repository.impl;
import com.jalian.hw12.base.repository.impl.BaseEntityRepositoryImpl;
import com.jalian.hw12.domain.Adress;
import com.jalian.hw12.domain.Student;
import com.jalian.hw12.domain.Teacher;
import com.jalian.hw12.repository.TeacherRepository;
import javax.persistence.EntityManager;
import java.util.List;
public class TeacherRepositoryImpl extends BaseEntityRepositoryImpl<Teacher, String> implements TeacherRepository {
    public TeacherRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Teacher> getEntityClass() {
        return Teacher.class;
    }

    @Override
    public List<Student> getStudents(Teacher teacher) {
        return entityManager.createQuery("select s from Student s join s.teachers a where a.id = " + teacher.getId()).getResultList();
    }

    @Override
    public Adress getAdress(Teacher teacher) {
        return (Adress) entityManager.createQuery("select a from Adress a where a.teacher.id = " + teacher.getId()).getSingleResult();
    }
}