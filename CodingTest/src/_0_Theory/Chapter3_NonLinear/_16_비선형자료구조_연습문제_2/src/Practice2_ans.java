package _0_Theory.Chapter3_NonLinear._16_비선형자료구조_연습문제_2.src;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 우선순위큐 응용 -> 여러번 순회해야하는 경우
 * 힙에 intervals 값이 한 번씩만 들어갔다가 나옴..
 */
public class Practice2_ans {
    public static int[] solution(int[][] intervals, int[] queries) {
        int[] result = new int[queries.length];
        PriorityQueue<int[]> intervalQueue = new PriorityQueue<>((x, y) -> (x[1] - x[0]) - (y[1] - y[0]));
        PriorityQueue<Query> queryList = new PriorityQueue<>((x, y) -> x.value - y.value);
        for (int i = 0; i < queries.length; i++) {
            queryList.add(new Query(i, queries[i]));
        }

        int i = 0;
        while (!queryList.isEmpty()) {

            Query query = queryList.poll();
            // query보다 시작값이 작은 값 add
            while (i < intervals.length && intervals[i][0] <= query.value) {
                intervalQueue.add(new int[]{intervals[i][0], intervals[i][1]});
                i++;
            }

            // query보다 start가 큰 interval 빼기
            while (!intervalQueue.isEmpty() && intervalQueue.peek()[1] < query.value) {
                intervalQueue.poll();
            }
            // peek
            int[] peeked = intervalQueue.peek();
            if(peeked == null){
                result[query.idx] = - 1;
            }else{
                result[query.idx] = peeked[1] - peeked[0] + 1;
            }
        }

        return result;
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

    static class Query {
        int idx;
        int value;

        public Query(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }

}
