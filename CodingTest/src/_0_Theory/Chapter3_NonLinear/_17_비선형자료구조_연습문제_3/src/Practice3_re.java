package _0_Theory.Chapter3_NonLinear._17_비선형자료구조_연습문제_3.src;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Practice3_re {


    public static void main(String[] args) {
        // Test code
        int[][] customers = {{1, 4}, {2, 5}, {3, 14}, {4, 1}, {5, 7}, {6, 5}, {7, 7}, {8, 5}, {9, 10}, {10, 3}};
        System.out.println(solution(3, customers));
    }

    private static ArrayList<Integer> solution(int k, int[][] customers) {
        ArrayList<Integer> result = new ArrayList<>();
        // k개의 계산대
        // n명의 고객
        // 먼저온 순서대로 계산대가서 계산을 진핸
        // 큐에 넣는 순서..?
        // 1. 비어있는 계산대 중 번호가 작은 쪽 먼저
        // 2. 동시에 빈 자리 계산대 번호 작은 쪽으로..

        // 동시에 계산을 마친 손님 -> 계산대 번호가 높은 쪽 먼저
        // ㄴ> 우선순위 큐 -> 1. 계산끝 2. 계산대번호 높은쪽
        PriorityQueue<Customer> counter = new PriorityQueue<>((x, y) -> {
            if (x.count == y.count) { //개수 같으면 번호 내림차순
                return y.number - x.number;
            } else { // 개수 다르면 개수 오름차순
                return x.count - y.count;
            }
        });
        PriorityQueue<Integer> numbers = new PriorityQueue<>();
        for (int i = 1; i <= k; i++) {
            numbers.add(i);
        }

        int idx = 0;
        int nowTime = 0;
        counter.add(new Customer(customers[idx][0], nowTime + customers[idx][1], numbers.poll()));
        idx++;
        while (!counter.isEmpty()) {
            // k 될때까지 넣기
            while (counter.size() < k && idx < customers.length) {
                counter.add(new Customer(customers[idx][0], nowTime + customers[idx][1], numbers.poll()));
                idx++;
            }

            // 고객 하나씩 빼면서 시간 더하기..
            Customer exit = counter.poll();
            result.add(exit.idx);
            numbers.add(exit.number); // 고객 빼면 숫자 다시 넣기..
            nowTime = exit.count;
            // peek 하여 같은 count있으면 계속 빼기
            while (!counter.isEmpty() && counter.peek().count == nowTime) {
                exit = counter.poll();
                result.add(exit.idx);
                numbers.add(exit.number);
            }
        }

        return result;
    }

    static class Customer {
        int idx;
        int count;
        int number;

        public Customer(int idx, int count, int number) {
            this.idx = idx;
            this.count = count;
            this.number = number;
        }
    }
}
