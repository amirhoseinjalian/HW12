package com.jalian.hw12.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "teacher")
/*@AttributeOverrides (
        {
                @AttributeOverride(name = "code", column = @Column(name = "teacherCode")),
                @AttributeOverride(name = "id", column = @Column(name = "username"))
        })*/
@PrimaryKeyJoinColumn(name = "username", referencedColumnName = "id")
public class Teacher extends Person {

    private double salary;
    private Adress adress;


    List<Student> students;

    public Teacher(String s, double salary) {
        super(s);
        this.salary = salary;
    }

    public Teacher(double salary) {
        this.salary = salary;
    }

    public Teacher(String s, String firstName, String lastName, long code, Date birthday, double salary) {
        super(s, firstName, lastName, code, birthday);
        this.salary = salary;
    }

    public Teacher(String firstName, String lastName, long code, Date birthday, double salary) {
        super(firstName, lastName, code, birthday);
        this.salary = salary;
    }

    public Teacher() {
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @OneToOne(mappedBy = "teacher", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return super.toString() + "salary= " + salary;
    }

    @ManyToMany(targetEntity = Student.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "studentTeacher",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
