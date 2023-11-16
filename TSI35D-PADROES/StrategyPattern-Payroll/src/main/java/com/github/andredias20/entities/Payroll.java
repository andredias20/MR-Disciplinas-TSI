package com.github.andredias20.entities;

import com.github.andredias20.interfaces.IEmployee;

public class Payroll {
    private final IEmployee employee;

    public Payroll(IEmployee iEmployee)
    {
        super();
        this.employee = iEmployee;
    }

    public float calculateSalary(float hours){
        return employee.calculateSalary(hours);
    }
}
