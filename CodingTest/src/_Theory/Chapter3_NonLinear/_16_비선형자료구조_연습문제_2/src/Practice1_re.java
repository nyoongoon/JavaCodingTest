package _Theory.Chapter3_NonLinear._16_비선형자료구조_연습문제_2.src;

import java.util.PriorityQueue;

public class Practice1_re { //TODO 틀린듯...? 원
    public static int solution(int[][] times, int targetFriend) {
        int result = -1;

        PriorityQueue<Integer> seatQueue = new PriorityQueue<>();
        for (int i = 0; i < times.length; i++) {
            seatQueue.add(i);
        }

        PriorityQueue<Friend> friendQueue = new PriorityQueue<>((x, y) -> x.arrived - y.arrived);
        for (int i = 0; i < times.length; i++) {
            friendQueue.add(new Friend(i, times[i][0], times[i][1]));
        }

        PriorityQueue<Friend> resultQueue = new PriorityQueue<>((x, y) -> x.arrived - y.arrived);

        Friend friend = friendQueue.poll();
        friend.setSeat(seatQueue.poll());
        resultQueue.add(friend);

        while (!resultQueue.isEmpty()) {

            while (!resultQueue.isEmpty() && !friendQueue.isEmpty() && resultQueue.peek().departed >= friendQueue.peek().arrived) {
                friend = friendQueue.poll();
                friend.setSeat(seatQueue.poll());
                resultQueue.add(friend);
            }

            Friend friendLeft = resultQueue.poll();
            seatQueue.add(friendLeft.seat);
            if (friendLeft.order == targetFriend) {
                result = friendLeft.seat;
            }
        }

        return result;
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

    static class Friend {
        int order;
        int arrived;
        int departed;
        int seat;

        public Friend(int order, int arrived, int departed) {
            this.order = order;
            this.arrived = arrived;
            this.departed = departed;
        }

        public void setSeat(int seat) {
            this.seat = seat;
        }
    }
}
