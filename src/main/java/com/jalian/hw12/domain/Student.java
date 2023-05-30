package com.jalian.hw12.domain;

import jdk.nashorn.internal.objects.annotations.Getter;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "student")
/*@AttributeOverrides (
        {
                @AttributeOverride(name = "code", column = @Column(name = "studentCode")),
                @AttributeOverride(name = "id", column = @Column(name = "username"))
        })*/
@PrimaryKeyJoinColumn(name = "username", referencedColumnName = "id")
public class Student extends Person {

    private Set<Adress> adresses = new HashSet<>();
    private List<Teacher> teachers;
    public Student(String s) {
        super(s);
    }
    public Student() {
    }
    public Student(String s, String firstName, String lastName, long code, Date birthday) {
        super(s, firstName, lastName, code, birthday);
    }

    public Student(String firstName, String lastName, long code, Date birthday) {
        super(firstName, lastName, code, birthday);
    }

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Adress.class)
    public Set<Adress> getAdresses() {
        return adresses;
    }

    public void setAdresses(Set<Adress> adresses) {
        this.adresses = adresses;
    }

    @ManyToMany(targetEntity = Teacher.class, mappedBy = "students", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
}
