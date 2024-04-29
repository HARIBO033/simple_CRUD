package com.example.employee.controller;

import com.example.employee.service.EmpService;
import com.example.employee.dto.CreateEmpDto;
import com.example.employee.dto.EmployeeDto;
import com.example.employee.dto.UpdateEmployeeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmpController {

    private final EmpService empService;

    @PostMapping("/createEmployee")
    public List<String> creatEmployee(@Valid @RequestBody CreateEmpDto.Request request) {
        empService.createEmployee(request);
        return List.of("success"); // response 컨벤션은 회의후 결정
    }

    @GetMapping("/getAllEmployees")
    public List<EmployeeDto> getAllEmployees() {
        return empService.getAllEmployees();
    }

    @PutMapping("/updateEmployee/{memberId}")
    public EmployeeDto updateEmployee(@PathVariable String memberId, @Valid @RequestBody UpdateEmployeeDto.Request request) {
        return empService.updateEmployee(memberId, request);
    }

    @DeleteMapping("deleteEmployee/{memberId}")
    public EmployeeDto deleteEmployee(@PathVariable String memberId) {
        return empService.deleteEmployee(memberId);
    }
}
