package DP;

import java.util.Scanner;

public class EfficientMoneySystem_icote { // 내 풀이 => 틀린 듯..?
    public static void main(String[] args) {

        Scanner stdIn = new Scanner(System.in);

        int n = stdIn.nextInt();
        int m = stdIn.nextInt(); //구하는 값

        int[] idxIsMoneyValIsCnt = new int[m+1];
        for(int i = 1; i<idxIsMoneyValIsCnt.length; i++){
            idxIsMoneyValIsCnt[i] = -1;
        }

        int[] moneys = new int[n+1]; // 2,,,
        for(int i = 1; i<moneys.length; i++){
            moneys[i] = stdIn.nextInt();
        }

        //int[][] idxIsMoneyValIsCnt
        //인덱스가 계산하는 돈의 값, 밸류가 그 값이 되는 최소 동전 갯수

        // i(현재 계산 중인 돈)에서 moneys[j](현재 판단하는 동전 값) 뺄때
        // i - moneys[j] == 이전에 계산했던 돈의 값 중에서..
        // idxIsMoneyValIsCnt[i-moneys[j]] >= 0 이전의 계산했던 돈의 값에서의 최소 동전 개수 0보다 크면
        // => 값이 있다는 뜻이므로 이전 동전 갯수 + 1
        // j for문은 작은 동전부터 판단하므로 큰 값이 가능하면 무조건 대체 !!!

        for(int i = 1; i<idxIsMoneyValIsCnt.length; i++){
            for(int j = 1; j<moneys.length; j++){
                if(i-moneys[j]>= 0 && idxIsMoneyValIsCnt[i-moneys[j]] >= 0){
                    idxIsMoneyValIsCnt[i] = idxIsMoneyValIsCnt[i-moneys[j]] + 1;
                }
            }
        }
        System.out.println(idxIsMoneyValIsCnt[m]);
        // 돈 m일 때의 최소 동전 갯수
    }
}
