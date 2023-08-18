package com.example.CRUD.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Student {

    @Id
    private String studentId;

    private String email;

    private String password;
    private String name;
    private String City;
    private String Phone;


}
