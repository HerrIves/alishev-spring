package ru.alishev.springcourse.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table
public class Item {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "empty")
    @Column(name = "item_name")
    private String itemName;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person owner;

    public Item() {    }


    public int getId() {        return id;    }
    public void setId(int id) {        this.id = id;    }

    public String getItemName() {        return itemName;    }
    public void setItemName(String itemName) {        this.itemName = itemName;    }

    public Person getOwner() {        return owner;    }
    public void setOwner(Person owner) {        this.owner = owner;    }
}
