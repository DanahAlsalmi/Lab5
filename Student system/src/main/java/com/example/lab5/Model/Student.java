package com.example.lab5.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private String name;
    private int age;
    private String degree;
    private String status;
}
