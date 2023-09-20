package com.Sky.Vehiclesdemo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehicle {

    private String name;
    private int age;
    private String brand;
    private int wheels;

    private int doors;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Vehicle(String name, int age, String brand, int wheels, int doors, int id) {
        super();
        this.name = name;
        this.age = age;
        this.brand = brand;
        this.wheels = wheels;
        this.doors = doors;
        this.id = id;

    }

    public Vehicle(){
        super();
    }

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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }
    public int getID() {
        return id;
    }
    public void setID(int id) {
        this.id = id;
    }
}
