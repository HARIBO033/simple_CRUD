package com.example.employee.entity;

import com.example.employee.type.EmployeeLevel;
import com.example.employee.type.StatusEmployeeCode;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private EmployeeLevel employeeLevel;
    private String memberId;
    private String name;
    private int yearsOfService;
    private Integer age;

    private StatusEmployeeCode statusEmployeeCode;
    @CreatedDate
    private LocalDateTime createAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;
}
