package _Theory.Chapter3_NonLinear._16_비선형자료구조_연습문제_2.src;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Practice1_ans {
    public static int solution(int[][] times, int targetFriend) {
        int targetArriveTime = times[targetFriend][0];
        PriorityQueue<Integer> chairs = new PriorityQueue<>();
        for (int i = 0; i < times.length; i++) {
            chairs.add(i);
        }
        Arrays.sort(times, (x, y) -> x[0] - y[0]);

        // 나가는 큐
        PriorityQueue<int[]> friends = new PriorityQueue<>((x, y) -> x[0] - y[0]);

        for (int i = 0; i < times.length; i++) {

            while(!friends.isEmpty() && friends.peek()[0] <= times[i][0]){
                // 나가기(들어오는 시간과 같으면 먼저 나가기)
                chairs.add(friends.poll()[1]);
            }
            // 먼저 나가고 들어오는 것 체크
            if(times[i][0] == targetArriveTime){
                break;
            }

            friends.add(new int[] {times[i][1], chairs.poll()});
        }

        return chairs.peek();
    }

    public static void main(String[] args) {
        // Test code
        int[][] times = {{1, 4}, {2, 3}, {4, 6}};
        System.out.println(solution(times, 1)); // 1

        times = new int[][]{{3, 10}, {1, 5}, {2, 6}};
        System.out.println(solution(times, 0)); // 2

        times = new int[][]{{5, 10}, {1, 2}, {2, 4}, {3, 6}};
        System.out.println(solution(times, 0)); // 0
    }
}
