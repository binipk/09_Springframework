package com.ohgiraffers.practice.employee.model.service;

import com.ohgiraffers.practice.employee.model.dao.EmployeeMapper;
import com.ohgiraffers.practice.employee.model.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeService(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    public List<EmployeeDTO> findAllEmployees() {
        return employeeMapper.selectAllEmployees();
    }

    public EmployeeDTO findEmployeeById(int empId) {
        return employeeMapper.selectEmployeeById(empId);
    }

    @Transactional
    public void registEmployee(EmployeeDTO employee) {
        employeeMapper.insertEmployee(employee);
    }

    @Transactional
    public void modifyEmployee(EmployeeDTO employee) {
        employeeMapper.updateEmployee(employee);
    }

    @Transactional
    public void deleteEmployee(int empId) {
        employeeMapper.deleteEmployee(empId);
    }
}
