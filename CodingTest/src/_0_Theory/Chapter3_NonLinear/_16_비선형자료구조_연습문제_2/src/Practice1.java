package _0_Theory.Chapter3_NonLinear._16_비선형자료구조_연습문제_2.src;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Practice1 {
    public static int solution(int[][] times, int targetFriend) {
        // TODO 다시풀기
        int targetArrivedTIme = times[targetFriend][0];

        PriorityQueue<Integer> chairs = new PriorityQueue<>();
        for (int i = 0; i < times.length; i++) {
            chairs.add(i);
        }

        Arrays.sort(times, (x, y) -> x[0] - y[0]);

        PriorityQueue<int[]> friends = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        for (int i = 0; i < times.length; i++) {
            //있으면 먼저 나가야함
            while (!friends.isEmpty() && friends.peek()[0] <= times[i][0]) {
                // 나갈시간이 올사람의들어올시간보다 작으면 내보내기
                chairs.add(friends.poll()[1]);
            }

            // 들어올사람 friends에 넣기
            if(times[i][0] == targetArrivedTIme){
                return chairs.peek();
            }
            friends.add(new int[]{times[i][1], chairs.poll()});
        }

        return -1;
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
