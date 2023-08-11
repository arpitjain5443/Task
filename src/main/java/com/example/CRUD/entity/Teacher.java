package com.example.CRUD.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Teacher {
    @Id
    private String teacherId;

    private String name;
    private String city;
    private String phone;


    public Teacher(String teacherId, String name, String city, String phone) {
        this.teacherId = teacherId;
        this.name = name;
        this.city = city;
        this.phone = phone;
    }

    public Teacher() {

    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
