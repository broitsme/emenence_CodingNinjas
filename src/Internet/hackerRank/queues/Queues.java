package Internet.hackerRank.queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Queues {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] grid = new String[n];
        for (int grid_i = 0; grid_i < n; grid_i++) {
            grid[grid_i] = in.next();
        }
        int startX = in.nextInt();
        int startY = in.nextInt();
        int goalX = in.nextInt();
        int goalY = in.nextInt();

        in.close();
    }

        }

