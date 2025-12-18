package com.example.demo.model;
import jakarta.presistance.*;
public class User{
    @id
    private long id;
    private String fullname;
    @column(unique=true)
    private String email;
    private String password;
    private String role;
    private LocalDateTime createdAt;

}