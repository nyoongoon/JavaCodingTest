package DP;

import java.util.Scanner;

public class AntWarrior_icote {
    //ㄴㅐ 풀이
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int n = stdIn.nextInt();
        int[] arr = new int[n];
        int[] maxVal = new int [n];

        for(int i = 0; i<arr.length; i++){
            arr[i] = stdIn.nextInt();
        }

        maxVal[0] = arr[0];
        maxVal[1] = arr[1];

        int idx = 3;
        while(idx<n){
            maxVal[idx] = Math.max(maxVal[idx-2] + arr[idx], maxVal[idx-1]);
            idx++;
        }

        System.out.println(maxVal[n-1]);


    }
}
