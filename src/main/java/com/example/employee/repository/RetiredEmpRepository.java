package com.example.employee.repository;

import com.example.employee.entity.RetiredEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetiredEmpRepository extends JpaRepository<RetiredEmployee,Long> {
}
