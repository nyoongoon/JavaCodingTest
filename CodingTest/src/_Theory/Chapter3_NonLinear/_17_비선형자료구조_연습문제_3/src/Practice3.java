package _Theory.Chapter3_NonLinear._17_비선형자료구조_연습문제_3.src;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Practice3 {

    public static ArrayList<Integer> solution(int k, int[][] customers) {
        // K개의 계산대 --> queue의 크기
        // N명의 고객이 물건을 고름
        // -> 비어있는 계산대 중 계산대 번호가 작은 쪽
        // -> 계산대 꽉차잇으면 먼저 끝나는 쪽
        // -> 동시에 끝나면 계산대 번호가 작은 쪽 // -->  queue.add()
        // 순서대로 넣는 것이므로 우선순위 큐 ? -> 넣는 순서

        // 나가는 순서. 동시에 계산 마친 손님이 있으면 계산대 번호가 높은 쪽부터 --> dequeue
        // 계산 걸리는 시간 -> 물건개수 w인경우 w분

        // 우선순위 큐
        // 현재 시간 t일 때
        // -> Customer 큐에 넣을 때 예상 poll 시간 t+w
        // ->
        // order <-> 계산대 순서 반대
        // 계산대 번호 큰 곳 >> 계산대 번호 작은 곳
        PriorityQueue<Integer> numberQueue = new PriorityQueue<>();
        for (int i = 1; i <= k; i++) {
            numberQueue.add(i);
        }


        ArrayList<Integer> result = new ArrayList<>();
        LinkedList<Customer> customerList = new LinkedList<>();


        for (int i = 0; i < customers.length; i++) {
            customerList.add(new Customer(customers[i][0], customers[i][1]));
        }

        int nowTime = 0;
        PriorityQueue<Customer> queue = new PriorityQueue<>();
        enter(queue, customerList.poll(), nowTime, numberQueue.poll());
//        queue.add(customerList.poll());

        while (!queue.isEmpty()) {
            if (queue.size() < k && !customerList.isEmpty()) {
                System.out.println("customerList.size() == " + customerList.size());
                addAll(queue, customerList, numberQueue, k, nowTime);
            }

            Customer endCustomer = exit(queue, numberQueue, result);
            System.out.println("endCustomer == " + endCustomer.order); //
            //동시 나가는 경우
            while (!queue.isEmpty() && queue.peek().time == endCustomer.time) { // todo 여기서 다 동시에 빠져나가고 있음;

                System.out.println("동시");
                endCustomer = exit(queue, numberQueue, result);
            }
            nowTime = endCustomer.time;
            System.out.println("nowTime == " + nowTime);
        }

        return result;
    }

    private static Customer exit(PriorityQueue<Customer> queue, PriorityQueue<Integer> numberQueue, ArrayList<Integer> result) {
        Customer endCustomer = queue.poll();
        numberQueue.add(endCustomer.location);
        result.add(endCustomer.order);
        return endCustomer;
    }

    private static boolean enter(PriorityQueue<Customer> queue, Customer customer, int nowTime, Integer location) {
        customer.addTimeAndLocation(nowTime, location);
        return queue.add(customer);
    }

    public static void addAll(PriorityQueue<Customer> queue, LinkedList<Customer> customerList, PriorityQueue<Integer> numberQueue, int k, int nowTime) {
        while (queue.size() < k && !customerList.isEmpty()) {
            Customer customer = customerList.poll();
            int location = numberQueue.poll();
            if (!enter(queue, customer, nowTime, location)) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        // Test code
        int[][] customers = {{1, 4}, {2, 5}, {3, 14}, {4, 1}, {5, 7}, {6, 5}, {7, 7}, {8, 5}, {9, 10}, {10, 3}};
        System.out.println(solution(3, customers));
    }

    public static class Customer implements Comparable {
        int order;
        int time;
        int location;

        public Customer(int order, int time) {
            this.order = order;
            this.time = time;
        }

        public void addTimeAndLocation(int nowTime, int location) {
            this.time += nowTime;
            this.location = location;
        }

        @Override
        public int compareTo(Object o) {
            Customer other = (Customer) o;
            if (this.time == other.time) {
                return other.location - this.location;
            }
            return this.time - other.time;
        }
    }
}
