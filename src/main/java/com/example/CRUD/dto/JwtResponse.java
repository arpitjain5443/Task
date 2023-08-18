package com.example.CRUD.dto;

import com.example.CRUD.entity.Student;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class JwtResponse {
    private String jwtToken;
    private Student student;
}
