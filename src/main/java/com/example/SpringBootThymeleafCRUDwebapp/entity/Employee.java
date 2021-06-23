package com.example.SpringBootThymeleafCRUDwebapp.entity;

import javax.persistence.*;

@Entity
//Not necessary to use @Table annotation
// because hibernate takes the entity name as table name
// use @Table annotation if you want a different table name
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    public int getId() {
        return id;
    }
    // Not necessary to use @Column annotation because hibernate knows these are columns
    // and it will take the attributes/variables names as column names
    // use @Column(name = "column_name") in case you want a different column name.
    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
