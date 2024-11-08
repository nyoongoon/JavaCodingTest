package _0_Theory.Chapter3_NonLinear._16_비선형자료구조_연습문제_2.src;

import java.util.PriorityQueue;

/**
 * 어려움...
 */
public class Practice3_ans {

    public static boolean solution(int[] target) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        int sum = 0;
        for (int i = 0; i < target.length; i++) {
            sum += target[i];
            pq.add(i);
        }


        //sum == 17
        while (pq.peek() != 1) {
            int num = pq.poll(); //9
            sum -= num; // 8

            // 값 체크가 이상한거 같음.. -> num <= sum 으로 충분한거 아닌가.?
            if(num <= sum || sum < 1){ //sum == 0이면 마이너스 전에 값이 같은 것.
                return false;
            }

            // 값 체크가 이상한거 같음.. -> 위에서 num <= 했으므로 결과는 항상 num > 0 아닌가..?
            num -= sum; // num == 1
            sum += num; // 새로 생성된 숫자만 더하면 sum임
            pq.add(num > 0 ? num : sum); // ????

        }

        return true;
    }


    public static void main(String[] args) {
        // Test code
        int[] target = {9, 3, 5};
        System.out.println(solution(target));

        target = new int[]{8, 5};
        System.out.println(solution(target));

        target = new int[]{1, 1, 1, 2};
        System.out.println(solution(target));
    }
}
