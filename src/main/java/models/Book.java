package models;


import lombok.Builder;
import lombok.Data;

@Data
public class Book {
    private int id;
    private String name;
    private String author;
    private int year;
    private Person owner;
}
