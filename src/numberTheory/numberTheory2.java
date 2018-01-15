import matrix.Matrix;
import numberTheory.numberTheory;
import java.util.*;

public class numberTheory2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        primesTillSqrtUpper = segmentedSeive.getPrimesTill(100000000);
        while (t-- > 0){
            long lower = scanner.nextLong();
            long upper = scanner.nextLong();
            ArrayList<Long> primes = segmentedSeive.getAllPrimesBetween(lower, upper);
            for (int i = 0; i < primes.size(); i++){
                System.out.println(primes.get(i));
            }
        }
    }
    static ArrayList<Integer> primesTillSqrtUpper;
    static class segmentedSeive {
        static ArrayList<Long> getAllPrimesBetween(long lower, long upper) {
            //based on altered version of sieve of eranthoses.
            long segmenteSeive[] = new long[(int) (upper - lower) + 1];
            int k = 0;
            while (primesTillSqrtUpper.get(k) * primesTillSqrtUpper.get(k) <= upper) {
                int currentPrime = primesTillSqrtUpper.get(k);
                for (int j = 2; (j * currentPrime) <= upper; j++) {
                    int current = j * currentPrime;
                    if (current >= lower) {
                        segmenteSeive[(int) ((current) - lower)] = 1;
                    }
                }
                k++;
            }
            ArrayList<Long> primes = new ArrayList<>();
            for (int i = 0; i < segmenteSeive.length; i++) {
                if (segmenteSeive[i] == 0) {
                    primes.add(i + lower);
                }
            }
            return primes;
        }

        static ArrayList<Integer> getPrimesTill(int n) {
            //based on sieve of eranthoses.
            boolean seive[] = new boolean[n + 1];
            ArrayList<Integer> primes = new ArrayList<>();

            for (int i = 2; i < Math.sqrt(n); i++) {
                if (seive[i] == false) {
                    for (int j = 2; i * j <= n; j++) {
                        seive[i * j] = true;
                    }
                }
            }

            for (int i = 2; i < seive.length; i++) {
                if (seive[i] == false) {
                    primes.add(i);
                }
            }
            return primes;
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
            for (int i = 0; i < seive.length; i++){
                seive[i] = i;
            }
            for (int i = 2; i < seive.length; i++){
                if(seive[i] == i){
                    for (int j = 2; i * j < seive.length; j++){
                        double r = 1 / (double)i;
                        seive[i * j] = seive[i * j] * (1 - r);
                    }
                }
            }
            if((int)seive[seive.length - 1] != n) {
                return (int) seive[seive.length - 1];
            }
            return n - 1;
        }
    }
    static class NthIncome{
        static long solve(long zDay, long fDay, long nDay){
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
