package com.github.andredias20;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.*;

@Testable
public class SecondDegreeEquasionTest {
    @Test
    void shouldInstantiateCorrectly(){

        //Gave
        float a = 1;
        float b = 2;
        float c = 3;

        //Do
        SecondDegreeEquation secondDegreeEquation = new SecondDegreeEquation(a, b, c);

        //Check

        float obtained;

        obtained = secondDegreeEquation.getA();
        assertTrue((Math.abs(a - obtained) < 0.0001));

        obtained = secondDegreeEquation.getB();
        assertTrue((Math.abs(b - obtained) < 0.0001));

        obtained = secondDegreeEquation.getC();
        assertTrue((Math.abs(c - obtained) < 0.0001));

    }

    @Test
    void shouldThrowsExceptionWithAnInvalidEquation() {
        float a,b,c;

        a = 0.0f; b = 2.0f; c = 3.0f;

        assertThrows ( InvalidSecondDegreeException.class, ()->
        {
            new SecondDegreeEquation(a,b,c);
        });
    }

    @Test
    void shouldReturnTrueAsEquationHaveRealSolution() {
        float a, b, c;

        //parabola para cima - duas raizes
        a = 2; b = 1; c = -3;

        SecondDegreeEquation secondDegreeEquation = new SecondDegreeEquation(a,b,c);
        boolean result = secondDegreeEquation.haveRealSolution();

        assertTrue(result);


        //parabola para cima - uma raiz
        a = 2; b = 4; c = 2;

        secondDegreeEquation = new SecondDegreeEquation(a,b,c);
        result = secondDegreeEquation.haveRealSolution();

        assertTrue(result);

        //parabola para baixo - uma raiz
        a = -2; b = 4; c = -2;

        secondDegreeEquation = new SecondDegreeEquation(a,b,c);
        result = secondDegreeEquation.haveRealSolution();

        assertTrue(result);


        //parabola para baixo - duas raizes
        a = -2;  b = 1; c = 3;

        secondDegreeEquation = new SecondDegreeEquation(a,b,c);
        result = secondDegreeEquation.haveRealSolution();

        assertTrue(result);
    }


    @Test
    void shouldReturnFalseAsEquationHaveNoRealSolution() {

        //Parabola pra cima: Nenhuma raiz
        float a = 2, b = 1, c = 3;

        SecondDegreeEquation secondDegreeEquation = new SecondDegreeEquation(a,b,c);
        boolean result = secondDegreeEquation.haveRealSolution();

        assertFalse(result);

        //Parabola para baixo: Nenhuma raiz

        a = -2; b = 1; c = -3;

        secondDegreeEquation = new SecondDegreeEquation(a,b,c);
        result = secondDegreeEquation.haveRealSolution();

        assertFalse(result);

    }


    @Test
    void shouldReturnZeroAsEquationHaveNoRealSolutions() {
        float a, b, c;

        //Parabola para cima - nenhuma raiz
        a = 2; b = 1; c = 3;

        SecondDegreeEquation secondDegreeEquation = new SecondDegreeEquation(a,b,c);
        int obtained = secondDegreeEquation.howManyRealSolutions();

        int expected = 0;
        assertEquals(expected, obtained);

        //Parabola para baixo - nenhuma raiz
        a = -2; b =  1; c = -3;

        secondDegreeEquation = new SecondDegreeEquation(a,b,c);
        obtained = secondDegreeEquation.howManyRealSolutions();

        assertEquals(expected, obtained);
    }


    @Test
    void shouldReturnOneAsEquationHaveOneRealSolutions() {
        //Parabola para cima - uma raiz
        float a = 2, b = 4, c = 2;
        float expected = 1;

        SecondDegreeEquation secondDegreeEquation = new SecondDegreeEquation(a,b,c);
        float obtained = secondDegreeEquation.howManyRealSolutions();


        assertEquals(expected, obtained);

        //Parabola para baixo - uma raiz
        a = -2; b = 4; c = -2;

        secondDegreeEquation = new SecondDegreeEquation(a,b,c);
        obtained = secondDegreeEquation.howManyRealSolutions();

        assertEquals(expected, obtained);
    }


    @Test
    void shouldReturnTwoAsEquationHaveTwoRealSolutions()
    {
        //parabola para baixo - duas raizes
        float a = -1,  b = 4, c = -2;
        float expected = 2;

        SecondDegreeEquation secondDegreeEquation = new SecondDegreeEquation(a,b,c);
        float obtained = secondDegreeEquation.howManyRealSolutions();

        assertEquals(expected, obtained);

        //parabola para cima - duas raizes
        a = 1;  b = 4; c = 2;
        expected = 2;

        secondDegreeEquation = new SecondDegreeEquation(a,b,c);
        obtained = secondDegreeEquation.howManyRealSolutions();

        assertEquals(expected, obtained);
    }


    @Test
    void shouldReturnEmptyArrayOfRealSolutions()
    {
        float a,b,c;
        float[] expected = new float[0];

        //parabola para cima - nenhuma raiz
        a = 2; b = 1; c = 3;

        SecondDegreeEquation eq = new SecondDegreeEquation(a,b,c);
        float[] actual = eq.getRealSolutions();

        Assertions.assertArrayEquals(expected, actual);

        //parabola para baixo - nenhuma raiz
        a = -2; b =  1; c = -3;

        eq = new SecondDegreeEquation(a,b,c);
        actual = eq.getRealSolutions();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnAnArrayWithTheUniqueRealSolution()
    {
        float[] expected = new float[1];
        expected[0] = -1;

        //parabola para cima - nenhuma raiz
        float a = 2, b = 4, c = 2;

        SecondDegreeEquation eq = new SecondDegreeEquation(a,b,c);
        float[] actual = eq.getRealSolutions();

        Assertions.assertArrayEquals(expected, actual);


        expected = new float[1];
        expected[0] = 1;
        //parabola para baixo - nenhuma raizs
        a = -2; b = 4; c = -2;

        eq = new SecondDegreeEquation(a,b,c);
        actual = eq.getRealSolutions();

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    void shouldReturnAnArrayWithTheTwoRealSolution()
    {
        //Parabola pra baixo
        float a,b,c;
        float[] expected = new float[2];
        expected[0] = -0.58578646F;
        expected[1] = -3.4142137F;

        a = 1;  b = 4; c = 2;

        SecondDegreeEquation eq = new SecondDegreeEquation(a,b,c);
        float[] actual = eq.getRealSolutions();

        Assertions.assertArrayEquals(expected, actual);

        //Parabola pra cima
        a = -1;  b = 4; c = -2;

        expected[0] = 0.58578646F;
        expected[1] = 3.4142137F;

        eq = new SecondDegreeEquation(a,b,c);
        actual = eq.getRealSolutions();

        Assertions.assertArrayEquals(expected, actual);

    }
}