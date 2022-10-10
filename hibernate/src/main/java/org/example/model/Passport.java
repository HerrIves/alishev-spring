package org.example.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Passport")
public class Passport implements Serializable {

    @Id
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Person person;

    @Column(name = "number")
    private int number;

    public Passport() {    }
    public Passport(int number) {
        this.number = number;
    }

    public Person getPerson() {return person;}
    public void setPerson(Person person) {this.person = person;}

    public int getNumber() {return number;}
    public void setNumber(int number) {this.number = number;}

    @Override
    public String toString() {
        return "Passport{" +
                "person=" + person +
                ", number=" + number +
                '}';
    }
}
