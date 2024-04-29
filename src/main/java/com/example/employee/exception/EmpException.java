package com.example.employee.exception;

import lombok.Getter;

@Getter
public class EmpException extends RuntimeException {
    private EmpErrorCode empErrorCode;
    private String detailCode;

    public EmpException(EmpErrorCode empErrorCode) {
        super(empErrorCode.getDescription());
        this.empErrorCode = empErrorCode;
        this.detailCode = empErrorCode.getDescription();
    }
}
