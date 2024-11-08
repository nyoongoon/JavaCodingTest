package _0_Theory.Chapter4_Algorithm._22_알고리즘_연습문제_1.src.ans;

import java.util.ArrayList;

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
            int item = items[idx];
            if (!used[item]) {
                used[item] = true;
                cnt++;
            }
            idx++;
        }

        int result = 0;

        while (idx < items.length) {
            if (!used[items[idx]]) {
                // list에 사용되었지만 남아 있는 것?
                // list는 현재 꽂혀 있는 목록
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = idx; i < items.length; i++) {
                    int item = items[i];
                    if (used[item] && !list.contains(item)) {
                        list.add(item);
                    }
                }

                if (list.size() == n) {
                    used[list.get(list.size() - 1)] = false; //마지막 뽑기
                } else {
                    for (int i = 1; i < items.length; i++) {
                        if (used[i] && !list.contains(i)) {
                            used[i] = false;
                            break;
                        }
                    }
                }
                used[idx] = true;
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
