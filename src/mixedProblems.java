import java.util.HashSet;
import java.util.Scanner;

public class mixedProblems {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfGates = scanner.nextInt();
        int[][] gates = new int[numberOfGates][2];
        for (int i = 0; i < numberOfGates; i++) {
            gates[i][0] = scanner.nextInt();
            gates[i][1] = scanner.nextInt();
        }
        System.out.println(tollGate.solveTollGateProblem(gates));
        //System.out.println(time);
    }
    static long time = 1;
    static class tollGate {
        private static int min = Integer.MAX_VALUE;
        static int solveTollGateProblem(final int[][] gates) {
            solver(gates, 0, new int[3], 0);
            return min;
        }

        private static void solver(final int gates[][], int indexOfGates, int[] menForFight, int pricePaid) {
            time++;
            if (indexOfGates == gates.length) {
                if (pricePaid < min) {
                    min = pricePaid;
                }
                return;
            }

            int totalMenForFight = getTotalMen(menForFight);
            if (totalMenForFight >= gates[indexOfGates][0]) {
                int[] menForFightUpdated = returnUpdateAfterFight(menForFight, gates[indexOfGates][0]);
                solver(gates, indexOfGates + 1, menForFightUpdated, pricePaid);
            }
            solver(gates, indexOfGates + 1, menForFight, pricePaid + gates[indexOfGates][1]);
            menForFight[2] += gates[indexOfGates][0];
            solver(gates, indexOfGates + 1, menForFight, pricePaid + (2 * gates[indexOfGates][1]));
            menForFight[2] -= gates[indexOfGates][0];
        }
        private static int[] returnUpdateAfterFight(final int[] menForFight, int men) {
            int i = 0;
            int[] update = new int[3];
            while (i < menForFight.length && men != 0) {
                if (menForFight[i] <= men) {
                    update[i] = 0;
                    men -= menForFight[i];
                } else {
                    update[i] = menForFight[i] - men;
                    men = 0;
                }
                i++;
            }
            while (i < menForFight.length) {
                update[i] = menForFight[i];
                i++;
            }
            update[0] = update[1];
            update[1] = update[2];
            update[2] = 0;
            return update;
        }

        private static int getTotalMen(int[] menForFight) {
            int sum = 0;
            for (int val : menForFight) {
                sum += val;
            }
            return sum;
        }
    }


















    /* public static void main(String[] args) {
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
        }*/
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
