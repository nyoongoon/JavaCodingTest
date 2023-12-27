package _Theory.Chapter1_Math.Math_03.src;// 기초 수학 - 경우의 수

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
        System.out.println(nA + nB - nAandB);


        // HashSet 이용
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        HashSet<ArrayList<Integer>> set1 = new HashSet<>();
        HashSet<ArrayList<Integer>> set2 = new HashSet<>();
        for (int itemA : dice1) {
            for (int itemB : dice2) {
                if ((itemA + itemB) % 3 == 0) {
//                if ((itemA + itemB) % 3 == 0 || (itemA + itemB) % 4 == 0) { //이렇게 분리하여 푸는 것이 맞음 -> list 요소 셋으로 구별 가능 확인했음.
                    ArrayList<Integer> list = new ArrayList(Arrays.asList(itemA, itemB));

                    set.add(list);
                    set1.add(list);
                }
                if((itemA + itemB) % 4 == 0){
                    ArrayList<Integer> list = new ArrayList(Arrays.asList(itemA, itemB));

                    set.add(list);
                    set2.add(list);
                }
            }
        }

//        for (ArrayList<Integer> al : set){
//            for(int n : al){
//                System.out.print(n + ", ");
//            }
//            System.out.println();
//        }

        System.out.println("결과 == " + set.size()); ///// ==> 이상한 것 같은데..? 해시라서 교집합을 뺐다고 헀는데 아에 들어가는 경우가 없는거 아닌가..?
        for(ArrayList<Integer> list : set){
            for (int n : list){
                System.out.print(n + ", ");
            }
            System.out.println();
        }
        System.out.println("결과 set1 == " + set1.size()); ///// ==> 이상한 것 같은데..? 해시라서 교집합을 뺐다고 헀는데 아에 들어가는 경우가 없는거 아닌가..
        for(ArrayList<Integer> list : set1){
            for (int n : list){
                System.out.print(n + ", ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("결과 set2 == " + set2.size()); ///// ==> 이상한 것 같은데..? 해시라서 교집합을 뺐다고 헀는데 아에 들어가는 경우가 없는거 아닌가..
        for(ArrayList<Integer> list : set2){
            for (int n : list){
                System.out.print(n + ", ");
            }
            System.out.println();
        }
//      2. 곱의 법칙
        System.out.println("== 곱의 법칙 ==");
//      두 개의 주사위 a, b를 던졌을 때 a는 3의 배수, b는 4의 배수인 경우의 수
        nA = 0;
        nB = 0;
        for(int itemA : dice1){
            nA += 1;
        }

        for(int itemA : dice2){
            nB += 1;
        }

        System.out.println("곱의 법칙 결과  == " + (nA * nB));

    }
}
