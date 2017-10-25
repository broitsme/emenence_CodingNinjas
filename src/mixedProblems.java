import java.util.HashSet;
import java.util.Scanner;

public class mixedProblems {
        public static void main(String[] args) {
            Scanner s = new Scanner(System.in);
            int test = s.nextInt();
            while (test-- > 0) {
                int a0 = s.nextInt();
                int a1 = s.nextInt();
                int c = s.nextInt();
                int n = s.nextInt();
                int arr[] = new int[4];
                if (n < 2) {
                    System.out.println("NO");
                    continue;
                }
                if(n > 4) {
                    arr = new int[n];
                }
                arr[0] = a0;
                arr[1] = a1;
                for (int i = 2; i < n; i++) {
                    arr[i] = ((arr[i - 1] * c) + arr[i - 2]) % 10;
                }
                for (int i = 0; i < arr.length; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
                int num;
                for (int i = arr.length - 1; i >= 4; i--) {
                    num = 4 * arr[i];
                    int temp = (arr[i - 4] * 1000) + (arr[i - 3] * 100) + (arr[i - 2] * 10) + arr[i - 1];
                    temp -= num;
                    arr[i - 1] = temp % 10;
                    arr[i - 2] = (temp % 100) / 10;
                    arr[i - 3] = (temp % 1000) / 100;
                    arr[i - 4] = temp / 1000;
                    arr[i] = 0;
                    for (int j = 0; j < arr.length; j++) {
                        System.out.print(arr[j] + " ");
                    }
                    System.out.println();
                }
                int temp = (arr[0] * 1000) + (arr[1] * 100) + (arr[2] * 10) + arr[3];
                if (temp % 41 == 0) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    static void wordBreak(String str, int index, HashSet<String> strings, String ansTillNow) {
        if (index == str.length()) {
            System.out.println(ansTillNow);
            return;
        }
        for (int i = index; i <= str.length(); i++) {
            String tempString = str.substring(index, i);
            if (strings.contains(tempString)) {
                wordBreak(str, i, strings, ansTillNow + tempString+" ");
            }
        }
    }
}
