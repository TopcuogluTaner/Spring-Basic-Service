package com.example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  id;
    @Column(name="first_name", nullable = false)
    private String firstName;
    @Column(name="last_name",nullable = false)
    private String lastName;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name="birth_of_date")
    private Date dateOfBirth;
}
