package DP;

import java.util.Scanner;

public class IntegerTriangle_icote {
    public static void main(String[] args) {

        Scanner stdIn = new Scanner(System.in);

        int n = stdIn.nextInt();
        int[][] arr = new int[n+1][n+1];

        int[][] copy = new int[n+1][n+1];

        for(int i = 1; i<arr.length; i++){
            for(int j = 0; j<i; j++){
                int temp = stdIn.nextInt();
                arr[i][j] = temp;
                copy[i][j] = temp;
            }
        }

        // 밑으로 내려가면서 최댓값 dp

        for(int i = 1; i<arr.length; i++){
            for(int j = 0; j<i; j++){
                int nowInt = arr[i][j];
                // 범위 제한
                if(i+1 < n+1 && j+1 < i+1){
                    int leftDownInt = copy[i+1][j] + nowInt;
                    int rightDownInt = copy[i+1][j+1] + nowInt;
                    arr[i+1][j] = Math.max(arr[i+1][j],
                            leftDownInt);
                    arr[i+1][j+1] = Math.max(arr[i+1][j+1],
                            rightDownInt);
                }

            }
        }



        int max = Integer.MIN_VALUE;
        for(int i = 1; i<arr.length; i++){
            for(int j = 0; j<i; j++){
                max = Math.max(max, arr[i][j]);
            }
        }

        System.out.println(max);

    }
}
