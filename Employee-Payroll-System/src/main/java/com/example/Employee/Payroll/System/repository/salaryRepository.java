package com.example.Employee.Payroll.System.repository;

import com.example.Employee.Payroll.System.entity.salary;
import org.springframework.data.jpa.repository.JpaRepository;
import  org.springframework.stereotype.Repository;

public interface salaryRepository extends JpaRepository<salary,Long>{

}
