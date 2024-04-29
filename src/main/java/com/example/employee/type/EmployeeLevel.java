package com.example.employee.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EmployeeLevel {
    BOSS("사장"),
    GENERAL_MANAGER("부장"),
    SENIOR_MANAGER("대리"),
    MANAGER("직원");

    private final String description;
}
