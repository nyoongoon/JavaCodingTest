// 배낭에 물품을 담으려고 한다.
// 배낭에는 k 무게 만큼의 물품을 담을 수 있다.
// n 개의 물품이 주어지고 이 물품의 무게와 가치 정보가 items 2차원 배열에 주어졌을 때,
// 최대 가치가 되도록 물품을 담았을 때의 가치를 출력하는 프로그램을 작성하세요.

// 입출력 예시
// items: {{6, 13}, {4, 8}, {3, 6}, {5, 12}}
// n: 4
// k: 7
// 출력: 14


import java.util.HashMap;
import java.util.Map;

public class Prac_3_my {

    public static int solution(int[][] items, int n, int k) {
        int[] dp = new int[k + 1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < items.length; i++) {
            map.put(items[i][0], items[i][1]);
        }

        for (int i = 1; i <= k; i++) {
            dp[i] = map.getOrDefault(i, 0);
            for (int j = 1; j <= i/2; j++) {
                if(i-j == j) continue;
                dp[i] = Math.max(dp[i], dp[i-j] + dp[j]);
            }
        }

        return dp[k];
    }

    public static void main(String[] args) {
        // Test code
        int[][] items = {{6, 13}, {4, 8}, {3, 6}, {5, 12}};
        System.out.println(solution(items, 4, 7));  // 14
    }
}
