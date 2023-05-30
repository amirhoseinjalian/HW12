package com.jalian.hw12.domain;
import com.jalian.hw12.base.domain.BaseEntity;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@Table(name = "adress")
public class Adress extends BaseEntity<Long> {

    private long number;
    private String city;
    private String postalAdress;
    private String postalCode;
    private Teacher teacher;
    private Student student;

    public Adress(Long aLong, long number, String city, String postalAdress, String postalCode) {
        super(aLong);
        this.number = number;
        this.city = city;
        this.postalAdress = postalAdress;
        this.postalCode = postalCode;
    }

    public Adress(long number, String city, String postalAdress, String postalCode) {
        this.number = number;
        this.city = city;
        this.postalAdress = postalAdress;
        this.postalCode = postalCode;
    }

    public Adress(Long aLong) {
        super(aLong);
    }

    public Adress() {
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalAdress() {
        return postalAdress;
    }

    public void setPostalAdress(String postalAdress) {
        this.postalAdress = postalAdress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "teacherUsername", nullable = true)
    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "studentUsername", nullable = false)
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "id= " + getId() + '\'' +
                "number=" + number + '\'' +
                ", city='" + city + '\'' +
                ", postalAdress='" + postalAdress + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
}
