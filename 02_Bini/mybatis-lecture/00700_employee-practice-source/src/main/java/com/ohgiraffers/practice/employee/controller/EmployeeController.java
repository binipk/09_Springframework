package com.ohgiraffers.practice.employee.controller;

import com.ohgiraffers.practice.employee.model.dto.EmployeeDTO;
import com.ohgiraffers.practice.employee.model.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String findAllEmployees(Model model) {
        List<EmployeeDTO> employeeList = employeeService.findAllEmployees();
        model.addAttribute("employeeList", employeeList);
        return "employee/list";
    }

    @GetMapping("/detail/{empId}")
    public String findEmployeeById(@PathVariable int empId, Model model) {
        EmployeeDTO employee = employeeService.findEmployeeById(empId);
        model.addAttribute("employee", employee);
        return "employee/detail";
    }

    @GetMapping("/regist")
    public String registPage() {
        return "employee/regist";
    }

    @PostMapping("/regist")
    public String registEmployee(@ModelAttribute EmployeeDTO employee) {
        employeeService.registEmployee(employee);
        return "redirect:/employee/list";
    }

    @GetMapping("/modify/{empId}")
    public String modifyPage(@PathVariable int empId, Model model) {
        EmployeeDTO employee = employeeService.findEmployeeById(empId);
        model.addAttribute("employee", employee);
        return "employee/modify";
    }

    @PostMapping("/modify")
    public String modifyEmployee(@ModelAttribute EmployeeDTO employee) {
        employeeService.modifyEmployee(employee);
        return "redirect:/employee/list";
    }

    @PostMapping("/delete/{empId}")
    public String deleteEmployee(@PathVariable int empId) {
        employeeService.deleteEmployee(empId);
        return "redirect:/employee/list";
    }
}