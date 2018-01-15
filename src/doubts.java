import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class doubts {
    public static void main(String[] args) {
        Polynomial first = new Polynomial();
        first.setCoefficient(3, 1);
        first.setCoefficient(1, 2);
        first.setCoefficient(7, 3);
        Polynomial second = new Polynomial();
        second.setCoefficient(2, 7);
        second.setCoefficient(1, 8);
        Polynomial add = first.add(second);
        Polynomial subract = first.subtaract(second);
        add.print();
        subract.print();
    }

    static class Polynomial {
        int[] coefficients = new int[10000000]; //its indices are degrees and saves coefficients on them.
        ArrayList<Integer> degrees = new ArrayList<>(); //saves degrees.

        public void setCoefficient(int degree, int coeff) {
            if (coeff == 0) {
                //return if coefficient is zero.
                return;
            }
            coefficients[degree] = coeff;
            if (!degrees.contains(degree)) {
                /*if degree is already present in degrees(ArrayList),
                then degree must not be added again to avoid duplicate elements*/
                degrees.add(degree);
                Collections.sort(degrees); // to sort the degrees(ArrayList) in non-decreasing order.
            }
        }

        public void print() {
            //prints the array list using degrees(arrayList) which contains degrees
            //and using those degrees as indices of coefficient
            for (int i = 0; i < degrees.size(); i++) {
                int degree = degrees.get(i);
                System.out.print(coefficients[degree] + "x" + degree + " ");
            }
            System.out.println();
        }

        public Polynomial subtaract(Polynomial polynomial) {
            Polynomial finalPolynomial = new Polynomial(); //polynomial object to be returned.
            for (int i = 0; i < this.degrees.size(); i++) {
                //copies all the values of current object into final polynomial.
                int degree = this.degrees.get(i);
                finalPolynomial.setCoefficient(degree, this.coefficients[degree]);
            }

            for (int i = 0; i < polynomial.degrees.size(); i++) {
                int degree = polynomial.degrees.get(i);
                if (finalPolynomial.coefficients[degree] == 0) {
                    finalPolynomial.setCoefficient(degree, (-1) * polynomial.coefficients[degree]);
                } else {
                    int intialCoeff = finalPolynomial.coefficients[degree];
                    finalPolynomial.setCoefficient(degree, intialCoeff - polynomial.coefficients[degree]);
                }
            }
            return finalPolynomial;
        }

        public Polynomial add(Polynomial polynomial) {
            Polynomial finalPolynomial = new Polynomial();
            for (int i = 0; i < this.degrees.size(); i++) {
                int degree = this.degrees.get(i);
                finalPolynomial.setCoefficient(degree, this.coefficients[degree]);
            }

            for (int i = 0; i < polynomial.degrees.size(); i++) {
                int degree = polynomial.degrees.get(i);
                if (finalPolynomial.coefficients[degree] == 0) {
                    finalPolynomial.setCoefficient(degree, polynomial.coefficients[degree]);
                } else {
                    int intialCoeff = finalPolynomial.coefficients[degree];
                    finalPolynomial.setCoefficient(degree, intialCoeff + polynomial.coefficients[degree]);
                }
            }
            return finalPolynomial;
        }

    }
}
