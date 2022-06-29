package DP;

import java.util.HashMap;
import java.util.Scanner;

public class MakeOne_re {

    static HashMap<Integer, Integer> map = new HashMap<>();
    static int cnt = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        int x = stdIn.nextInt();
        recursive(x, 0);
        System.out.println(cnt);
    }

    public static void recursive(int x, int depth) {
        if (cnt - depth < 0) { // 최소값이 현재 뎁스보다 낮다면 계산x
            return;
        }

        if (map.containsKey(x)) { //이미 메모에 저장되어 있다면 바로 리턴
            cnt = Math.min(cnt, depth + map.get(x));
            return;
        }


        if (x <= 1) {
            cnt = Math.min(depth, cnt); // 마지막 depth

        } else {
            if (x % 5 == 0) {
                recursive(x / 5, depth + 1);
                putMin(x, depth, cnt);
            }
            if (x % 3 == 0) {
                recursive(x / 3, depth + 1);
                putMin(x, depth, cnt);
            }
            if (x % 2 == 0) {
                recursive(x / 2, depth + 1);
                putMin(x, depth, cnt);
            }
            if (x > 1) {
                recursive(x - 1, depth + 1);
                putMin(x, depth, cnt);
            }

        }
    }

    public static void putMin(int curNum, int nowDepth, int endDepth) {
        int mapVal;
        if (map.containsKey(curNum)) {
            mapVal = Math.min(map.get(curNum), endDepth - nowDepth);
        } else {
            mapVal = endDepth - nowDepth;
        }

        map.put(curNum, mapVal);
    }
}
