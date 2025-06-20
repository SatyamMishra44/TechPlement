package com.example.Employee.Payroll.System.service;

import com.example.Employee.Payroll.System.dto.salaryRequest;
import com.example.Employee.Payroll.System.entity.salary;
import com.example.Employee.Payroll.System.repository.salaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class salaryService {
    @Autowired
    private salaryRepository salaryRepository;

    public salary calculateSalary(salaryRequest request){
        double basic  = request.getBasic();

        double hra = 0.20*basic;
        double da = 0.10*basic;
        double pf = 0.12*basic;
        double tax = 0.08*basic;
        double otherAllowances = 0.05*basic;

        double grossSalary = basic+hra+da+otherAllowances;
        double netSalary = grossSalary-pf-tax;

        salary salary = new salary();
        salary.setBasic(basic);
        salary.setHra(hra);
        salary.setDa(da);
        salary.setPf(pf);
        salary.setTax(tax);
        salary.setGrossSalary(grossSalary);
        salary.setNetSalary(netSalary);
        salary.setOtherAllowance(otherAllowances);

        return salaryRepository.save(salary);
    }
}
