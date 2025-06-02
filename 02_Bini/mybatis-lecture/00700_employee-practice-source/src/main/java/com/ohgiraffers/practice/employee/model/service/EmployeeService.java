package com.ohgiraffers.practice.employee.model.service;

import com.ohgiraffers.practice.employee.model.dto.EmployeeDTO;
import com.ohgiraffers.practice.employee.model.dao.EmployeeMapper;
import com.ohgiraffers.practice.common.Template;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class EmployeeService {

    private final EmployeeMapper employeeMapper;

    public EmployeeService() {
        SqlSession sqlSession = Template.getSqlSession();
        this.employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
    }

    public EmployeeService(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    public List<EmployeeDTO> findAllEmployees() {
        return employeeMapper.selectAllEmployees();
    }

    public EmployeeDTO findEmployeeById(int empId) {
        return employeeMapper.selectEmployeeById(empId);
    }

    public void registEmployee(EmployeeDTO employee) {
        employeeMapper.insertEmployee(employee);
    }

    public boolean updateEmployee(EmployeeDTO employee) {
        EmployeeDTO existing = employeeMapper.selectEmployeeById(employee.getEmpId());

        if (existing == null || "Y".equalsIgnoreCase(existing.getQuitYn())) {
            return false;
        }

        int result = employeeMapper.updateEmployee(employee);
        return result > 0;
    }





    public boolean deleteEmployee(int empId) {
        EmployeeDTO found = employeeMapper.selectEmployeeById(empId);
        if (found == null || "Y".equalsIgnoreCase(found.getQuitYn())) {
            return false;
        }
        return employeeMapper.deleteEmployee(empId) > 0;
    }


    public boolean isDuplicate(EmployeeDTO employee) {
        List<EmployeeDTO> existingEmployees = employeeMapper.selectAllEmployees();

        for (EmployeeDTO existing : existingEmployees) {
            if (existing.getEmpId() == employee.getEmpId()
                    || (existing.getEmpNo() != null && existing.getEmpNo().equals(employee.getEmpNo()))
                    || (existing.getEmail() != null && existing.getEmail().equals(employee.getEmail()))
                    || (existing.getPhone() != null && existing.getPhone().equals(employee.getPhone()))) {
                return true;
            }
        }
        return false;
    }
}
