package com.example.c0923h1spring.controller;

import com.example.c0923h1spring.model.Employee;
import com.example.c0923h1spring.model.enumration.EGender;
import com.example.c0923h1spring.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public ModelAndView index() {
        var employees = employeeService.findAll();
        return new ModelAndView("employee/index", "employees", employees);
    }

    @GetMapping("create")
    public ModelAndView create() {
        return new ModelAndView("employee/create", "employee", new Employee());
    }

    @PostMapping("create")
    public ModelAndView create(@ModelAttribute Employee employee) {
        try{
            employeeService.create(employee);
        }catch (Exception e){
            var view = new ModelAndView("employee/create", "employee", employee);
            view.addObject("error", e.getMessage());
            return view;
        }

        return new ModelAndView("redirect:/employees");
    }

    @GetMapping("delete/{id}")
    public ModelAndView delete(@PathVariable Long id) {
        employeeService.delete(id);
        return new ModelAndView("redirect:/employees");

    }
}