package DP;

import java.util.Scanner;

public class EfficentMoneySystem_icote_ans { // 책 풀이
    public static void main(String[] args) {

        Scanner stdIn = new Scanner(System.in);

        int n = stdIn.nextInt();
        int m = stdIn.nextInt(); //구하는 값

        int[] minCtnArr = new int[m+1];

        for(int i = 1; i<minCtnArr.length; i++){
            minCtnArr[i] = 9999;
        }

        int[] moneys = new int[n];
        for(int i = 0; i<moneys.length; i++){
            moneys[i] = stdIn.nextInt();
        }

        for(int i = 0; i<moneys.length; i++){ // 화폐 단위를 먼저 돌면서
            for(int j = 0; j<minCtnArr.length; j++){
                if(j-moneys[i] >= 0 && minCtnArr[j-moneys[i]] != 9999){
                    //최소값을 판단한다.
                    minCtnArr[j] = Math.min(minCtnArr[j], minCtnArr[j-moneys[i]]+1);
                }
            }
        }

        System.out.println(minCtnArr[m]);


    }
}
