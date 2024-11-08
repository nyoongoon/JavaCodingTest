package _0_Theory.Chapter4_Algorithm._22_알고리즘_연습문제_1.src.ans;

import java.util.HashMap;
import java.util.Map;

public class Practice2_re {
    public static int solution(int n, int[] plates, int types, int coupon) {
        if (plates == null || plates.length == 0) {
            return -1;
        }
        int max = Integer.MIN_VALUE;

        Map<Integer, Integer> map = new HashMap<>();
        // 투포인터 만들기
        int p1 = 0;
        int p2 = p1 + n - 1;
        for (int i = p1; i <= p2; i++) {
            Integer value = map.getOrDefault(plates[i], 0);
            map.put(plates[i], value + 1);
        }

        max = getMax(map, max, coupon);

        for (int i = 1; i < plates.length; i++) {
            // 이전 것 빼기
            Integer p1Value = map.getOrDefault(plates[p1], 1);
            if(p1Value - 1 <= 0){
                map.remove(plates[p1]);
            }else{
                map.put(plates[p1], p1Value - 1);
            }

            p1++;
            p2 = (p2 + 1) % plates.length;

            Integer p2Value = map.getOrDefault(plates[p2], 0);
            map.put(plates[p2], p2Value + 1);

            max = getMax(map, max, coupon);
        }

        return max;
    }

    private static int getMax(Map<Integer, Integer> map, int max, int coupon) {
        if(map.containsKey(coupon)){
            max = Math.max(max, map.size());
        }else{
            max = Math.max(max, map.size() + 1);
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
}
