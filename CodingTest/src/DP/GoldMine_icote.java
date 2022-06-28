package DP;

import java.util.Scanner;

public class GoldMine_icote {// 내풀이 -> 맞춤
    public static void main(String[] args) {

        Scanner stdIn = new Scanner(System.in);

        int n = stdIn.nextInt();
        int m = stdIn.nextInt(); //구하는 값

        int[][] goldMine = new int[n][m];
        int[][] scoreBoard = new int[n][m];

        for(int i = 0 ; i<goldMine.length; i++){
            for(int j = 0; j<goldMine[i].length; j++){
                goldMine[i][j] = stdIn.nextInt();
            }
        }

        for(int i = 0 ; i<goldMine.length; i++){
            for(int j = 0; j<goldMine[i].length; j++){
                scoreBoard[i][j] = goldMine[i][j];	// 기존 값 비교용
            }
        }

        for(int i = 0; i<goldMine[0].length; i++){
            for(int j = 0; j<goldMine.length; j++){
                //goldMine[j][i]
                int curScore = scoreBoard[j][i];

                for(int k = -1; k<2; k++){
                    if(j+k>=0&&j+k<goldMine.length && i+1<goldMine[0].length){ //인덱스 범위 체크

                        // ** dp 로직
                        scoreBoard[j+k][i+1] = Math.max(scoreBoard[j+k][i+1], goldMine[j+k][i+1] + curScore);

                    }

                }
            }
        }

        // System.out.println();
        // for(int i = 0 ; i<scoreBoard.length; i++){
        // 	for(int j = 0; j<scoreBoard[i].length; j++){
        // 		System.out.print(scoreBoard[i][j] + " ");
        // 	}
        // 	System.out.println();
        // }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i<scoreBoard.length; i++){
            max = Math.max(max, scoreBoard[i][m-1]);
        }
        System.out.println(max);


    }
}
