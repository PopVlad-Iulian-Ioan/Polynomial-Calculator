package org.Calculator;

public class Monomial {
    private int grade;
    private Number coefficient;

    Monomial(int grade , int coefficient) {
        this.grade = grade;
        this.coefficient = coefficient;
    }

    Monomial(int grade , double coefficient) {
        this.grade = grade;
        this.coefficient = coefficient;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Number getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public String toString() {
        if (coefficient.doubleValue () != 0)
            if (grade != 0)
                if (this.getCoefficient ().intValue () > 0) {
                    return " +" + this.getCoefficient () + "x^" + this.getGrade ();
                } else {
                    return " " + this.getCoefficient () + "x^" + this.getGrade ();
                }
            else if (this.getCoefficient ().intValue () > 0) {
                return " +" + this.getCoefficient ();
            } else {
                return " " + this.getCoefficient ();

            }
            return "";
    }
}
