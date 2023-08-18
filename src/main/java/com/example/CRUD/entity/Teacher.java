package com.example.CRUD.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Teacher {
    @Id
    private String teacherId;

    private String email;
    private String password;

    private String name;
    private String city;
    private String phone;



}
