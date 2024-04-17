package com.javaprojects.signup_login.entity;

import jakarta.persistence.*;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email")
    private String email;

    public User(){}
    public User(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId(){return this.id;}
    public void setId(int theId){ id=theId;}

    public String getFirstName(){return this.firstName;}
    public void setFirstName(String firstName){ this.firstName=firstName;}
    public String getLastName(){return this.lastName;}
    public void setLastName(String lastName){ this.lastName=lastName;}
    public String getEmail(){return this.email;}
    public void setEmail(String email){ this.email=email;}

    public String toString(){
        return "Id: " + getId() +
                "\nFirst Name: " + getFirstName() +
                "\nLast Name: " + getLastName() +
                "\nemail: " + getEmail();
    }
}
