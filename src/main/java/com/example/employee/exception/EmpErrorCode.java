package com.example.employee.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EmpErrorCode {
    NO_EMPLOYEE("해당 직원 없음"),
    DUPLICATED_MEMBER_ID("중복된 멤버 ID"),
    INVALID_REQUEST("잘못된 요청 값"),
    NOT_MATCHED("연차와 레벨이 맞지않음"),
    SERVER_ERROR("서버에 오류 발생");
    public final String description;
}
