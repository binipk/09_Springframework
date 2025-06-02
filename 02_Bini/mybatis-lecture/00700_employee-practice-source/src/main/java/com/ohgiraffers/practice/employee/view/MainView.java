package com.ohgiraffers.practice.employee.view;

import com.ohgiraffers.practice.employee.controller.EmployeeController;
import com.ohgiraffers.practice.employee.model.dao.EmployeeMapper;
import com.ohgiraffers.practice.employee.model.dto.EmployeeDTO;
import com.ohgiraffers.practice.employee.model.service.EmployeeService;
import com.ohgiraffers.practice.common.Template;
import org.apache.ibatis.session.SqlSession;

import java.util.Scanner;

public class MainView {
    public static void main(String[] args) {

        SqlSession sqlSession = Template.getSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        EmployeeService employeeService = new EmployeeService(employeeMapper);
        EmployeeController employeeController = new EmployeeController(employeeService);

        Scanner sc = new Scanner(System.in);
        int input;

        do {
            System.out.println("\n===== 직원 관리 =====");
            System.out.println("1. 직원 전체 조회");
            System.out.println("2. 직원 ID로 조회");
            System.out.println("3. 직원 등록");
            System.out.println("4. 직원 수정");
            System.out.println("5. 직원 삭제");
            System.out.println("0. 프로그램 종료");
            System.out.print("번호 입력: ");

            input = Integer.parseInt(sc.nextLine());

            switch (input) {
                case 1:
                    employeeController.selectAllEmployees();
                    break;
                case 2:
                    System.out.print("조회할 직원 ID: ");
                    int searchId = Integer.parseInt(sc.nextLine());
                    employeeController.selectEmployeeById(searchId);
                    break;
                case 3:
                    EmployeeDTO newEmp = new EmployeeDTO();
                    System.out.print("이름: "); newEmp.setEmpName(sc.nextLine());
                    System.out.print("주민번호: "); newEmp.setEmpNo(sc.nextLine());
                    System.out.print("이메일: "); newEmp.setEmail(sc.nextLine());
                    System.out.print("전화번호: "); newEmp.setPhone(sc.nextLine());
                    System.out.print("부서코드: "); newEmp.setDeptCode(sc.nextLine());
                    System.out.print("직급코드: "); newEmp.setJobCode(sc.nextLine());
                    System.out.print("급여등급: "); newEmp.setSalLevel(sc.nextLine());
                    System.out.print("급여: "); newEmp.setSalary(Integer.parseInt(sc.nextLine()));
                    System.out.print("보너스율: "); newEmp.setBonus(Double.parseDouble(sc.nextLine()));
                    System.out.print("관리자 사번: "); newEmp.setManagerId(Integer.parseInt(sc.nextLine()));

                    employeeController.registEmployee(newEmp);
                    break;
                case 4:
                    System.out.print("수정할 직원 ID: ");
                    int updateId = Integer.parseInt(sc.nextLine());

                    // ✅ 먼저 유효성 검사
                    EmployeeDTO foundEmp = employeeService.findEmployeeById(updateId);
                    if (foundEmp == null || "Y".equalsIgnoreCase(foundEmp.getQuitYn())) {
                        System.out.println("해당 직원은 존재하지 않거나 이미 퇴사 처리되었습니다.");
                        break;
                    }

                    EmployeeDTO updatedEmp = new EmployeeDTO();
                    updatedEmp.setEmpId(updateId);

                    System.out.print("이름: "); updatedEmp.setEmpName(sc.nextLine());
                    System.out.print("주민번호: "); updatedEmp.setEmpNo(sc.nextLine());
                    System.out.print("이메일: "); updatedEmp.setEmail(sc.nextLine());
                    System.out.print("전화번호: "); updatedEmp.setPhone(sc.nextLine());
                    System.out.print("부서코드: "); updatedEmp.setDeptCode(sc.nextLine());
                    System.out.print("직급코드: "); updatedEmp.setJobCode(sc.nextLine());
                    System.out.print("급여등급: "); updatedEmp.setSalLevel(sc.nextLine());
                    System.out.print("급여: "); updatedEmp.setSalary(Integer.parseInt(sc.nextLine()));
                    System.out.print("보너스율: "); updatedEmp.setBonus(Double.parseDouble(sc.nextLine()));
                    System.out.print("관리자 사번: "); updatedEmp.setManagerId(Integer.parseInt(sc.nextLine()));

                    employeeController.updateEmployee(updatedEmp);
                    break;
                case 5:
                    System.out.print("삭제할 직원 ID: ");
                    int deleteId = Integer.parseInt(sc.nextLine());
                    employeeController.deleteEmployee(deleteId);
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
            }

        } while (input != 0);
    }
}
