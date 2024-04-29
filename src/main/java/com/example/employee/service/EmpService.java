package com.example.employee.service;

import com.example.employee.dto.CreateEmpDto;
import com.example.employee.dto.EmployeeDto;
import com.example.employee.dto.UpdateEmployeeDto;
import com.example.employee.entity.Employee;
import com.example.employee.entity.RetiredEmployee;
import com.example.employee.exception.EmpException;
import com.example.employee.repository.EmpRepository;
import com.example.employee.repository.RetiredEmpRepository;
import com.example.employee.type.StatusEmployeeCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.employee.exception.EmpErrorCode.DUPLICATED_MEMBER_ID;
import static com.example.employee.exception.EmpErrorCode.NO_EMPLOYEE;

@Service
@RequiredArgsConstructor
public class EmpService {
    private final EmpRepository empRepository;
    private final RetiredEmpRepository retiredEmpRepository;

    // 요청 밸리데이션 검증
    public void validationCreateEmployeeRequest(CreateEmpDto.Request request) {
//        Employee employee = empRepository.findByMemberId(request.getMemberId())
//                .orElseThrow(() -> new EmpException(NO_EMPLOYEE));
//
//        if (Objects.equals(employee.getMemberId(), request.getMemberId())){
//            throw new EmpException(DUPLICATED_MEMBER_ID);
//        }

        empRepository.findByMemberId(request.getMemberId())
                .ifPresent(employee -> {
                    throw new EmpException(DUPLICATED_MEMBER_ID);
                });

    }

    //등록
    @Transactional
    public void createEmployee(CreateEmpDto.Request request) {
        validationCreateEmployeeRequest(request);
        Employee employee = Employee.builder()
                .employeeLevel(request.getEmployeeLevel())
                .memberId(request.getMemberId())
                .name(request.getName())
                .yearsOfService(request.getYearsOfService())
                .age(request.getAge())
                .statusEmployeeCode(StatusEmployeeCode.ACTIVE)
                .build();

        empRepository.save(employee);
    }

    //전체조회
    public List<EmployeeDto> getAllEmployees() {
        return empRepository.findAll().stream()
                .map(employee -> EmployeeDto.fromEntity(employee)).collect(Collectors.toList());
    }

    //수정
    @Transactional
    public EmployeeDto updateEmployee(String memberId, UpdateEmployeeDto.Request request) {
        Employee employee = empRepository.findByMemberId(memberId).orElseThrow(() -> new EmpException(NO_EMPLOYEE));
        employee.setEmployeeLevel(request.getEmployeeLevel());
        employee.setMemberId(request.getMemberId());
        employee.setYearsOfService(request.getYearsOfService());

        return EmployeeDto.fromEntity(employee);
    }

    // 퇴사사원관리
    @Transactional
    public EmployeeDto deleteEmployee(String memberId) {
        Employee employee = empRepository.findByMemberId(memberId).orElseThrow(() -> new EmpException(NO_EMPLOYEE));
        employee.setStatusEmployeeCode(StatusEmployeeCode.RETIRED);

        RetiredEmployee retiredEmployee = RetiredEmployee.builder()
                .memberId(employee.getMemberId())
                .name(employee.getName())
                .build();
        retiredEmpRepository.save(retiredEmployee);
        return EmployeeDto.fromEntity(employee);
    }
}
