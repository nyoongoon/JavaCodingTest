package _0_Theory.Chapter1_Math._08_기초수학_연습문제_1.src;

import java.util.ArrayList;

public class Practice1_my {
    public static ArrayList<ArrayList<Integer>> solution(int numRows) {
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> al = new ArrayList<>();
            if (i == 0) {
                al.add(1);
                resultList.add(al);
                continue;
            }

            al.add(1);
            for (int j = 0; j < i - 1; j++) {
                ArrayList<Integer> preList = resultList.get(i - 1);
                al.add(preList.get(j) + preList.get(j + 1));
            }
            al.add(1);
            resultList.add(al);
        }

        return resultList;
    }


    public static void main(String[] args) {
        // Test code
        System.out.println(solution(1));
        System.out.println(solution(2));
        System.out.println(solution(3));
        System.out.println(solution(4));
        System.out.println(solution(5));
    }
}
