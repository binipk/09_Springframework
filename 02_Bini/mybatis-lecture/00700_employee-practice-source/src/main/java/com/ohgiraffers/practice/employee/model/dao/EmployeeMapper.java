package com.ohgiraffers.practice.employee.model.dao;

import com.ohgiraffers.practice.employee.model.dto.EmployeeDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    List<EmployeeDTO> selectAllEmployees();
    
    EmployeeDTO selectEmployeeById(@Param("empId") int empId);
    
    int insertEmployee(EmployeeDTO employee);
    
    int updateEmployee(EmployeeDTO employee);
    
    int deleteEmployee(@Param("empId") int empId);
}
