package _3_프로그래머스_코딩_테스트_문제_풀이_전략_자바편._1_배열;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 암기 포인트
 * 1. Set 에서의 동등 비교 -> equals & hashCode
 * 2. 나누어 떨어지지 않는 수 비교 -> 분모 분자 각각 체크 (나눠보기 전에)
 */
public class _1_교점에_별_만들기_책풀이 {
    public static void main(String[] args) {
        int[] arr1 = {1, 0};
        int[] arr2 = {1, 0};
        Set<int[]> set = new HashSet<>();
        set.add(arr1);
        set.add(arr2);
        System.out.println(set.size());

//        int[][] line = {{0, 1, -1}, {1, 0, -1}, {1, 0, 1}};
//        Solution s = new Solution();
//        s.solution(line);
    }
    static class Solution {


    }
}
