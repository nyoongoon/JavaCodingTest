package _Theory.Chapter3_NonLinear._16_비선형자료구조_연습문제_2.src;

import java.util.PriorityQueue;

public class Practice1 {
    static class Friend{
        int idx;
        int arrived;
        int departed;
        public Friend(int idx, int arrived, int departed) {
            this.idx = idx;
            this.arrived = arrived;
            this.departed = departed;
        }
    }
    public static int solution(int[][] times, int targetFriend) {
        // targetFriend의 도착시간을 기준으로.. 우선순위 큐에 넣기
        // if 기준시간 이전에 떠나는 친구는 큐에 안넣기
        //
        PriorityQueue<Friend> queue = new PriorityQueue<>((x, y) -> x.arrived - y.arrived);
        int targetArrivedTime = times[targetFriend][0];
        for (int i = 0; i < times.length; i++) {
            if (times[i][1] < targetArrivedTime){
                continue;
            }
            Friend friend = new Friend(i, times[i][0], times[i][1]);
            queue.add(friend);
//            System.out.println("add");
        }

        int order = 0;
        while(!queue.isEmpty()){
            Friend found = queue.poll();
//            System.out.println("found.idx == " + found.idx);
            if(found.idx == targetFriend){
                return order;
            }
            order++;
        }

        return 0;
    }

    public static void main(String[] args) {
        // Test code
        int[][] times = {{1, 4}, {2, 3}, {4, 6}};
        System.out.println(solution(times, 1)); // 1

        times = new int[][]{{3, 10}, {1, 5}, {2, 6}};
        System.out.println(solution(times, 0)); // 2

        times = new int[][]{{5, 10}, {1, 2}, {2, 4}, {3, 6}};
        System.out.println(solution(times, 0)); // 1
    }
}
