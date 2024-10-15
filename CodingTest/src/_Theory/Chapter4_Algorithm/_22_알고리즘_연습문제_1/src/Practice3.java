package _Theory.Chapter4_Algorithm._22_알고리즘_연습문제_1.src;

import java.util.ArrayList;
import java.util.List;

public class Practice3 {


    public static int solution(int n, int[] items) {
        if (items == null || items.length == 0) {
            return -1;
        }

        boolean[] used = new boolean[items.length + 1];

        int idx = 0;
        int cnt = 0;
        // 초기상태 업데이트
        while (cnt < n) {
            if (!used[items[idx]]) {
                used[items[idx]] = true;
                cnt++;
            }
            idx++;
        }
        int result = 0;
        while (idx < items.length) {
            //현재 위치의 전기제품이 꽂혀있지 않은 경우
            if (!used[items[idx]]) {
                // 현재 꽂혀있지 않는 것중에 뒤에 나오는 값 리스트
                ArrayList<Integer> list = new ArrayList<>();
                // 현재 꽂혀 있는 것 중에 나중에 다시 나오는 것은 빼지 않기
                for (int i = idx; i < items.length; i++) {
                    if (used[items[i]] && !list.contains(items[i])) {
                        list.add(items[i]);
                    }
                }
                // 현재 꽂혀있는 것이 나중에 다 사용되는 경우
                if (list.size() == n) {
                    // 그리디하게 가장 마지막에 사용될 것을 콘센트에서 뽑고 현재 것을 꼽기
                    used[list.get(n - 1)] = false;
                } else {
                    // 안쓰는 것이 있는 경우
                    for (int i = 1; i < items.length; i++) {
                        //현재 사용중인데 리스트에 없는 것
                        if (used[i] && !list.contains(i)) { //현재는 꽂혀 있지만 나중에 사용하게되지 않을 제품
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
