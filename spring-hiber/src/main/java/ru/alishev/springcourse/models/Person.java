package ru.alishev.springcourse.models;

import org.hibernate.annotations.GeneratorType;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table
public class Person {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String name;

    @Column
    @Min(value = 0, message = "Age should be greater than 0")
    private int age;

    @Column
    @NotEmpty(message = "empty")
    @Email
    private String email;


    public Person() {    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {        return email;    }
    public void setEmail(String email) {        this.email = email;    }
}
