package Internet;

import java.util.ArrayList;

public class algorithms {
    public static void main(String[] args) {
        int[] arr = {1, -2, 3, 2, -1, 10};
        System.out.println(kodanesAlgo.getMaxSubArraySum(arr));
    }

    static class kodanesAlgo {
        static int getMaxSubArraySum(int[] arr) {
            int sumTemp = arr[0];
            int sumFinal = arr[0];
            for (int i = 1; i < arr.length; i++) {
                sumTemp = Math.max(arr[i], sumTemp + arr[i]);
                sumFinal = Math.max(sumFinal, sumTemp);
            }
            return sumFinal;
        }
    }
}
