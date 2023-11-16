package com.github.andredias20;

import com.github.andredias20.entities.Payroll;
import com.github.andredias20.entities.employees.Developer;
import com.github.andredias20.entities.employees.Recruiter;
import com.github.andredias20.entities.employees.TeamLeader;
import com.github.andredias20.interfaces.IEmployee;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Testable
public class IEmployeeTest {

    @Test
    public void shouldReturnCorrectDeveloperSalary(){

        float hourlySalary = 40;
        float numberOfHours = 2;

        IEmployee employee = new Developer();
        float obtained = employee.calculateSalary(numberOfHours);

        float expected = numberOfHours * hourlySalary;

        assertEquals(expected, obtained);
    }

    @Test
    void shouldReturnCorrectTeamLeaderSalary(){

        float hourlySalary = 35;
        float numberOfHours = 2;

        IEmployee employee = new TeamLeader();
        float obtained = employee.calculateSalary(numberOfHours);

        float expected = numberOfHours * hourlySalary;

        assertEquals(expected, obtained);
    }

    @Test
    void shouldReturnCorrectRecruiterSalary(){

        float hourlySalary = 20;
        float numberOfHours = 101;
        float hireBonus = 500;

        IEmployee employee = new Recruiter();
        float obtained = employee.calculateSalary(numberOfHours);

        float expected = (numberOfHours * hourlySalary) + hireBonus;

        assertEquals(expected, obtained);
    }

    @Test
    void shouldCalculateCorrectSalaryOfAnyEmployee(){

        float numberOfHours = 2;
        float numberOfHoursWithBonus = 101;

        IEmployee employees[] = {new Developer(), new Recruiter(), new Recruiter(), new TeamLeader()};
        float obtained[] = new float[4];
        
        float expectedDeveloper = 80;
        float expectedRecruiter = 40;
        float expectedRecruiterWithBonus = 40;
        float expectedTeamLeader = 70;


        float expected[] = {expectedDeveloper, expectedRecruiter, expectedRecruiterWithBonus, expectedTeamLeader};

        for (int i = 0; i < employees.length ; i++) {
            var employee = new Payroll(employees[i]);
            obtained[i] = employee.calculateSalary(numberOfHours);
            assertEquals(expected[i], obtained[i]);
        }

    }


}
