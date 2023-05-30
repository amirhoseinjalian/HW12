package com.jalian.hw12.domain;
import com.jalian.hw12.base.domain.BaseEntity;
import org.hibernate.annotations.DynamicInsert;
import javax.persistence.*;
import java.sql.Date;
@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person extends BaseEntity<String> {
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column
    private long code;
    @Column(name = "birthday")
    private Date birthday;

    public Person(String id) {
        super(id);
    }

    public Person() {
    }

    public Person(String id, String firstName, String lastName, long code, Date birthday) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.code = code;
        this.birthday = birthday;
    }

    public Person(String firstName, String lastName, long code, Date birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.code = code;
        this.birthday = birthday;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    @Override
    public String toString() {
        return "Person{" +
                "id" + getId() + '\'' +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", code=" + code +
                ", birthday=" + birthday +
                '}';
    }

    @Id
    public String getId() {
        return super.getId();
    }
}

