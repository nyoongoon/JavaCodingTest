package _3_프로그래머스_코딩_테스트_문제_풀이_전략_자바편._1_배열;

/**
 * 2차원 배열 방향 이용하는 문제가 많음
 * -> 상하좌우에 따른 dx, dy 배열을 선언하여 사용
 */
public class _2_삼각_달팽이_책풀이_dxdy응용 {

    class Solution {
        int[] dx = {0, 1, -1};
        int[] dy = {1, 0, -1};

        public int[] solution(int n) {
            int[][] triangle = new int[n][n];
            int v = 1;
            int x = 0;
            int y = 0;
            int d = 0;

            while (true) {
                triangle[y][x] = v++;
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx >= n || ny >= n || nx < 0 || ny < 0 || triangle[ny][nx] != 0) {
                    d = (d + 1) % 3;
                    nx = x + dx[d];
                    ny = y + dy[d];
                    if (nx >= n || ny >= n || nx < 0 || ny < 0 || triangle[ny][nx] != 0) break;
                }
                x = nx;
                y = ny;
            }

            int[] result = new int[v -  1];
            int idx = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    result[idx++] = triangle[i][j];
                }
            }
            return result;
        }
    }
}
