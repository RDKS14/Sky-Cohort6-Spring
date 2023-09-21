package com.Sky.Vehiclesdemo.domain;

import javax.persistence.*;

@Entity
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int age;

    private String postCode;

   @ManyToOne
    private Vehicle owner;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vehicle getOwner() {
        return owner;
    }

    public void setOwner(Vehicle owner) {
        this.owner = owner;
    }

    public Owner() {
    super();
    }

    public Owner(String name, int age, String postCode, int id) {
        this.name = name;
        this.age = age;
        this.postCode = postCode;
        this.id = id;
    }



    }
