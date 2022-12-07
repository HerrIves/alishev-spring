package models;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class Person {
    private int id;

    @NotEmpty
    @Size(min = 2, max = 100, message = "from 2 to 100, not empty")
    private String fullName;

    @Min(value = 1900, message = "year must be higher than 1900")
    private int yearOfBirth;
}