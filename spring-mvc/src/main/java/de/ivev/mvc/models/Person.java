package de.ivev.mvc.models;

import javax.validation.constraints.*;

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

    @Pattern(regexp = "[A-Z]\\w+, [A-Z]\\w+, \\d{6}", message = "Country, City, ZIP(6)")
    @NotEmpty(message = "email please")
    private String address;

    public Person() {    }

    public Person(int id, String name, int age, String email, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.address = address;
    }

    public int getId() {return id;    }
    public void setId(int id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public int getAge() {        return age;    }
    public void setAge(int age) {        this.age = age;    }

    public String getEmail() {        return email;    }
    public void setEmail(String email) {        this.email = email;    }

    public String getAddress() {        return address;    }
    public void setAddress(String address) {        this.address = address;    }
}
