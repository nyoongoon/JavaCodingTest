package _Theory.Chapter4_Algorithm._14_다이나믹_프로그래밍_연습문제.src.ans;// Practice
// 배낭에 물품을 담으려고 한다.
// 배낭에는 k 무게 만큼의 물품을 담을 수 있다.
// n 개의 물품이 주어지고 이 물품의 무게와 가치 정보가 items 2차원 배열에 주어졌을 때,
// 최대 가치가 되도록 물품을 담았을 때의 가치를 출력하는 프로그램을 작성하세요.

// 입출력 예시
// items: {{6, 13}, {4, 8}, {3, 6}, {5, 12}}
// n: 4
// k: 7
// 출력: 14


import java.util.Arrays;

public class Practice3 {

    public static int solution(int[][] items, int n, int k) {
        Arrays.sort(items, (x, y) -> x[0] - y[0]);

        int[][] dp = new int[n + 1][k + 1];
        //dp[0] 은 아무것도 선택 안했을 경우로 0으로 채워진다 -> dp[i + 1]로 채우는 이유

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) { // j는 배낭이 담을 수 있는 무게
                if (items[i][0] > j) { //현재 아이템 담을 수 없는 경우 이전 행 무게로 덮어씌우기
                    dp[i + 1][j] = dp[i][j];
                } else { //배낭 담을 수 있는 경우 Math.max(이전 무게의 가치, 현재무게 가치 + 남는 무게 가치 최대값)
                    dp[i + 1][j] = Math.max(dp[i][j], items[i][1] + dp[i + 1][j - items[i][0]]);
                }
            }
        }

        return dp[n][k];
    }

    public static void main(String[] args) {
        // Test code
        int[][] items = {{6, 13}, {4, 8}, {3, 6}, {5, 12}};
        System.out.println(solution(items, 4, 7));  // 14
    }
}
