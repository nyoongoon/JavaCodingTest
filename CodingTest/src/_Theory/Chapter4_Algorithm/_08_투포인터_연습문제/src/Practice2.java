package _Theory.Chapter4_Algorithm._08_투포인터_연습문제.src;// Practice
// nums1 과 nums2 두 배열이 주어졌을 때
// 두 배열의 공통 원소를 배열로 반환하는 프로그램을 작성하세요.
// 결과 배열의 원소에는 중복 값이 없도록 하며 순서는 상관 없다.

// 입출력 예시
// nums1: 1, 2, 2, 1
// nums2: 2, 2
// 출력: 2

// nums1: 4, 9, 5
// nums2: 9, 4, 9, 8, 4
// 출력: 4, 9 (or 9, 4)

import java.util.*;

public class Practice2 {
    public static int[] solution(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        int[] longger;
        int[] shortter;
        if(nums1.length > nums2.length){
            longger = nums1;
            shortter = nums2;
        }else{
            shortter = nums1;
            longger = nums2;
        }
        for(int n : longger){
            set.add(n);
        }

        for(int n : shortter){
            if(set.contains(n)){
                list.add(n);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        // Test code
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(solution(nums1, nums2)));

        nums1 = new int[]{4, 9, 5};
        nums2 = new int[]{9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(solution(nums1, nums2)));

        nums1 = new int[]{1, 7, 4, 9};
        nums2 = new int[]{7, 9};
        System.out.println(Arrays.toString(solution(nums1, nums2)));
    }
}
