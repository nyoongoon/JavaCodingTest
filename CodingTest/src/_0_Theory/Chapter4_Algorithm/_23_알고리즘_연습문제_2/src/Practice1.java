package _0_Theory.Chapter4_Algorithm._23_알고리즘_연습문제_2.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * {11, 14, 17}
 * <p>
 * 최소값 중에서 최대값...
 * 11, 2, 14, 21, 17
 * 0, 25 추가
 * -> 0, 11, 2, 14, 21, 17, 25
 * -> 2개 뺴기..
 * -> 정렬..?
 * ->  0, 2, 11, 14, 17, 21, 25  -> 0과 25는 제외 불가.
 * -> 간격계산 2, 9, 3, 3, 4, 4
 * -> 최소값을 좌우 작은 값과 합치기..  --> 같은 값이 있는 경우 작은 값과 합치기..
 * -> 11,
 * .. 뭔가 그리디?
 */
public class Practice1 {
    static final int INF = 99999;

    public static int solution(int[] rocks, int goal, int n) {
        if (rocks == null || rocks.length == 0) {
            return -1;
        }
        List<Integer> rockList = new ArrayList<>();
        for (int i = 0; i < rocks.length; i++) {
            rockList.add(rocks[i]);
        }

        rockList.add(0);
        rockList.add(goal);

        // 정렬
        Collections.sort(rockList);

        List<Integer> intervals = new ArrayList<>();
        for (int i = 0; i < rockList.size() - 1; i++) {
            int interval = rockList.get(i + 1) - rockList.get(i);
            intervals.add(interval);
        }

        for (Integer interval : intervals) {
            System.out.println(interval);
        }


        PriorityQueue<Target> pq = new PriorityQueue<>((x,y) -> x.mid - y.mid);

        for (int i = 0; i < intervals.size(); i++) {
            int left = getValue(intervals, i-1);
            int mid = getValue(intervals, i);
            int right = getValue(intervals, i);
            Target target = new Target(i, left, mid, right);
            pq.add(target);
        }

        int cnt = 0;
        List<Target> resultTarget = new ArrayList<>();
        while(!pq.isEmpty()){
            Target poll = pq.poll();
            if(pq.peek() == null || pq.peek().mid != poll.mid){
                resultTarget.add(poll);
                cnt++;
            }else{
                Target poll2 = pq.poll();
                Target target = getBiggerTarget(poll, poll2);
                // 모르겟따 강의 듣자.. ;;;

            }


        }

        return 0;
    }

    public static Target getBiggerTarget(Target target1, Target target2){
        if(target1.mid == target2.mid){
            throw new IllegalArgumentException();
        }

        int maxLeft = Math.max(target1.left, target2.left);
        int maxRight = Math.max(target1.right, target2.right);

        if(maxLeft > maxRight){
            return maxLeft == target1.left ? target1 : target2;
        }else{
            return maxRight == target1.right ? target1 : target2;
        }
    }

    public static void main(String[] args) {
        // Test code
        int[] rocks = {11, 2, 14, 21, 17};
        int goal = 25;
        int n = 2;
        System.out.println(solution(rocks, goal, n));
    }

    public static int getValue(List<Integer> intervals, int idx) {
        if (idx < 0 || intervals.size() >= idx) {
            return  INF;
        }else{
            return intervals.get(idx);
        }
    }

    public static class Target {
        int idx;
        int left;
        int mid;
        int right;

        public Target(int idx, int left, int mid, int right) {
            this.idx = idx;
            this.left = left;
            this.mid = mid;
            this.right = right;
        }
    }
}
