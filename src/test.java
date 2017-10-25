import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {

    }
    //Do again
    static HashSet<String> strings = new HashSet<>();
    public static void countPalindromeSubstringsHelp(String s,int index) {
       if(s.length() == index) {
           return;
       }
       putAllPalindromes(s,index);
       countPalindromeSubstringsHelp(s,index + 1);
    }
    static void putAllPalindromes(String s, int index) {
        if (index == s.length() - 1 || index == 0) {
            strings.add(s.substring(index, index + 1));
            return;
        }
        int i = index, j = index;
        if (s.length() % 2 == 0) {
            strings.add(s.substring(i,j + 1));
            j = index + 1;
        }
        while (i > 0 && j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                strings.add(s.substring(i, j + 1));
            }
            else {
                break;
            }
            i--;
            j++;
        }
    }
    public static boolean subsetSumToKIdentical(int arr[], int n,int k){
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == arr[i]) {
                arrayList.set(arrayList.size() - 1, arrayList.get(arrayList.size() - 1) + arr[i]);
            }
            else {
                arrayList.add(arr[i]);
            }
        }
        return isGroupSumPossible(arrayList,0,k);
    }
    static boolean isGroupSumPossible(ArrayList<Integer> arr,int index, int sum) {
        if (sum == 0) {
            return true;
        }
        if (index == arr.size()) {
            return false;
        }
        return isGroupSumPossible(arr, index + 1, sum - arr.get(index)) || isGroupSumPossible(arr, index + 1, sum);
    }

    public static void printIncreasingNumberHelp(int n,int index,int num) {
        if (n == 0) {
            System.out.print(num+" ");
            return;
        }
        for (int i = (index + 1); i <= 9; i++) {
            printIncreasingNumberHelp(n - 1, i,((num * 10) + i));
        }
    }
    static long getMaxVol(long[] arr){
        long max = Long.MIN_VALUE, secondMax = Long.MIN_VALUE;
        for (int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                secondMax = max;
                max = arr[i];
            }
            else if(arr[i] > secondMax){
                secondMax = arr[i];
            }
        }
        System.out.println(max+" "+secondMax);
        long vol = 0;
        for (int i = 0; i < arr.length; i++){
           if(arr[i] != max && arr[i] != secondMax){
               vol += (secondMax - arr[i]);
           }
        }
        return vol;
    }
}
