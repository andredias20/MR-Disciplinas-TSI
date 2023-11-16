package com.github.andredias20.entities.employees;

import com.github.andredias20.interfaces.IEmployee;

public class TeamLeader implements IEmployee
{
	float hourlyRate = 35;

	@Override
	public float calculateSalary(float hours) {
		return hours * hourlyRate;
	}
}
