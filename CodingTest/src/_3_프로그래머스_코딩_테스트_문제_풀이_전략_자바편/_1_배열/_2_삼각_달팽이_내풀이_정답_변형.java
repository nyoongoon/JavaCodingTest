package _3_프로그래머스_코딩_테스트_문제_풀이_전략_자바편._1_배열;

import java.util.ArrayList;
import java.util.List;

/**
 * while문 종료 조건 정리 -> getLimit으로
 */
public class _2_삼각_달팽이_내풀이_정답_변형 {

    class Solution {
        public int[] solution(int n) {
            int[][] triangle = new int[n][n];
            int v = 1;
            int x = 0;
            int y = 0;

            triangle[y][x] = v++;
            int limit = getLimit(n);

            while(v <= limit){
                //아래로
                while(y + 1 < n && triangle[y + 1][x] == 0){
                    y += 1;
                    triangle[y][x] = v++;
                }
                //오른쪽
                while(x + 1 < n && triangle[y][x + 1] == 0){
                    x += 1;
                    triangle[y][x] = v++;
                }
                //위
                while(x - 1 >= 0 && y - 1 >= 0 && triangle[y - 1][x - 1] == 0){
                    x -= 1;
                    y -= 1;
                    triangle[y][x] = v++;
                }
            }

            int[] result = new int[v - 1];
            int idx = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j <= i; j++){
                    result[idx++] = triangle[i][j];
                }
            }

            return result;
        }

        public int getLimit(int n){
            int sum = 0;
            for(int i = 0; i<=n; i++){
                sum += i;
            }
            return sum;
        }
    }
}
