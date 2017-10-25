package BackTracking;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class learning {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int test = s.nextInt();
        while (test-- > 0) {
            int nBoxes = s.nextInt();
            long nStudents = s.nextInt();
            long nCandies[] = new long[nBoxes];
            long sum = 0;
            for (int i = 0; i < nCandies.length; i++) {
                nCandies[i] = s.nextInt();
                sum += nCandies[i];
            }
            Arrays.sort(nCandies);
            System.out.println(solution(nCandies, 0, nCandies[nCandies.length - 1], nStudents));
        }
    }

    static long solution(long[] arr, long l, long r, long nStudents) {
        if(nStudents == 1){
            return arr[arr.length - 1];
        }
        if (l > r) {
            return r;
        }
        long mid = (l + r) / 2;
        long count = getCount(arr, mid);
        if (count >= nStudents) {
            return solution(arr, mid + 1, r, nStudents);
        }
        return solution(arr, l, mid - 1, nStudents);
    }


    static long getCount(long[] arr, long num) {
        long count = 0;
        for (int i = 0; i < arr.length; i++) {
            count += (arr[i] / num);
        }
        return count;
    }


    static int getReqSum(int[] arr, int index,int sum) {
        if (index == arr.length) {
            return sum;
        }
        int sumForNow = 0;
        for (int i = 0; i < index; i++) {
            if (arr[i] < arr[index]) {
                sumForNow += arr[i];
            }
        }
        return getReqSum(arr, index + 1, sum + sumForNow);
    }




    public static boolean sudokuSolver(int board[][]){

        return sudokuSolverHelp2(board,0) && sudokuSolverHelp2(board);
    }
    static boolean sudokuSolverHelp2(int[][] board) {
        HashSet<Integer> boxSet;

        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board.length; j += 3) {
                boxSet = new HashSet<>();
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        System.out.print(board[k][l]+" ");
                        if(board[k][l] != 0) {
                            if (!boxSet.contains(board[k][l])) {
                                boxSet.add(board[k][l]);
                            } else {
                                return false;
                            }
                        }
                    }
                    System.out.println();
                }
            }
        }

        return true;
    }
     static boolean sudokuSolverHelp2(int board[][],int i) {
         if (i == board.length) {
             return true;
         }
         for (int j = 0; j < board.length; j++) {
             if (!isAccepted(board, i, j)) {
                 return false;
             }
         }
         return sudokuSolverHelp2(board, i + 1);
     }

     static boolean isAccepted(int[][] board,int x,int y) {
        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> col = new HashSet<>();
        for (int i = 0; i < board.length; i++) {

            if (board[i][x] != 0) {
                if (!row.contains(board[i][x])) {
                    row.add(board[i][x]);
                } else {
                    return false;
                }
            }

            if (board[y][i] != 0) {
                if (!col.contains(board[y][i])) {
                    col.add(board[y][i]);
                } else {
                    return false;
                }
            }

        }
        return true;
    }

    static long solve(int[] A,int n){

        return solveHelp(A,0,n);
    }
    static long solveHelp(int[] A,int l,int r) {
        if(l == r){
            return 0;
        }
        int mid = (l + r) / 2;
        return solveHelp(A,l,mid) + solveHelp(A,mid+1,r) +  merge(A,l,mid,r);
    }



    static long merge(int[] A, int l, int mid, int r) {
        int arr1[] = Arrays.copyOfRange(A, l, mid+1);
        int arr2[] = Arrays.copyOfRange(A, mid+1, r + 1);

        int i = 0, j = 0, k = l;
         long count = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                A[k++] = arr1[i++];
            } else {
                count += arr1.length - i;
                A[k++] = arr2[j++];
            }
        }
        while (i < arr1.length) {
            A[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            A[k++] = arr2[j++];
        }
        return count;
    }


    static int pow(int n, int p){
        if(p == 0){
            return 1;
        }
        if(p % 2 == 0){
            int ans = pow(n,p/2);
            return ans*ans;
        }
        int ans = pow(n,p/2);
        return ans*ans*n;
    }
static int getLargestMinDistance(int[] arr,int c, int minDistance,int maxDistance) {
    int mid = (minDistance + maxDistance) / 2;
    if (minDistance >= maxDistance) {
        return mid;
    }
    if (possible(arr, c, mid)) {
        return getLargestMinDistance(arr, c, mid + 1, maxDistance);
    }
    return getLargestMinDistance(arr, c, minDistance, mid - 1);
}
    static boolean possible(int[] arr,int c,int minDistance) {
        int i = 0, j = 1;
        c--;
        while (i < arr.length && j < arr.length) {
            if ((arr[j] - arr[i]) >= minDistance) {
                i = j;
                j++;
                c--;
                if (c == 0) {
                    return true;
                }
            } else {
                j++;
            }
        }
        return false;
    }

    public static void ratInAMazeHelp(int maze[][], int x,int y, int[][] arr) {
        if (x == maze.length || y == maze.length || x < 0 || y < 0 || arr[x][y] == 1) {
            return;
        }
        if(x == arr.length - 1 && y == arr.length - 1){
            arr[x][y] = 1;
            for (int[] array: arr){
                for (int val: array){
                    System.out.print(val+" ");
                }
            }
            System.out.println();
        }


        if (maze[x][y] == 1) {
            arr[x][y] = 1;
            ratInAMazeHelp(maze, x - 1 , y, arr);
            ratInAMazeHelp(maze, x + 1, y, arr);
            ratInAMazeHelp(maze, x , y - 1, arr);
            ratInAMazeHelp(maze, x, y + 1, arr);
            arr[x][y] = 0;
        }

    }

    static int[] insretElement(int[] arr,int element){
        int arrFinal[] = new int[arr.length + 1];
        for(int i = 0; i < arr.length; i++){
            arrFinal[i] = arr[i];
        }
        arrFinal[arr.length] = element;
        return arrFinal;
    }
    public static void placeNQueens(int arr[][],int index) {
        if (index == arr.length) {
            print2DArray(arr);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (checkHVD(arr, index, i)) {
                arr[index][i] = 1;
                placeNQueens(arr, index + 1);
                arr[index][i] = 0;
            }
        }
    }

    static boolean checkHVD(int[][] arr,int index, int jindex) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[index][i] == 1) {
                return false;
            }
            if (arr[i][jindex] == 1) {
                return false;
            }
        }

        int i = index, j = jindex;
        while (i >= 0 && j >= 0) {
            if (arr[i--][j--] == 1) {
                return false;
            }
        }
        i = index;
        j = jindex;
        while (i < arr.length && j < arr.length) {
            if (arr[i++][j++] == 1) {
                return false;
            }
        }
        i = index;
        j = jindex;
        while (i >= 0 && j < arr.length) {
            if (arr[i--][j++] == 1) {
                return false;
            }
        }
        i = index;
        j = jindex;
        while (i < arr.length && j >= 0) {
            if (arr[i++][j--] == 1) {
                return false;
            }
        }
        return true;
    }

    static void print2DArray(int[][] arrOfArr){
        for (int[] array: arrOfArr){
            for (int val: array){
                System.out.print(val+" ");
            }
            System.out.println();
        }
    }
}
