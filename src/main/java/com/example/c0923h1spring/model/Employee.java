package com.example.c0923h1spring.model;

import com.example.c0923h1spring.model.enumration.EGender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity(name = "employees")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true, columnDefinition = "LONGTEXT")
    private String email;

    private LocalDate dob;

    @Enumerated(EnumType.STRING)
    private EGender gender;

    @ManyToOne(fetch = FetchType.LAZY)
    private Department department;

}