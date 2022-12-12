package de.ivev.models;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class Book {
    private int id;

    @NotEmpty
    @Size(min = 2, max = 100, message = "title between 2 and 100")
    private String title;

    @NotEmpty
    @Size(min = 2, max = 100, message = "author between 2 and 100")
    private String author;

    @Min(value = 1500, message = "year min 1500")
    private int year;
}
