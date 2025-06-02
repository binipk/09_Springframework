package com.ohgiraffers.practice.employee.model.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDTO {
    private int empId;
    private String empName;
    private String empNo;
    private String email;
    private String phone;
    private String deptCode;
    private String jobCode;
    private String salLevel;
    private int salary;
    private double bonus;
    private int managerId;
    private Date hireDate;
    private Date quitDate;
    private String quitYn;
}
