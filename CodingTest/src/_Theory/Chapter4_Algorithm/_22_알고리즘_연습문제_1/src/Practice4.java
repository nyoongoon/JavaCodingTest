package _Theory.Chapter4_Algorithm._22_알고리즘_연습문제_1.src;

// 틀 .. dp로 풀 것..
public class Practice4 {
    static int numberOfTree = 2;

    public static int solution(int[] order, int k) {
        if (order == null || order.length == 0) {
            return -1;
        }

        int n = order.length;

        int[][][] dp = new int[k + 2][numberOfTree + 1][n];


        for (int i = 1; i < k + 2; i++) {
            for (int j = 1; j < n; j++) {
                if (order[i] == 1) {
                    dp[i][1][j] = Math.max(dp[i][1][j - 1], dp[i - 1][2][j - 1]) + 1;
                    dp[i][2][j] = Math.max(dp[i - 1][1][j - 1], dp[i][2][j - 1]);
                } else {
                    if (i == 1 && j == 1) {
                        continue;
                    }
                    dp[i][1][j] = Math.max(dp[i][1][j - 1], dp[i - 1][2][j - 1]);
                    dp[i][2][j] = Math.max(dp[i - 1][1][j - 1], dp[i][2][j - 1]) + 1;
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
