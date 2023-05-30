package com.jalian.hw12.repository;
import com.jalian.hw12.base.repository.BaseEntityRepository;
import com.jalian.hw12.domain.Adress;
import com.jalian.hw12.domain.Teacher;
import java.util.List;
public interface TeacherRepository extends BaseEntityRepository<Teacher, String> {
    List getStudents(Teacher teacher);
    Adress getAdress(Teacher teacher);
}