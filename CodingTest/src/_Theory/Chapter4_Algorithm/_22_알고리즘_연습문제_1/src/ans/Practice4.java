package _Theory.Chapter4_Algorithm._22_알고리즘_연습문제_1.src.ans;

public class Practice4 {
    final static int numOfTree = 2;

    public static int solution(int[] order, int k) {
        if (order == null || order.length == 0) {
            return -1;
        }

        int n = order.length;
        // k번 이동한 횟수 * 1번 2번 겨웅 테이블 -> 3차원 테이블
        // k+2 개인 이유는 k+1에서 초기테이블 하나 추가한 것이므로
        int[][][] dp = new int[k + 2][numOfTree + 1][n];

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < k + 2; j++) {
                //떨어지는 쪽이 1번 나
                if (order[i] == 1) {
                    dp[j][1][i] = Math.max(dp[j][1][i - 1], dp[j - 1][2][i - 1]) + 1;
                    dp[j][2][i] = Math.max(dp[j - 1][1][i - 1], dp[j][2][i - 1]);
                } else {
                    if (i == 1 && j == 1) {
                        continue; //여우는 1번에만 존재하는 상황
                    }
                    dp[j][1][i] = Math.max(dp[j][1][i - 1], dp[j - 1][2][i - 1]);
                    dp[j][2][i] = Math.max(dp[j - 1][1][i - 1], dp[j][2][i - 1]) + 1;
                }
            }
        }

        int result = 0;
        for (int i = 1; i < k + 2; i++) {
            result = Math.max(result, Math.max(dp[i][1][n - 1], dp[i][2][n - 1]));
        }
        return result;
    }

    public static void main(String[] args) {
        // Test code
        int[] order = {2, 1, 1, 2, 2, 1, 1};
        int k = 2;
        System.out.println(solution(order, k));
    }
}
