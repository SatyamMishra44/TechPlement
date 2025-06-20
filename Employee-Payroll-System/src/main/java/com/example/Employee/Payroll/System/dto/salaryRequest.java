package com.example.Employee.Payroll.System.dto;

public class salaryRequest {
    private double basic;
    private Long employeeId;

    private double bonus;

    // constructor
    public salaryRequest(){

    }

    public salaryRequest(double basic,Long employeeId,double bonus){
        this.basic = basic;
        this.employeeId = employeeId;
        this.bonus = bonus;
    }

    // getter and setter


    public double getBasic() {
        return basic;
    }

    public void setBasic(double basic) {
        this.basic = basic;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
