package ResurssionAssignment;
import java.util.ArrayList;
import java.util.HashMap;

public class recurssionAdvanced {
    public static void main(String[] args) {
        printAllPossibleCodesHelp("1123","");

    }
    static ArrayList<String> arrOfStr = new ArrayList<>();
    public static void printAllPossibleCodesHelp(String input,String resultTillNow) {
        if(input.length() == 0){
            arrOfStr.add(resultTillNow);
            return;
        }
        for (int i = 1; i <= input.length(); i++) {
            char code = getCode(input.substring(0, i));
            if(code < 123 && code > 96) {
                printAllPossibleCodesHelp(input.substring(i), resultTillNow + code);
            }
        }
    }
    static char getCode(String str){
        int num = 0;
        for (int i = 0; i < str.length(); i++){
            num = (num*10) +str.charAt(i) - 48;
        }
        return (char) (num + 96);
    }




    public static void placeNQueens(int arr[][],int index){
    if(index == arr.length){
        print2DArray(arr);
        return;
    }
    }
    static void print2DArray(int[][] arrOfArr){
        for (int[] array: arrOfArr){
            for (int val: array){
                System.out.print(val+" ");
            }
            System.out.println();
        }
    }










    public static int sum(int input[],int index) {
		if(input.length == index){
		    return 0;
        }
        return input[index] + sum(input,index+1);
    }
    public static int power(int x, int n) {
		if(n == 0){
		    return 1;
        }
        int ans;
        if(n % 2 == 0){
		    ans = power(x,n/2);
		    return ans*ans;
        }
        else {
            ans = power(x,n/2);
            return ans*ans*x;
        }
    }
    public static String[] permutationOfString(String input){
        if(input.length() == 1){
            String[] arrOfStr = {input};
            return arrOfStr;
        }
        String[] smallAns = permutationOfString(input.substring(1));
        String[] ans = getCombinations(smallAns,input.charAt(0));
        return ans;
    }
    static String[] getCombinations(String[] arrOfStr,char ch) {
        String arrOfStrFinal[] = new String[arrOfStr.length * (arrOfStr[0].length()+1)];
        int k = 0;
        for (int i = 0; i < arrOfStr.length; i++) {
            String str = arrOfStr[i];
            for (int index = 0; index <= str.length(); index++) {
                arrOfStrFinal[k++] = str.substring(0, index) + ch + str.substring(index);
            }
        }
        return arrOfStrFinal;
    }





    static int arrOfArr[][] = new int[0][0];
    public static void subsetsSumK(int input[],int index, int k, int [] arr) {
        if (k == 0) {
           arrOfArr = InsetArray(arrOfArr, arr);
           return;
        }
        if (index == input.length || k < 0) {
            return;
        }
        int[] newArr = InsetElement(arr, input[index]);
        subsetsSumK(input, index + 1, k - input[index], newArr);
        subsetsSumK(input, index + 1, k, arr);
    }
    static int[] InsetElement(int[] arr,int element){
        int arrFinal[] = new int[arr.length + 1];
        for(int i = 0; i < arr.length; i++){
            arrFinal[i] = arr[i];
        }
        arrFinal[arr.length] = element;
        return arrFinal;
    }
    static int[][] InsetArray(int[][] arrOfArr, int[] arr){
        int[][] arrOfArrFinal =new int[arrOfArr.length + 1][];
        for(int i = 0; i < arrOfArr.length; i++){
            arrOfArrFinal[i] = arrOfArr[i];
        }
        arrOfArrFinal[arrOfArr.length] = arr;
        return arrOfArrFinal;
    }

    static int[][] AddNewSubSets(int num,int arr[][]){
        int size = (arr.length*2)+1;
        int newArrOfArr[][] = new int[size][];

        for (int i = 0; i < arr.length; i++){
                newArrOfArr[i] = arr[i];
        }

        newArrOfArr[arr.length] = new int[1];
        newArrOfArr[arr.length][0] = num;

        for (int i = 0; i < arr.length; i++){
            newArrOfArr[i+ arr.length + 1] = new int[arr[i].length+1];
            for (int j = 0; j < arr[i].length; j++){
                newArrOfArr[i+ arr.length + 1][j + 1] = arr[i][j];
            }
        }
        for (int i = 0; i < arr.length; i++){
            newArrOfArr[i+ arr.length + 1][0] = num;
        }
        return newArrOfArr;
    }
    public static int[][] subsets(int input[],int index) {
        // Write your code here
        if(index == input.length){
           int output[][] = new int[0][0];
            return output;
        }
        int[][] smallAns = subsets(input, index+1);
        int[][] ans = AddNewSubSets(input[index],smallAns);
        return ans;
    }

}
