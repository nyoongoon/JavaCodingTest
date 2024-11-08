package _0_Theory.Chapter4_Algorithm._03_기수_계수_셸_정렬.src;// 셸 정렬

import java.util.Arrays;

public class Main3 {

    public static void shellSort(int[] arr) {
        int gap = arr.length / 2; //셸정렬은 초기 갭이 필 -> 보통 배열길이/2

        for (int g = gap; g > 0; g /= 2) { //갭을 절반씩 줄이면서 루프
            for (int i = g; i < arr.length; i++) {
                int tmp = arr[i];
                // 갭 간격으로 삽입정렬을 한다
                int j = 0;
                for (j = i - g; j >= 0; j -= g) {
                    if (arr[j] > tmp) {
                        arr[j + g] = arr[j];
                    } else {
                        break;
                    }
                }
                arr[j + g] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {10, 32, 52, 27, 48, 17, 99, 56};
        shellSort(arr);
        System.out.println("셸 정렬: " + Arrays.toString(arr));
    }
}
