import java.util.*;

public class Backtracking {
    // types of backtracking
    // 1. Decision
    // 2. Optimization
    // 3. Enumeration

    // BackTrack on Array
    public static void changeArr(int arr[], int i, int val){
        // Base case
        if(i == arr.length){
            printArr(arr);
            return;
        }

        // recursion
        arr[i] = val;
        changeArr(arr, i+1, val+1);  // call function
        arr[i] = arr[i] - 2;                // backtracking step
    }

    public static void  printArr(int arr[]){
        for(int i=0; i<= arr.length-1; i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }
    // Que. Find Subsets
    // subsets "abc" => a, b, c, ab, ac, bc, abc, null => 2^3 = 8

    public static void findSubsets(String str, String ans, int i) {
        // base case
        if(i == str.length()){
            System.out.println(ans);
            return;

    }
        //kam
        // yes choice
        findSubsets(str, ans+str.charAt(i), i+1);
        // no choice
        findSubsets(str, ans, i+1);
    }

    public static void main(String[] args) {
       String str = "abc";
       findSubsets(str, "", 0);

//        int arr[] = new int[5];
//        changeArr(arr, 0, 1);
//        printArr(arr);

    }
}
