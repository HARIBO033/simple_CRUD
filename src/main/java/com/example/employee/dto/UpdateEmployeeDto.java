package com.example.employee.dto;

import com.example.employee.type.EmployeeLevel;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class UpdateEmployeeDto {
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request{
        @NonNull
        @Enumerated(EnumType.STRING)
        private EmployeeLevel employeeLevel;
        @NonNull
        @Size(min = 5, max = 20)
        private String memberId;
        @NonNull
        private Integer yearsOfService;

    }
}
