package com.example.employee.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public enum StatusEmployeeCode {
    ACTIVE("일중"),
    RETIRED("퇴사");

    public final String description;
}
