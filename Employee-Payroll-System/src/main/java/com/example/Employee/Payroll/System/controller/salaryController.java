package com.example.Employee.Payroll.System.controller;

import com.example.Employee.Payroll.System.dto.salaryRequest;
import com.example.Employee.Payroll.System.entity.salary;
import com.example.Employee.Payroll.System.service.salaryService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salaries")
public class salaryController {
    @Autowired
    private salaryService salaryService;

    @PostMapping("/calculate")
    public ResponseEntity<salary> calculateSalary(@RequestBody salaryRequest request){
        salary calculateSalary = salaryService.calculateSalary(request);
        return ResponseEntity.ok(calculateSalary);
    }

}
