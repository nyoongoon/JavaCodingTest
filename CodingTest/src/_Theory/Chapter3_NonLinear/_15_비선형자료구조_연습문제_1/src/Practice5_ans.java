package _Theory.Chapter3_NonLinear._15_비선형자료구조_연습문제_1.src;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Practice5_ans {

    //bfs로 풀어보기..
    public static int solution(int[] forbidden, int a, int b, int x) {
        Set<int[]> visited = new HashSet<>();
        for (int i : forbidden) {
            visited.add(new int[]{0, i});
            visited.add(new int[]{1, i});
        }
        int times = 0;
        int limit = x + a + b;
        Queue<int[]> queue = new LinkedList<>();
        int[] start = new int[]{0, 0};
        queue.add(start);


        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] polled = queue.poll();

                if (!visited.add(polled)) {
                    continue;
                }
                if (polled[1] == x) {
                    return times;
                }

                if (polled[1] + a <= limit) {
                    queue.add(new int[]{0, polled[1] + a});
                }

                if (polled[0] != 1 && polled[1] - b > 0) { // ㅊㅔ크를 꺼냈을 때 하고 싶었는데 x == 0 체크 때문에 넣을 떄 해야함..
                    queue.add(new int[]{1, polled[1] - b});
                }
            }

            times++;
        }

        return -1;
    }


    public static void main(String[] args) {
        // Test code
        int[] forbidden = {14, 4, 18, 1, 15};
        System.out.println(solution(forbidden, 3, 15, 9));

        forbidden = new int[]{8, 3, 16, 6, 12, 20};
        System.out.println(solution(forbidden, 15, 13, 11));

        forbidden = new int[]{1, 6, 2, 14, 5, 17, 4};
        System.out.println(solution(forbidden, 16, 9, 7));
    }
}
