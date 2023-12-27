package _Theory.Chapter2_Linear.LinearDS_03.src;// Practice6
// 배열 arr 에서 중복 값을 제거한 새 배열을 만드시오.

// 입출력 예시)
// arr: 1, 5, 3, 2, 2, 3, 1, 4, 1, 2, 3, 5
// 결과: 1, 5, 3, 2, 4

import java.util.Arrays;

public class Practice6_re {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 5, 3, 2, 2, 3, 1, 4, 1, 2, 3, 5};
        int[] distinctArr = Arrays.stream(arr).distinct().toArray();
        System.out.println(Arrays.toString(distinctArr));

    }
}
