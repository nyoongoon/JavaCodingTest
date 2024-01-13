package _Theory.Chapter2_Linear._02_배열_연습문제.src;// Practice5
// 배열 arr 의 값을 오름차순으로 출력

// 입출력 예시)
// arr: 5, 3, 1, 4, 6, 1
// 결과: 1, 1, 3, 4, 5, 6

import java.util.Arrays;

public class Practice5_re {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 1, 4, 6, 1};
        int[] sorted = Arrays.stream(arr).sorted().toArray();

        System.out.println(Arrays.toString(sorted));
    }


}
