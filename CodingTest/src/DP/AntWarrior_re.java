package DP;

import java.util.HashMap;
import java.util.Scanner;

public class AntWarrior_re {
    static int[] arr;
    static int sum = Integer.MIN_VALUE;
    static HashMap<Integer, Integer> memo = new HashMap<>();
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);

        int n = stdIn.nextInt();
        arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = stdIn.nextInt();
        }
        recursive(n-1, 0);
        System.out.println(sum);
    }

    public static int recursive(int n, int tmp){
        if(memo.containsKey(n)){
            return memo.get(n);
        }else{
            if(n < 0 ) {
                return Integer.MIN_VALUE;
            }else if(n == 0 || n == 1){
                int tmpSum = arr[n] + tmp;
                sum = Math.max(sum, tmpSum);
                return sum;
            }else{
                int hashVal = Math.max(recursive(n-2, tmp + arr[n]),
                        recursive(n-3, tmp + arr[n]));
                memo.put(n, hashVal);
                return hashVal;
            }
        }
    }
}
