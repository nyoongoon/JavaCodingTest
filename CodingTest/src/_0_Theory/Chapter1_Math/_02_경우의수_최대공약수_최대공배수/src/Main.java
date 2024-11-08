package _0_Theory.Chapter1_Math._02_경우의수_최대공약수_최대공배수.src;// 기초 수학 - 경우의 수

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
//      1. 합의 법칙
        System.out.println("== 합의 법칙 ==");
//      두 개의 주사를 던졌을 때 합이 3 또는 4의 배수일 경우의 수

        int[] dice1 = {1, 2, 3, 4, 5, 6};
        int[] dice2 = {1, 2, 3, 4, 5, 6};

        int nA = 0;
        int nB = 0;
        int nAandB = 0;

        // 기본 풀이
        for (int itemA : dice1) {
            for (int itemB : dice2) {
                if ((itemA + itemB) % 3 == 0) {
                    nA++;
                }
                if ((itemA + itemB) % 4 == 0) {
                    nB++;
                }
                if ((itemA + itemB) % 12 == 0) {
                    nAandB++;
                }
            }
        }
        System.out.println("합의 법칙 결과  == " + (nA + nB - nAandB)); // n(A U B) = n(A) + n(B) - n(A 교집합 B)

        // HashSet 이용
        //List<ArrayList> al = new ArrayList<>(); list와 hash 비교를 위함 -> 이 경우에선 필요 없었음..
        HashSet<ArrayList> allCase = new HashSet<>();
        for (int item1 : dice1) {
            for (int item2 : dice2) {
                if ((item1 + item2) % 3 == 0 || (item1 + item2) % 4 == 0) {
                    ArrayList list = new ArrayList(Arrays.asList(item1, item2));
                    allCase.add(list);
//                    System.out.println(Arrays.toString(list.toArray()));
//                    al.add(list);
                }
            }
        }
//        System.out.println("al.size() == " + al.size()); 이 경우에선 중복 경우 없긴 함..
        // * 그런데 ||  비교를 통해서 중복 제거를 했다고 보는 게 더 타당하지 않을까..?
        System.out.println("합의 법칙 결과  == " + allCase.size());


//      2. 곱의 법칙
        System.out.println("== 곱의 법칙 ==");
//      두 개의 주사위 a, b를 던졌을 때 a는 3의 배수, b는 4의 배수인 경우의 수
        nA = 0;
        nB = 0;
        for (int item1 : dice1) {
            if (item1 % 3 == 0) {
                nA++;
            }
        }

        for (int item2 : dice2) {
            if (item2 % 4 == 0) {
                nB++;
            }
        }
        System.out.println("곱의 법칙 결과  == " + (nA * nB));
    }
}
