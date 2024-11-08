package _0_Theory.Chapter4_Algorithm._22_알고리즘_연습문제_1.src;

import java.util.ArrayList;
import java.util.List;

public class Practice3 {


    public static int solution(int n, int[] items) {
        if (items == null || items.length == 0) {
            return -1;
        }
        boolean[] used = new boolean[items.length + 1];

        // 초기화
        int idx = 0;
        int cnt = 0;
        while (cnt < n) {
            if (!used[items[idx]]) {
                used[items[idx]] = true;
                cnt++;
            }
            idx++;
        }

        int result = 0;

        while (idx < items.length) {
            if (!used[items[idx]]) {
                List<Integer> list = new ArrayList<>();
                for (int i = idx; i < items.length; i++) {
                    int item = items[i];
                    // 꽂혀 있는데 뒤에도 나오는 것..
                    if (used[item] && !list.contains(item)) {
                        list.contains(item);
                    }
                }
                // 뒤에 나오는 것 다 꽂혀있음
                if (list.size() == n) {
                    // 그리디 하게 마지막 꽂혀 있는 것 빼기
                    int lastItem = list.get(list.size() - 1);
                    used[lastItem] = false;
                } else {
                    for (int i = 1; i < items.length; i++) {
                        //꽂혀있는데 뒤에 안나오는 것 빼기
                        if(used[items[i]] && !list.contains(items[i])){
                            used[i] = false;
                            break;
                        }
                    }
                }
                used[items[idx]] = true;
                result++;
            }
            idx++;
        }
        return result;
    }

    public static void main(String[] args) {
        // Test code
        int n = 2;
        int[] items = {2, 3, 2, 3, 1, 2, 7};
        System.out.println(solution(n, items));
    }

}
