package _Theory.Chapter3_NonLinear._12_우선순위큐_연습문제.src;// Practice3
// nums 배열에 주어진 정수들 중에서 가장 많이 발생한 숫자들 순으로 k 번째 까지 출력하세요.
// 빈도가 같은 경우에는 값이 작은 숫자가 먼저 출력되도록 구현하세요.

// 입출력 예시
// 입력: 1, 1, 1, 2, 2, 3
// k: 2
// 출력: 1, 2

// 입력: 3, 1, 5, 5, 3, 3, 1, 2, 2, 1, 3
// k: 3
// 출력: 3, 1, 2

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Practice3_ans {
    public static void solution1(int[] nums, int k) { // TODO    간단하게 푸는 법 블로그 정리
        // Map.Entry로 풀기
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq =
                new PriorityQueue<>((x, y) -> x.getValue() == y.getValue() ? x.getKey() - y.getKey() : y.getValue() - x.getValue());

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        pq.addAll(entries);

        for (int i = 0; i < k; i++) {
            System.out.print(pq.poll().getKey() + " ");
        }
        System.out.println();

    }

    public static void solution2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Num> pq = new PriorityQueue<>(); // Comparable로 풀기
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.add(new Num(entry.getKey(), entry.getValue()));
        }

        for (int i = 0; i < k; i++) {
            System.out.print(pq.poll().value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test code
        int[] nums = {1, 1, 1, 2, 2, 3};
        solution1(nums, 2);
        solution2(nums, 2);
        System.out.println();

        nums = new int[]{3, 1, 4, 4, 3, 3, 1, 2, 2, 1, 3};
        solution1(nums, 3);
        solution2(nums, 3);
    }

    static class Num implements Comparable<Num> {
        int value;
        int freq;

        public Num(int value, int freq) {
            this.value = value;
            this.freq = freq;
        }

        @Override
        public int compareTo(Num o) {
            return this.freq == o.freq ? this.value - o.value : o.freq - this.value;
        }
    }
}
