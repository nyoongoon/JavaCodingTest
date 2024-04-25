package _Theory.Chapter3_NonLinear._16_비선형자료구조_연습문제_2.src;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 우선순위큐 문제 풀이 -> 어려움 --> bfs로 풀려고 했는데 이는 모든 상황 체크하는 것인듯..
 */
public class Practice4_ans {

    public static int solution(int n, int[] speed, int[] efficiency, int k) {
        int[][] engineers = new int[n][2];
        for (int i = 0; i < n; i++) {
            engineers[i][0] = efficiency[i];
            engineers[i][1] = speed[i];
        }
        Arrays.sort(engineers, (x, y) -> y[0] - x[0]);
        PriorityQueue<Integer> pq = new PriorityQueue();

        int result = 0;
        int sum = 0;
        for (int[] engineer : engineers) {
            sum += engineer[1];
            pq.add(engineer[1]);
            if (pq.size() > k) {
                Integer minSpeed = pq.poll();
                sum -= minSpeed;
            }
            result = Math.max(result, sum * engineer[0]); //항상 현재가 최소 성능
        }
        return result;
    }


    public static void main(String[] args) {
        // Test code
        int[] speed = {2, 10, 3, 1, 5, 8};
        int[] efficiency = {5, 4, 3, 9, 7, 2};
        System.out.println(solution(6, speed, efficiency, 2));
        System.out.println(solution(6, speed, efficiency, 3));
        System.out.println(solution(6, speed, efficiency, 4));
    }
}
