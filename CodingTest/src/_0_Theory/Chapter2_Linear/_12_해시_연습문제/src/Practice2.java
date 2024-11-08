package _0_Theory.Chapter2_Linear._12_해시_연습문제.src;// Practice2
// 정수형 배열 nums 와 target 이 주어졌을 때,
// nums 에서 임의의 두 수를 더해 target 을 구할 수 있는지 확인하는 프로그램을 작성하세요.
// 두 수 의 합으로 target 을 구할 수 있으면 해당 값의 index 를 반환하고,
// 없는 경우 null 을 반환하세요.

// 입출력 예시
// nums: 7, 11, 5, 3
// target: 10
// 출력: 0, 3

// nums: 8, 3, -2
// target: 6
// 출력: 0, 2


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Practice2 {
    public static int[] solution(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            //key가 값, value가 인덱스
            map.put(numbers[i], i);
        }
        for (Integer number : map.keySet()) { // 어차피 키값이 짝을 이루고 있으므로 하나의 for문으로 해결 가능! -> 아래 보기
            int findValue = target - number;
            if (map.containsKey(findValue)) {
                result[0] = map.get(number);
                result[1] = map.get(findValue);
                return result;
            }
        }

        return null;
    }

    public static int[] solution_ans(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap();
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            if(map.containsKey(numbers[i])){
                result[0] = map.get(numbers[i]);
                result[1] = i;
                return result;
            }

            map.put(target-numbers[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        // Test code
        int[] nums = {7, 11, 5, 3};
        System.out.println(Arrays.toString(solution(nums, 10)));

        nums = new int[]{8, 3, -2};
        System.out.println(Arrays.toString(solution(nums, 6)));

        nums = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(solution(nums, 12)));
    }
}
