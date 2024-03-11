package _Theory.Chapter3_NonLinear._15_비선형자료구조_연습문제_1.src;

import java.util.*;

public class Practice4_ans {

    public static int solution(String[] deadends, String target) {
        return 0;
    }


    public static void main(String[] args) {
        // Test code
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        System.out.println(solution(deadends, "0202"));

        deadends = new String[]{"8888"};
        System.out.println(solution(deadends, "0009"));

    }

    public static class Lock {
        int[] arr;
        int moves;

        public Lock(int[] arr, int moves) {
            this.arr = arr;
            this.moves = moves;
        }
    }
}
