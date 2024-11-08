package _0_Theory.Chapter2_Linear._13_선형자료구조_연습문제.src;

import java.util.ArrayList;
import java.util.List;

public class Practice3 {
    public static void solution(int[] data) { //선형 탐사법(liner probing) ㄱㅐ념이라서 해시 인가...
        // {3, 2, 1, -3, -1}; -> 1 4 5 3 2
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[data.length];

        visited[0] = true;
        int idx = 0;

        for (int i = 0; i < data.length; i++) {
            list.add(idx + 1);
            visited[idx] = true;
            int val = data[idx]; // 3

            if (i == data.length - 1) {
               break;
            }
            idx = getIdxByVal(visited, idx, val);
        }


        System.out.println(list);
    }

    public static int getIdxByVal(boolean[] visited, int idx, int val) {
        int newIdx;
        if (val >= 0) {
            newIdx = (idx + val) % visited.length;
            while (visited[newIdx]) {
                System.out.println(newIdx);
                newIdx = (newIdx + 1) % visited.length;
            }
        } else { // val < 0
            newIdx = (idx + val + visited.length) % visited.length;
            while (visited[newIdx]) {
                newIdx = (newIdx - 1 + visited.length) % visited.length;
            }
        }
        return newIdx;
    }

    public static void main(String[] args) {
        int[] balloon = {3, 2, 1, -3, -1};
        solution(balloon);

        System.out.println();
        balloon = new int[]{3, 2, -1, -2};
        solution(balloon);
    }
}
