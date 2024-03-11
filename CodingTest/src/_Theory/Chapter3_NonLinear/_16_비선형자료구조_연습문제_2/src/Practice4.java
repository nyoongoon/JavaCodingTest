package _Theory.Chapter3_NonLinear._16_비선형자료구조_연습문제_2.src;

import java.util.ArrayList;
import java.util.List;

public class Practice4 {
    static int maxPerform;

    public static int solution(int n, int[] speed, int[] efficiency, int k) {
        maxPerform = Integer.MIN_VALUE;
        // 작업 성능 = 작업속도합 * 가장효율낮은값.
        // 조합 개념

        pick(speed, efficiency, k, 0, new ArrayList<>(), new ArrayList<>(), 0);
        return maxPerform;
    }

    public static void pick(int[] speed, int[] efficiency, int k, int depth, List<Integer> speeds, List<Integer> effis, int pickTimes) {
        if (pickTimes == k) {
//            speeds.stream().forEach(e -> System.out.println(e));

            int speedSum = speeds.stream().mapToInt(i -> i).sum();
            int minEffi = effis.stream().mapToInt(i -> i).min().orElseThrow();

            maxPerform = Math.max(maxPerform, speedSum * minEffi);
//            System.out.println("maxPerform == " + maxPerform);
            return;
        }

        for (int i = depth; i < speed.length; i++) {
            speeds.add(speed[i]);
            effis.add(efficiency[i]);
            /** depth 사용 주의.. 뽑은 순서를 가리키는게 아니라 현재 뎁스 다음부터 사용가능함을 나타냄  **/
            pick(speed, efficiency, k, i + 1, speeds, effis, pickTimes + 1);

            speeds.remove(speeds.size() - 1);
            effis.remove(effis.size() - 1);
        }

    }

    public static void main(String[] args) {
        // Test code
        int[] speed = {2, 10, 3, 1, 5, 8};
        int[] efficiency = {5, 4, 3, 9, 7, 2};
        System.out.println(solution(6, speed, efficiency, 2));
        System.out.println(solution(6, speed, efficiency, 3));
        System.out.println(solution(6, speed, efficiency, 4));
    }
}
