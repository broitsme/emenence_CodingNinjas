package numberTheory;
import java.lang.reflect.Array;
import java.util.*;

public class numberTheory {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        long k = s.nextInt();
        long[] arr = new long[size];
        for (int i = 0; i < size; i++){
            arr[i] = s.nextInt();
        }
        if(k == 1) {
            long ans = (size * (size + 1)) / 2;
            System.out.println(ans);
        }
        else {
            System.out.println(getCountXY(arr, k, 0));
        }
    }
    static long getCountXY(long[] arr,long k,int index) {
        if (index == arr.length) {
            return 0;
        }
        long subCount = getSubCount(arr,k ,index);
        return subCount + getCountXY(arr, k, index + 1);
    }
    static public long getSubCount(long[] arr,long k, int index) {
        while (index < arr.length && k != 1) {
            k /= gcd(k,arr[index++] % k);
        }
        if (k == 1) {
            return (arr.length - index + 1);
        }
        return 0;
    }

    static void createStrangeOrderArray(int n) {
        lowestPrimes = new int[n + 1];
        putLowestPrimes();
        int arr[] = new int[n + 1];
        while (n > 0) {
            if (arr[n] == 0) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                ArrayList<Integer> primesOfn = getAllThePrimesOf(n);
                for (int i = 0; i < primesOfn.size(); i++) {
                    int prime = primesOfn.get(i);
                    for (int j = n; j > 1; j -= prime) {
                        if(arr[j] == 0) {
                            arrayList.add(j);
                            arr[j] = n;
                        }
                    }
                }
                Collections.sort(arrayList);
                //Collections.reverse(arrayList);
                printArrayList(arrayList);
            }
            n--;
        }
        System.out.println(1);
    }
    static ArrayList<Integer> getAllThePrimesOf(int n) {
        if(lowestPrimes == null){
            lowestPrimes = new int[n + 1];
            putLowestPrimes();
        }
        int i = lowestPrimes[n];
        ArrayList<Integer> primes = new ArrayList<>();
        while (n != 1) {
            if (n % i == 0) {
                primes.add(i);
                while (n % i == 0) {
                    n /= i;
                }
            }
            i = lowestPrimes[n];
        }
        return primes;
    }
    static int[] lowestPrimes;
    static void putLowestPrimes(){
        for (int i = 2; i < lowestPrimes.length; i++){
            if(lowestPrimes[i] == 0){
                lowestPrimes[i] = i;
                for (int j = 2; (i * j) < lowestPrimes.length; j++){
                    if(lowestPrimes[i * j] == 0) {
                        lowestPrimes[i * j] = i;
                    }
                }
            }
        }
    }
    static void printArrayList(ArrayList<Integer> arrayList){
        for (int i = arrayList.size() - 1; i >= 0; i--){
            System.out.print(arrayList.get(i)+" ");
        }
    }

    static long getSol(long a, long b, long d) {
        long g = gcd(a, b);
        a /= g;
        b /= g;
        d /= g;
        long y1 = ((d % a) * getModInverse(b, a)) % a;
        long firstValue = d / b;
        if (d < (y1 * b)) {
            return 0;
        }
        long n = (firstValue - y1) / a;
        return n + 1;
    }
    static long getModInverse(long num, long modValue){
            long n = getGCDcoeff(num, modValue).x;
            return ((n % modValue) + modValue) % modValue;
    }
    static class gcdCoeff{
        long x, y;
        gcdCoeff(long x, long y){
            this.x = x;
            this.y = y;
        }
    }
    static gcdCoeff getGCDcoeff(long a, long b) {
        if (b == 0) {
            return new gcdCoeff(1, 0);
        }
        gcdCoeff ans = getGCDcoeff(b, a % b);
        return new gcdCoeff(ans.y, ans.x - ((a / b) * ans.y));
    }
    static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    static int[] getSeiveTill(int n) {
        int seive[] = new int[n + 1];
        for (int i = 2; i < seive.length; i++) {
            if (seive[i] == 0) {
                for (int j = 2; (i * j) < seive.length; j++) {
                    seive[i * j]++;
                }
            }
        }
        return seive;
    }


   static boolean validForXYCount(long[] arr,int l, int r,long k) {
       while (l <= r && k != 1) {
           k /= gcd(arr[l], k);
           l++;
       }
       if (k != 1) {
           return false;
       }
       return true;
   }
    static long getNumOfGoodSets(final int[] arr, int max) {
        long seiv[] = new long[max + 1];
        for (int i = 0; i < arr.length; i++) {
            seiv[arr[i]] = 1;
        }
        long count = 0;
        for (int i = 0; i < arr.length; i++) {
            int index = arr[i];
            for (int j = 2; (index * j) < seiv.length; j++) {
                if (seiv[index * j] > 0) {
                    seiv[index * j] += seiv[index];
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            count += seiv[arr[i]] % modConst;
        }
        return count;
    }

    static int nFactorFull[] = new int[1000001];
    static void putValuesInNFactorFull() {
        for (int i = 2; i < nFactorFull.length; i++) {
            if (nFactorFull[i] == 0) {
                nFactorFull[i] = 1;
                for (int j = 2; (i * j) < nFactorFull.length; j++) {
                    nFactorFull[i * j]++;
                }
            }
        }
    }

    static boolean primes[] = new boolean[1000001];
    static void putValuesPrimes() {
        for (int i = 2; i < primes.length; i++) {
            if (primes[i] == false) {
                for (int j = 2; (j * i) < primes.length; j++) {
                    primes[j * i] = true;
                }
            }
        }
    }
    static int getPowerInsideN(int n, int x) {
        int count = 0;
        while (n % x == 0){
            n /= x;
            count++;
        }
        return count;
    }

    static ArrayList<Integer> getPrimeFactorsOf(int num){
        ArrayList<Integer> primes = new ArrayList<>();
        int i = 2;
        while (num != 1 && i <= (Math.sqrt(num))) {
            if(num % i == 0) {
                while (num % i == 0) {
                    num /= i;
                }
                primes.add(i);
            }
            i++;
        }
        return primes;
    }
    static class boolInt {
        int num;
        boolean bool;

        boolInt(int num, boolean bool) {
            this.num = num;
            this.bool = bool;
        }
    }
    static long modConst = 1000000007;
    static long getNumberOfDivisors(int num) {
        ArrayList<Integer> listOfPrimes = getPrimeNumbersTill(num);
        long numOfDivisors = 1;
        for(int i  = 0 ; i < listOfPrimes.size(); i++){
            long count = getCountOfPrimes(listOfPrimes.get(i), num);
            numOfDivisors = ((numOfDivisors % modConst) * (count % modConst)) % modConst;
        }
        return numOfDivisors;
    }
    static long getCountOfPrimes(int prime, int num) {
        long count = 0;
        int tempPrime = prime;
        while (num / prime != 0) {
            count += (num / prime);
            prime *= tempPrime;
        }
        return count + 1;
    }

    static ArrayList<Integer> getPrimeNumbersTill(int num) {
        ArrayList<Integer> listOfPrimes = new ArrayList<>();
        long primeArr[] = new long[num + 1];
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (primeArr[i] == 0) {
                for (int j = 2; (i * j) <= num; j++) {
                    primeArr[i * j] = 1;
                }
            }
        }
        for (int i = 2; i <= num; i++) {
            if (primeArr[i] == 0) {
                listOfPrimes.add(i);
            }
        }
        return listOfPrimes;
    }

    static long modNum = 1000000007;

    public static long balancedTreesOfHeightH(long height) {
        if (height <= 1) {
            return 1;
        }
        long x = balancedTreesOfHeightH(height - 1);
        long y = balancedTreesOfHeightH(height - 2);
        long firstVal = (x * x) % modNum;
        long secondVal = (2 * x * y) % modNum;
        return (firstVal + secondVal) % modNum;
    }



    static long getNumberOfPrimesTill(int n){
        long primes[] = new long[n + 1];

        for (int i = 2; i < Math.sqrt(n); i++){
            if(primes[i] == 0) {
                for (int j = 2; i * j <= n; j++) {
                    primes[i * j] = 1;
                }
            }
        }
        long countPrimes = 0;
        for (int i = 2; i <= n; i++){
            if(primes[i] == 0){
                countPrimes++;
            }
        }
        return countPrimes;
    }

}
