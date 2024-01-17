package com.example.c0923h1spring.service;

import com.example.c0923h1spring.model.Employee;
import com.example.c0923h1spring.repository.IEmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final IEmployeeRepository employeeRepository;


    public void create(Employee employee) {

        if(employeeRepository.existsByEmail(employee.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        employeeRepository.save(employee);
    }
    public Iterable<Employee> findAll(){
        return employeeRepository.findAll();
    }

    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }
}