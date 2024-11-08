package _0_Theory.Chapter3_NonLinear._12_우선순위큐_연습문제.src;// Practice3
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

class Num implements Comparable<Num> { //TODO 넘 복잡하게 푼 듯..!
    int value;
    int frequency;

    public Num(int value, int frequency) {
        this.value = value;
        this.frequency = frequency;
    }

    @Override
    public int compareTo(Num o) {
        if (this.frequency == o.frequency) {
            return this.value - this.frequency; //오름차순
        } else {
            return o.frequency - this.frequency; //내림차순...
        }
    }
}

public class Practice3 {
    public static void solution1(int[] nums, int k) {
        Map<Integer, Num> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).frequency++;
            } else {
                map.put(nums[i], new Num(nums[i], 1));
            }
        }
        PriorityQueue<Num> pq = new PriorityQueue<>();
        for (Integer key : map.keySet()) {
            pq.add(map.get(key));
        }
        for (int i = 0; i < k; i++) {
            System.out.println(pq.poll().value);
        }
    }

    public static void solution2(int[] nums, int k) { // TODO 블로그

    }

    public static void main(String[] args) {
        // Test code
        int[] nums = {1, 1, 1, 2, 2, 3};
        solution1(nums, 2);
        solution2(nums, 2);
        System.out.println();

        nums = new int[]{3, 1, 4, 4, 3, 3, 1, 2, 2, 1, 3};
        solution1(nums, 4);
        solution2(nums,4);
    }
}
