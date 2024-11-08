package _0_Theory.Chapter3_NonLinear._16_비선형자료구조_연습문제_2.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice2 {
    public static int[] solution(int[][] intervals, int[] queries) {
        List<Integer> results = new ArrayList<>();
        List<Interval> intervalList = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            intervalList.add(new Interval(intervals[i][0], intervals[i][1]));
        }
        intervalList.sort((x, y) -> x.interval - y.interval);

        for (int i = 0; i < queries.length; i++) {
            int result = getMinRange(intervalList, queries[i]);
            results.add(result);
        }

        return results.stream().mapToInt(i -> i).toArray();
    }

    private static int getMinRange(List<Interval> intervalList, int target) {
        for (int i = 0; i < intervalList.size(); i++) {
            if(intervalList.get(i).isContain(target)){
                return intervalList.get(i).interval;
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

    static class Interval {
        int start;
        int end;
        int interval;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
            this.interval = end - start + 1;
        }

        public boolean isContain(int target) {
            return start <= target && target <= end;
        }
    }

}
