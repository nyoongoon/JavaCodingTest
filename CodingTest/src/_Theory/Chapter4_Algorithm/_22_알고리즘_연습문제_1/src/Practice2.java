package _Theory.Chapter4_Algorithm._22_알고리즘_연습문제_1.src;

import java.util.HashSet;
import java.util.Set;

/**
 * 좋지 않은 풀이...
 */
public class Practice2 {
    public static int solution(int n, int[] plates, int types, int coupon) {
        if (plates == null || plates.length == 0) {
            return -1;
        }

        // coupon의 초밥은 n개에 안걸려야한다.
        // 범위를 선택해야함..
        // 중복되지 않은 값의 최대 범위
        // 범위 => 슬라이딩 윈도우?
        //
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < plates.length; i++) {
            Set<Integer> set = sliding(plates, i, n);
            if (set.contains(coupon)) {
                max = Math.max(max, set.size());
            } else {
                max = Math.max(max, set.size() + 1);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        // Test code
        int n = 4;
        int[] plates = {7, 9, 7, 30, 2, 7, 9, 25};
        int types = 30;
        int coupon = 30;
        System.out.println(solution(n, plates, types, coupon));
    }

    public static Set<Integer> sliding(int[] plates, int idx, int n) {
        Set<Integer> set = new HashSet<>();
        //홀, 짝
        int left = idx % 2 == 0 ? idx : minusLeft(idx, plates.length);
        int right = plusRight(idx, plates.length);
        set.add(plates[left]);
        set.add(plates[right]);

        for (int i = 0; i < n - 1; i++) {
            left = minusLeft(left, plates.length);
            right = plusRight(right, plates.length);
            set.add(plates[left]);
            set.add(plates[right]);
        }

        return set;
    }

    public static int minusLeft(int idx, int length) {
        return (idx - 1 + length) % length;
    }

    public static int plusRight(int idx, int length) {
        return (idx + 1) % length;
    }
}
