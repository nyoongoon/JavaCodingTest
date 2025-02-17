package _3_프로그래머스_코딩_테스트_문제_풀이_전략_자바편._1_배열;

import java.util.ArrayList;
import java.util.List;

/**
 * 재귀로 풀었는데.. 스택오버플로우 발생 (케이스 너무 많은듯)
 */
public class _2_삼각_달팽이_내풀이_재귀 {

    class Solution {
        public int[] solution(int n) {

            String strFlag = "DOWN";
            int[][] arr = new int[n][n];
            int limitCnt = getLimitCnt(n);
            // System.out.println("limitCnt == " + limitCnt);
            recur(arr, limitCnt, 0, "DOWN", 0, 0);

            List<Integer> result = new ArrayList<>();
            for(int i = 0; i < arr.length; i++){
                for(int j = 0; j < arr[i].length; j++){
                    if(arr[i][j] == 0){
                        break;
                    }
                    result.add(arr[i][j]);
                }
            }

            return result.stream().mapToInt(Integer::valueOf).toArray();
        }

        public void recur(int[][] arr, int limitCnt, int nowCnt, String strFlag, int row, int col){
            if(nowCnt == limitCnt){
                return;
            }
            // System.out.println("row == " + row);
            // System.out.println("col == " + col);
            arr[row][col] = nowCnt + 1;

            String nextStrFlag = null;
            int nextRow = -99;
            int nextCol = -99;
            if(strFlag.equals("DOWN")){
                nextStrFlag = "DOWN";
                nextRow = row + 1;
                nextCol = col;
                if(nextRow >= arr.length || arr[nextRow][nextCol] != 0){
                    nextStrFlag = "RIGHT";
                    nextRow = row;
                    nextCol = col + 1;
                }

            }else if(strFlag.equals("RIGHT")){
                nextStrFlag = "RIGHT";
                nextRow = row;
                nextCol = col + 1;
                if(nextCol >= arr[nextRow].length || arr[nextRow][nextCol] != 0){
                    nextStrFlag = "UP";
                    nextRow = row - 1;
                    nextCol = col - 1;
                }

            }else if(strFlag.equals("UP")){
                nextStrFlag = "UP";
                nextRow = row - 1;
                nextCol = col - 1;

                if(arr[nextRow][nextCol] != 0){
                    nextStrFlag = "DOWN";
                    nextRow = row + 1;
                    nextCol = col;
                }
            }else{
                System.out.println("잘못된flag : " + strFlag);
                return;
            }

            recur(arr, limitCnt, nowCnt + 1, nextStrFlag, nextRow, nextCol);
        }

        public int getLimitCnt(int n){
            int sum = 0;
            for(int i = 1; i <= n; i++){
                sum += i;
            }
            return sum;
        }
    }
}
