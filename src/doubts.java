import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class doubts {
    public static void main(String[] args) {
        ArrayList<String> str = Recursion.getPermutations("abc");
        Recursion.printArrayList(str);
    }










    static class Recursion{
    static void printArrayList(ArrayList<String> strings) {
        for (int i = 0; i < strings.size(); i++) {
            System.out.println(strings.get(i));
        }
    }
    static ArrayList<String> getPermutations(String str) {
        if (str.length() == 0) {
            //if length of str(string) is zero then an ArrayList is returned with one element, " ".
            ArrayList<String> empty = new ArrayList<>();
            empty.add(" ");
            return empty;
        }
        ArrayList<String> smallAns = getPermutations(str.substring(1, str.length()));//passing whole string except 1st character.
        ArrayList<String> ans = putCharInStrings(smallAns, str.charAt(0));
        return ans;
    }

    static ArrayList<String> putCharInStrings(ArrayList<String> smallAns, char ch) {
        //character ch(char) is added on all positions of the strings present in smallAns(arrayList)
        ArrayList<String> newListOfStrings = new ArrayList<>();
        for (int i = 0; i < smallAns.size(); i++) {
            String str = smallAns.get(i);
            for (int j = 0; j < str.length(); j++) {
                String strLeft = str.substring(0, j);
                String strRight = str.substring(j, str.length());
                newListOfStrings.add(strLeft + ch + strRight);
            }
        }
        return newListOfStrings;
    }





        static int fibbonacci(int n) {
            if (n == 0 || n == 1) {
                return n;
            }
            int Nminus1 = fibbonacci(n - 1);
            int Nminus2 = fibbonacci(n - 2);
            return Nminus1 + Nminus2;
        }








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
