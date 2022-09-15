package de.ivev.mvc.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Person {
    private int id;
    @NotEmpty(message = "Blank name")
    @Size(min=2, max=30, message = "please 2-30 symbols")
    private String name;

    @Min(value = 0, message = "more than 0")
    private int age;

    @NotEmpty(message = "email please")
    @Email(message = "not valid")
    private String email;

    public Person() {    }

    public Person(int id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public int getId() {return id;    }
    public void setId(int id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public int getAge() {        return age;    }
    public void setAge(int age) {        this.age = age;    }

    public String getEmail() {        return email;    }
    public void setEmail(String email) {        this.email = email;    }

}
