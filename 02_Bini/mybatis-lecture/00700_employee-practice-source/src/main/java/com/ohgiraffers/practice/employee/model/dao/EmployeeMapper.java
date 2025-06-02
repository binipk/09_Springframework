package com.ohgiraffers.practice.employee.model.dao;

import com.ohgiraffers.practice.employee.model.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeMapper {
    List<EmployeeDTO> selectAllEmployees();
    EmployeeDTO selectEmployeeById(int empId);
    void insertEmployee(EmployeeDTO employee);
    int updateEmployee(EmployeeDTO employee);
    int deleteEmployee(int empId);

}
