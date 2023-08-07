package Base_Algorithm.Chapter2_Linear.LinearDS_03.src;// Practice3
// 배열 arr 의 데이터 순서를 거꾸로 변경하세요.
// 추가 배열을 사용하지 않고 구현

// 입출력 예시)
// arr: 1, 3, 5, 7, 9
// 결과: 9, 7, 5, 3, 1

import java.util.Arrays;

public class Practice3_re {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 7, 9};

        reverseArr(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void reverseArr(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            swap(arr, i, arr.length - 1 - i);
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
