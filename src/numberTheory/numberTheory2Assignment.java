package numberTheory;

import java.util.Scanner;

public class numberTheory2Assignment {
    public static void main(String[] args) {
        System.out.println(CubicSquare.pow(23,150,10));
    }

    static class CubicSquare {
        static void solve() {
            Scanner scanner = new Scanner(System.in);
            int test = scanner.nextInt();
            long a, m;
            String digitsOfB;
            long ans;
            while (test-- > 0) {
                a = scanner.nextInt();
                digitsOfB = scanner.next();
                m = scanner.nextInt();
                long b = DecimalFromBase3(digitsOfB);
                ans = pow(a, b, m);
                System.out.println(ans);
            }
        }

        static long pow(long num, long power, long mod) {
            if (num == 0) {
                return 0;
            }
            if (power == 0) {
                return 1;
            }
            long ans = pow(num, power / 2, mod);
            if (power % 2 == 0) {
                return ((ans % mod) * (ans % mod)) % mod;
            } else {
                return ((ans % mod) * (ans % mod) * (num % mod)) % mod;
            }
        }

        static long DecimalFromBase3(String s) {
            int[] digitArr = new int[s.length()];
            for (int i = 0; i < digitArr.length; i++) {
                digitArr[i] = Integer.parseInt(s.split("")[i]);
            }
            long number = 0;
            for (int i = 0; i < digitArr.length; i++) {
                number += digitArr[i] * Math.pow(3, digitArr.length - i - 1);
            }
            return number;
        }
    }
}
