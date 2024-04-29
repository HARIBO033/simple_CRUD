package com.example.employee.repository;

import com.example.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmpRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByMemberId(String memberId);

    Optional<Employee> deleteByMemberId(String memberId);
}