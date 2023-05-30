package com.jalian.hw12.service;
import com.jalian.hw12.base.service.BaseEntityService;
import com.jalian.hw12.domain.Adress;
import com.jalian.hw12.domain.Teacher;
import java.util.List;
public interface TeacherService extends BaseEntityService <Teacher, String> {
    List getStudents(Teacher teacher);
    Adress getAdress(Teacher teacher);
}