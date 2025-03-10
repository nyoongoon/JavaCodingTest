package _0_Theory.Chapter4_Algorithm._10_그리디_연습문제.src;// Practice
// 양의 정수 배열 prices 가 주어졌다.
// 각 원소의 의미는 주식 가격을 의미한다.
// 한 번에 한 주만 보유할 수 있다고 할 때 prices 를 보고 사고 팔기를 반복해서
// 얻을 수 있는 최대 수익을 반환하는 프로그램을 작성하세요.

// 입출력 예시 // 1 3 4 5 5 6
// prices: 5, 1, 6, 4, 3, 5
// 출력: 7

// prices: 1, 2, 3, 4, 5
// 출력: 4

public class Practice2 {
    public static int solution(int[] prices) {
        if(prices == null || prices.length < 2){
            return 0;
        }
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                profit += prices[i + 1] - prices[i];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        // Test code
        int[] prices = {5, 1, 6, 4, 3, 5};
        System.out.println(solution(prices));

        prices = new int[]{1, 2, 3, 4, 5};
        System.out.println(solution(prices));

        prices = new int[]{5, 4, 3, 2, 1};
        System.out.println(solution(prices));
    }
}
