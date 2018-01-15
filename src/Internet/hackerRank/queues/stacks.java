package Internet.hackerRank.queues;

import java.util.ArrayList;
import java.util.Stack;

public class stacks {
    public static void main(String[] args) {
        int p[] = {1, 2, 3, 4, 5 };
        int p1[] = {5, 4, 3, 2, 1};
        System.out.println(PoisonousPlants.poisonousPlants1(p1));
    }
    static class PoisonousPlants {

        static int poisonousPlants1(int[] p) {
            //time limit exceeding while uploading
            ArrayList<Integer> poisonList = new ArrayList<>();
            for (int i = 0; i < p.length; i++) {
                poisonList.add(p[i]);
            }
            ArrayList<Integer> revisedPoisonList = new ArrayList<>();
            int days = 0;
            while (true) {
                revisedPoisonList.add(poisonList.get(0));
                for (int i = 0; i < (poisonList.size() - 1); i++) {
                    if (poisonList.get(i) >= poisonList.get(i + 1)) {
                        revisedPoisonList.add(poisonList.get(i + 1));
                    }
                }
                if(poisonList.size() == revisedPoisonList.size()){
                    break;
                }
                poisonList = revisedPoisonList;
                revisedPoisonList = new ArrayList<>();
                days++;
            }
            return days;
        }
    }
}
