package com.example.employee.dto;

import com.example.employee.entity.Employee;
import com.example.employee.type.EmployeeLevel;
import com.example.employee.type.StatusEmployeeCode;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDto {
    private EmployeeLevel employeeLevel;
    private String memberId;
    private String name;
    private Integer yearsOfService;
    private StatusEmployeeCode statusEmployeeCode;

    public static EmployeeDto of(Employee employee){
        return EmployeeDto.builder()
                .employeeLevel(employee.getEmployeeLevel())
                .name(employee.getName())
                .build();
    }
    public static EmployeeDto fromEntity(Employee employee){
        return EmployeeDto.builder()
                .employeeLevel(employee.getEmployeeLevel())
                .memberId(employee.getMemberId())
                .name(employee.getName())
                .yearsOfService(employee.getYearsOfService())
                .statusEmployeeCode(employee.getStatusEmployeeCode())
                .build();
    }

}
