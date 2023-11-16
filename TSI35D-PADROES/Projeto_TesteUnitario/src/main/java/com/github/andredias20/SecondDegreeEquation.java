package com.github.andredias20;

public class SecondDegreeEquation {

    private float a;
    private float b;
    private float c;

    public SecondDegreeEquation(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;

        if (Math.abs(a) < 0.000_000_000_1)
            throw new InvalidSecondDegreeException("Invalid value (a= " + a + ")");
    }

    public float getA() {
        return a;
    }

    public float getB() {
        return b;
    }

    public float getC() {
        return c;
    }

    public boolean haveRealSolution() {
        float delta = delta();
        return delta >= 0;
    }

    public int howManyRealSolutions() {
        float delta = delta();

        if (delta < 0)
            return 0;

        if (delta > 0)
            return 2;

        return 1;
    }

    private float delta() {
        return (b * b - 4 * a * c);
    }

    public float[] getRealSolutions() {
        float delta = this.delta();

        if (delta < 0) {
            return new float[0];
        } else if (delta > 0) {
            float root1 = (-b + (float) Math.sqrt(delta)) / (2 * a);
            float root2 = (-b - (float) Math.sqrt(delta)) / (2 * a);
\f            return new float[]{root1, root2};
        }
        float root = -b / (2 * a);
        return new float[]{root};
    }
}
