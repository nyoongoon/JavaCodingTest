package _0_Theory.Chapter3_NonLinear._16_비선형자료구조_연습문제_2.src;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Practice2_re {
    public static int[] solution(int[][] intervals, int[] queries) {
        PriorityQueue<Interval> queue = new PriorityQueue<>((x, y) -> x.range - y.range);

        for (int[] arr : intervals) {
            queue.add(new Interval(arr[0], arr[1]));
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            PriorityQueue<Interval> copy = new PriorityQueue<>(queue);
            result[i] = getRange(copy, queries[i]);
        }

        return result;
    }

    private static int getRange(PriorityQueue<Interval> queue, int query) {

        while (!queue.isEmpty()) {
            Interval interval = queue.poll();
            if (interval.start <= query && query <= interval.end) {
                return interval.range;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        // Test code
        int[][] intervals = {{1, 4}, {2, 4}, {3, 6}, {4, 4}};
        int[] queries = {2, 3, 4, 5};
        System.out.println(Arrays.toString(solution(intervals, queries)));

        intervals = new int[][]{{2, 3}, {2, 5}, {1, 8}, {20, 25}};
        queries = new int[]{2, 19, 5, 22};
        System.out.println(Arrays.toString(solution(intervals, queries)));
    }

    public static class Interval {
        int start;
        int end;
        int range;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
            range = end - start + 1;
        }
    }
}
