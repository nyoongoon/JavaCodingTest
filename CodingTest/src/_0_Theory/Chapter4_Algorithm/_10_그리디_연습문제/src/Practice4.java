package _0_Theory.Chapter4_Algorithm._10_그리디_연습문제.src;// Practice
// 원형 루트 상에 n 개의 주유소가 있다.
// 각 주유소의 가스 보유량은 gas 배열에 주어지고,
// 해당 주유소에서 다음 주유소로의 이동 비용은 cost 배열에 주어진다.

// 어떤 위치에서 차량이 가스를 채워 출발하면 모든 주유소를 방문하고 원래의 위치로 돌아올 수 있는지
// 계산하는 프로그램을 작성하세요.

// 입출력 예시
// gas: 1, 2, 3, 4, 5
// cost: 3, 4, 5, 1, 2
// 출력: 3

// gas: 2, 3, 4
// cost: 3, 4, 3
// 출력: -1


public class Practice4 {
    public static int solution(int[] gas, int[] cost) {
        int totalGas = 0;
        int resultIdx = -1;

        for (int i = 0; i < gas.length; i++) {
            int curGas = gas[i] - cost[i];
            totalGas += curGas;

            if (curGas < 0) {
                resultIdx = i + 1;
            }
        }

        return totalGas >= 0 ? resultIdx : -1;
    }

    public static void main(String[] args) {
        // Test code
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(solution(gas, cost));

        gas = new int[]{2, 3, 4};
        cost = new int[]{3, 4, 3};
        System.out.println(solution(gas, cost));
    }
}
