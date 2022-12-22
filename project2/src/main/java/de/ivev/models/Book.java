package de.ivev.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Entity
@Table
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    @NotEmpty
    @Size(min = 2, max = 100, message = "title between 2 and 100")
    private String title;

    @Column
    @NotEmpty
    @Size(min = 2, max = 100, message = "author between 2 and 100")
    private String author;

    @Column
    @Min(value = 1500, message = "year min 1500")
    private int year;
}
