package de.ivev.project3.models;

import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "Person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    @NotEmpty
    @Size(min = 2, max = 100, message = "from 2 to 100, not empty")
    private String fullName;

    @Column
    @Min(value = 1900, message = "year must be higher than 1900")
    private int yearOfBirth;
}