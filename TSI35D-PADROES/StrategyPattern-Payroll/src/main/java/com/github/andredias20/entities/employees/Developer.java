package com.github.andredias20.entities.employees;

import com.github.andredias20.interfaces.IEmployee;

public class Developer implements IEmployee
{
	float hourlyRate = 40;
	
	public float calculateSalary(float hours)
	{
		return hours * hourlyRate;
	}

}
