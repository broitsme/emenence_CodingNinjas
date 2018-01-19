package numberTheory;

import com.sun.deploy.util.SyncAccess;
import matrix.Matrix;
import numberTheory.numberTheory;
import java.util.*;

public class numberTheory2 {

    public static void main(String[] args) {
        SegmentedSeive.solve();
    }
    static class SegmentedSeive {
        static ArrayList<Long> getAllPrimesBetween(long lower, long upper) {
            //based on seive of eranthoses.
            int length = (int) (upper - lower) + 1;
            boolean segmentedSeive[] = new boolean[length];
            int i = 0;
            while ((primes.get(i) * primes.get(i)) <= upper) {
                long prime = primes.get(i);
                long base = (lower / prime) * prime;
                if(base < lower || base == prime){
                    base += prime;
                }
                if(lower < prime){
                    base+= prime;
                }
                for (int j = (int) base; (j - (int) lower) < segmentedSeive.length; j += prime) {
                    segmentedSeive[j - (int) lower] = true;
                }
                i++;
            }
            ArrayList<Long> requiredPrimes = new ArrayList<>();
            for (int j = 0; j < segmentedSeive.length; j++) {
                if (segmentedSeive[j] == false) {
                    requiredPrimes.add(j + lower);
                }
            }
            return requiredPrimes;
        }

        static ArrayList<Long> primes; //primes till sqrt(2147483647) are stored in it.

        static void generatePrimes() {
            //based on seive Of eranthoses.
            //as the max value in problem is 2147483647, and sqrt(2147483647) is approximately 46341.
            primes = new ArrayList<>();
            boolean[] seive = new boolean[46341];
            for (int i = 2; (i * i) < seive.length; i++) {
                if (seive[i] == false) {
                    for (int j = 2; (i * j) < seive.length; j++) {
                        seive[i * j] = true;
                    }
                }
            }
            for (int i = 2; i < seive.length; i++) {
                if (seive[i] == false) {
                    primes.add((long) i);
                }
            }
        }

        static void solve() {
            //test are number of test cases.
            SegmentedSeive.generatePrimes();
            Scanner scanner = new Scanner(System.in);
            int test = scanner.nextInt();
            while (test-- > 0) {
                long lower = scanner.nextLong();
                long upper = scanner.nextLong();
                ArrayList<Long> primes = getAllPrimesBetween(lower, upper);
                for (int i = 0; i < primes.size(); i++) {
                    System.out.println(primes.get(i));
                }
            }
            scanner.close();
        }
    }

    static class EulersToitent {
        static int getNumOfCoPrimes(int n) {
            //based on euler's totient function.
            return (int) (n * getETCoefficient(n));
        }

        static int getETCoefficient(int n) {
            //returns coefficient with of n in euler's totient function.
            //based on the concept of sieve of eranthoses.
            double seive[] = new double[n + 1];
            for (int i = 0; i < seive.length; i++) {
                seive[i] = i;
            }
            for (int i = 2; i < seive.length; i++) {
                if (seive[i] == i) {
                    for (int j = 2; i * j < seive.length; j++) {
                        double r = 1 / (double) i;
                        seive[i * j] = seive[i * j] * (1 - r);
                    }
                }
            }
            if ((int) seive[seive.length - 1] != n) {
                return (int) seive[seive.length - 1];
            }
            return n - 1;
        }
    }

    static class NthIncome {
        static long solve(long zDay, long fDay, long nDay) {
            long a = MatrixExpo.getNthFibb(nDay - 2);
            long b = MatrixExpo.getNthFibb(nDay - 1);
            return (long) ((Math.pow(zDay + 1, a) * Math.pow(fDay + 1, b)) - 1);
        }
    }
    static class ModularExpo {
        static long factorialWRTprimeMod(long n, long p) {
            //returns n % p
            //based on wilson's theorem.
            if(n >= p){
                return 0;
            }
            long r = 1;
            for (long i = n + 1; i <= p - 1; i++) {
                r = ((r % p) * (getPrimeModInverse(i, p) % p)) % p;
            }
            r = (r * (p - 1))% p;
            return r;
        }

        static long getPrimeModInverse(long a, long p) {
            //returns modulo inverse of a wrt p (p must be a prime).
            //based on fermat's little theorem.
            return powReccursiveMod(a, p - 2, p);
        }
        static long powReccursiveMod(long a, long b, long mod) {
            if (b == 0) {
                return 1;
            }
            long ans = powReccursiveMod(a, b / 2, mod);
            if (b % 2 == 0) {
                return (ans * ans) % mod;
            } else {
                return ((ans * ans) % mod * a) % mod;
            }
        }
    }

    static class MatrixExpo {
        static long getNthFibb(long k) {
            //returns kth fibonacci number.
            //returns 1 for 0th fibonacci.
            long matrix[][] = {{1, 1}, {1, 0}};
            long reqMatrix[][] = Matrix.pow_matrix(matrix, k);
            return reqMatrix[0][0];
        }

        static long getFibbSum(int n, int m) {
            //returns sum of fibonacci numbers from n to m.
            return getNthFibb(m + 1) - getNthFibb(n);
        }
    }
    static class lcmSum {
        public static void func(long n) {
            long sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += lcm(i, n);
            }
            System.out.println(sum);
        }
    }

    static long lcm(long x, long y){
        return (x * y) / gcd(x, y);
    }

    static long gcd(long x, long y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }
    static int[] EulereulerPhiSeive;
    static void makeEulereulerPhiSeive(int n) {
        EulereulerPhiSeive = new int[n + 1];
        for (int i = 0; i < EulereulerPhiSeive.length; i++) {
            EulereulerPhiSeive[i] = i;
        }
        for (int i = 2; i < EulereulerPhiSeive.length; i++) {
            if (EulereulerPhiSeive[i] == i) {
                EulereulerPhiSeive[i]--;
                for (int j = 2; (i * j) < EulereulerPhiSeive.length; j++) {
                    EulereulerPhiSeive[i * j] = (EulereulerPhiSeive[i * j] * (i - 1)) / i;
                }
            }
        }
    }
    static long mod = 1000000007;
    static class incomeOnNth{
        //Do it properly

        static long powReccursive(long a, long b) {
            if (b == 0) {
                return 1;
            }
            long ans = powReccursive(a, b / 2) % mod;
            if (b % 2 == 0) {
                return ((ans % mod)* (ans % mod)) % mod;
            } else {
                return ((ans % mod)* (ans % mod) * (a % mod)) % mod;
            }
        }
    }

    static long powItrative(long a, long b) {
        int ans = 1;
        while (b != 0) {
            if ((b & 1) == 1) {
                ans *= a;
            }
            a *= a;
            b /= 2;
        }
        return ans;
    }
    static long powReccursiveMod(long a, long b, long mod) {
        if (b == 0) {
            return 1;
        }
        long ans = powReccursiveMod(a, b / 2, mod);
        if (b % 2 == 0) {
            return (ans * ans) % mod;
        } else {
            return ((ans * ans) % mod * a) % mod;
        }
    }

    static long powReccursive(long a, long b) {
        if (b == 0) {
            return 1;
        }
        long ans = powReccursive(a, b / 2);
        if (b % 2 == 0) {
            return ans * ans;
        } else {
            return ans * ans * a;
        }
    }
}
