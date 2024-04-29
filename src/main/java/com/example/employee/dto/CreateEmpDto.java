package com.example.employee.dto;


import com.example.employee.type.EmployeeLevel;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;


public class CreateEmpDto {
    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request {
        @NonNull
        @Enumerated(EnumType.STRING)
        private EmployeeLevel employeeLevel;
        @NonNull
        @Size(min = 5, max = 20)
        private String memberId;
        @NonNull
        @Size(min = 2, max = 20)
        private String name;
        @NonNull
        private Integer yearsOfService;
        @NonNull
        @Min(18)
        private Integer age;
    }

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Response{

        private EmployeeLevel employeeLevel;
        private String memberId;
        private String name;
        private Integer yearsOfService;
    }
}
