package _0_Theory.Chapter4_Algorithm._06_이진탐색_연습문제.src;// Practice4
// 정수형 배열 weights 와 정수 days 가 주어졌다.
// weights 에는 각 상품의 무게들의 정보가 들어있고, days 는 운송 납기일이다.
// 상품들은 weights 에 적혀있는 순서대로 실어서 운송해야 하는데,
// days 이내에 운송을 하기 위한 차량의 운송일 당 최대 적재량 중에서 최소가 되는 경우의 적재량을 계산하는 프로그램을 작성하세요.
//
// 입출력 예시
// weights: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
// days: 5
// 출력: 15
//
// weights: 3, 2, 2, 4, 1, 4
// days: 3
// 출력: 6


/**
 * 주어진 배열의 값 자체가 아닌, 문제가 요구하는 **도메인에 해당하는 값의 범위**로 이진탐색하는 문제 !!
 */
public class Practice4_ans {
    public static int solution(int[] weights, int days) {
        int left = 0;
        int right = 0;
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }

        // left ~ right 중에서 days 이하로 만족하는 적재량 중 최소값 구하기..
        while (left <= right) {
            int target = (left + right) / 2;

            int cur = 0; //하루 중 현재 적재량
            int cnt = 1; //운송일 카운트
            for (int w : weights) {
                if (cur + w > target) {
                    cnt++;
                    cur = 0;
                }
                cur += w;
            }

            if (cnt > days) { // 타겟이 작다 ->타겟 적재량 늘리기..
                left = target + 1;
            } else { //cnt <= days -> 타겟이 크다 -> 타겟 적재량 줄이기.. --> cnt==days 중에 답이 있는데 이 중 최소..
                right = target - 1;
            }
        }
        return left; //최소 구하므로 left 반환..
    }

    public static void main(String[] args) {
        // Test code
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(solution(weights, 5));   // 15

        weights = new int[]{3, 2, 2, 4, 1, 4};
        System.out.println(solution(weights, 3));   // 6
    }
}
