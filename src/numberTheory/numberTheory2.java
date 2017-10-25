package numberTheory;

public class numberTheory2 {
    public static void main(String[] args) {
        System.out.println(powReccursive(2, 3));
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

    static long powReccursive(long a, long b) {
        if (b == 0) {
            return 1;
        }
        if (b % 2 == 0) {
            long ans = powReccursive(a, b / 2);
            return ans * ans;
        } else {
            long ans = powReccursive(a, b / 2);
            return ans * ans * a;
        }
    }
}
