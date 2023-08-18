package com.example.CRUD.controller;

import com.example.CRUD.Security.JwtHelper;
import com.example.CRUD.dto.JwtRequest;
import com.example.CRUD.dto.JwtResponse;
import com.example.CRUD.entity.Student;
import com.example.CRUD.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private StudentService studentService;
    @Autowired
    private JwtHelper jwtHelper;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request){
        this.doAuthenticate(request.getEmail(),request.getPassword());
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        String token = jwtHelper.generateToken(userDetails);
        Student student =  mapper.map(userDetails,Student.class);
        JwtResponse response = JwtResponse.builder()
                .jwtToken(token)
                .student(student).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private void doAuthenticate(String email, String password) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email,password);
        try{
            manager.authenticate(authentication);
        }catch (BadCredentialsException e){
            throw new BadCredentialsException("Invalid");
        }
    }

}
