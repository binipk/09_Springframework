package com.ohgiraffers.practice.employee.controller;

import com.ohgiraffers.practice.employee.model.dto.EmployeeDTO;
import com.ohgiraffers.practice.employee.model.service.EmployeeService;

import java.util.List;

public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void selectAllEmployees() {
        List<EmployeeDTO> employeeList = employeeService.findAllEmployees();
        if (employeeList.isEmpty()) {
            System.out.println("직원 정보가 없습니다.");
        } else {
            for (EmployeeDTO employee : employeeList) {
                System.out.println(employee);
            }
        }
    }

    public void selectEmployeeById(int empId) {
        EmployeeDTO employee = employeeService.findEmployeeById(empId);
        if (employee == null || "Y".equalsIgnoreCase(employee.getQuitYn())) {
            System.out.println("해당 ID의 직원이 없거나 퇴사한 상태입니다.");
        } else {
            System.out.println(employee);
        }
    }

    public void registEmployee(EmployeeDTO newEmp) {
        if (employeeService.isDuplicate(newEmp)) {
            System.out.println("이미 등록된 직원입니다.");
        } else {
            employeeService.registEmployee(newEmp);
            System.out.println("직원 등록 완료");
        }
    }

    public void updateEmployee(EmployeeDTO updatedEmp) {
        boolean isUpdated = employeeService.updateEmployee(updatedEmp);
        System.out.println(isUpdated ? "직원 정보 수정 완료" : "해당 직원은 존재하지 않거나 이미 퇴사 처리되었습니다.");
    }



    public void deleteEmployee(int empId) {
        boolean isDeleted = employeeService.deleteEmployee(empId);
        System.out.println(isDeleted ? "직원 삭제 완료" : "해당 직원은 존재하지 않거나 이미 퇴사 처리되었습니다.");
    }
}