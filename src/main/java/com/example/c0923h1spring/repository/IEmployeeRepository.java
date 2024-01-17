package com.example.c0923h1spring.repository;

import com.example.c0923h1spring.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
    boolean existsByEmail(String email);
}