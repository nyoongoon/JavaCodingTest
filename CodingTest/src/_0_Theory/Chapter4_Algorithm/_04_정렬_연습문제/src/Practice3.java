package _0_Theory.Chapter4_Algorithm._04_정렬_연습문제.src;// Practice3
// intervals 라는 구간으로 이루어진 배열이 주어졌을 때,
// 오버랩 되는 구간을 합치는 프로그램을 작성하세요.

// 입출력 예시
// 입력: [2, 6], [1, 3], [15, 18], [8, 10]
// 출력: [1, 6] [8, 10] [15, 18]

// 1, 3 |  2, 6  |  8, 10 | 15, 18

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Practice3 {

    public static ArrayList<int[]> solution(int[][] intervals) {
        ArrayList<int[]> result = new ArrayList<>();

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((x, y) -> x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]);
        for (int[] interval : intervals) {
            priorityQueue.add(interval);
        }

        int[] cur = priorityQueue.poll();
        while (!priorityQueue.isEmpty()) {
            int[] polled = priorityQueue.poll();

            if (cur[1] > polled[0]) {
                cur[1] = polled[1];
            } else {
                result.add(cur);
                cur = polled;
            }
        }
        result.add(cur);
        return result;
    }

    public static void sort(int[][] intervals) {

    }

    public static void main(String[] args) {
        // Test code
        int[][] intervals = {{2, 6}, {1, 3}, {15, 18}, {8, 10}};

        for (int[] item : solution(intervals)) {
            System.out.print(Arrays.toString(item) + " ");
        }
        System.out.println();

    }
}
