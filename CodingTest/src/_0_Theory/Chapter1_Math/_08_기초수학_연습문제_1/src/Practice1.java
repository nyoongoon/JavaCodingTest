package _0_Theory.Chapter1_Math._08_기초수학_연습문제_1.src;

import java.util.ArrayList;

public class Practice1 {
    public static ArrayList<ArrayList<Integer>> solution(int numRows) {
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> al = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    al.add(1);
                } else {
                    int cur = resultList.get(i - 1).get(j - 1) + resultList.get(i - 1).get(j);
                    al.add(cur);
                }
            }
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
