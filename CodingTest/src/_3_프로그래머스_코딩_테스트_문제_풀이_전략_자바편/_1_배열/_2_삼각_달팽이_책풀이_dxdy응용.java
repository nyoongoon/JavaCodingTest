package _3_프로그래머스_코딩_테스트_문제_풀이_전략_자바편._1_배열;

/**
 *
 */
public class _2_삼각_달팽이_책풀이_dxdy응용 {

    class Solution {
        public int[] solution(int n) {

            int[][] triangle = new int[n][n];
            int v = 1;
            int x = 0;
            int y = 0;

            while(true){

                //아래로 이동
                while(true){
                    triangle[y][x] = v++;
                    if(y + 1 == n || triangle[y+1][x] != 0) break;
                    y += 1;
                }

                if(x + 1 == n || triangle[y][x + 1] != 0) break;
                x += 1;

                //오른쪽으로 이동
                while(true){
                    triangle[y][x] = v++;
                    if(x + 1 == n || triangle[y][x + 1] != 0) break;
                    x += 1;
                }

                if(x - 1 < 0 || y - 1 < 0 || triangle[y-1][x-1] != 0) break;
                x -= 1;
                y -=1;
                //아래 이동
                while(true){
                    triangle[y][x] = v++;
                    if(x - 1 < 0 || y - 1 < 0 || triangle[y-1][x-1] != 0) break;
                    x -= 1;
                    y -=1;
                }

                if(y + 1 == n || triangle[y+1][x] != 0) break;
                y += 1;
            }

            int[] result = new int[v-1];
            int idx = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j <= i; j++){
                    result[idx++] = triangle[i][j];
                }
            }

            return result;
        }
    }
}
