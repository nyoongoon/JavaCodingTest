package _0_Theory.Chapter4_Algorithm._06_이진탐색_연습문제.src;// Practice4
// 정수형 배열 weights 와 정수 days 가 주어졌다.
// weights 에는 각 상품의 무게들의 정보가 들어있고, days 는 운송 납기일이다.
// 상품들은 weights 에 적혀있는 순서대로 실어서 운송해야 하는데,
// days 이내에 운송을 하기 위한 차량의 최소한의 적재량을 계산하는 프로그램을 작성하세요.
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
public class Practice4 {
    public static int solution(int[] weights, int days) {
        //ex) 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ->  10 ~ 55 중의 값에 적재량이 있다. -> 조건에 맞는 적재량을 이진탐색하기 !
        int left = 0;
        int right = 0;
        for (int w : weights) {
            left = Math.max(w, left); //max값이 적재량 최소
            right += w; //총합이 적재량 최대
        }

        // 적재량 최소 ~ 최대 사이에서 이진탐색
        while (left <= right) {
            int mid = (left + right) / 2;
            int cur = 0;
            int cnt = 1; //운송일 카운트
            for (int w : weights) {
                if (cur + w > mid) {
                    cnt++;
                    cur = 0;
                }
                cur += w;
            }

            if (cnt > days) {
                left = mid + 1;
            } else { // 같을 때 왜 low? -> 최소 적재량 구하므로
                right = mid - 1;
            }
        }

        /**
         * 왜 left가 정답?
         * cnt == days인 경우가 정답의 후보.. (cnt == days이면서 가장 작은 값들은 여러개 그중 최소 -> left~right길이가1일떄정답이됨..??)
         * -> 더 작은 값을 구하는 경우에서 left값은 그대로, right값은 변경되므로 최종 left가 정답! --> 확인해보기
         */
        return left; // 왜 left ?
    }

    public static void main(String[] args) {
        // Test code
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(solution(weights, 5));   // 15

        weights = new int[]{3, 2, 2, 4, 1, 4};
        System.out.println(solution(weights, 3));   // 6
    }
}
