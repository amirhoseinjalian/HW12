package com.jalian.hw12.ui;

import com.jalian.hw12.domain.Adress;
import com.jalian.hw12.domain.Student;
import com.jalian.hw12.repository.impl.StudentRepositoryImpl;
import com.jalian.hw12.service.impl.StudentServiceImpl;
import com.jalian.hw12.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.sql.Date;
import java.util.HashSet;

public class MainApp {
    public static void main(String[] args) {
        EntityManager entityManager = HibernateUtil.getEntityManger();
        Student student = new Student();
        student.setBirthday(new Date(2003, 5, 12));
        student.setCode(12345678);
        student.setFirstName("amirhosein");
        student.setLastName("jalian");
        student.setId("aj");
        student.setAdresses(new HashSet<Adress>());
        Adress adress = new Adress(1222, "tehran", "5645", "6555");
        student.getAdresses().add(adress);
        adress.setStudent(student);
        adress = new Adress(1333, "esfahan", "5645", "6555");
        student.getAdresses().add(adress);
        adress.setStudent(student);
        adress = new Adress(1444, "rasht", "5645", "6555");
        student.getAdresses().add(adress);
        adress.setStudent(student);
        StudentServiceImpl studentService = new StudentServiceImpl(new StudentRepositoryImpl(entityManager));
        studentService.save(student);
        HibernateUtil.close();
    }
}
