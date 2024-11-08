package _0_Theory.Chapter4_Algorithm._01_버블_삽입_선택_정렬.src;// 알고리즘 - 정렬_1

import java.util.Arrays;

public class Main_ans { //정답 코드 블로그에 옮기기... -> 버블, 삽입, 선택 조금씩 헷갈리긴함 한 줄 설명 추가하여 올리기

    // 오름차순 기준 정렬 알고리즘

    // 버블 정렬 -> 버블정렬은 비교 시 인덱스 증가시키며 정렬..
    public static void bubbleSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) { // 횟수
            for (int j = 0; j < arr.length - i; j++) { //인덱스
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    // 삽입 정렬 -> 삽입정렬은 비교 시 인덱스 감소시키며 정렬..
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) { // 범위
            for (int j = i; j > 0; j--) { // j-1이 같거나 크면 멈춤
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }

    // 선택 정렬
    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) { //선택 위치
            int minIdx = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[minIdx] > arr[j]) { // minIdx 구하기
                    minIdx = j;
                }
            }
            swap(arr, i, minIdx);
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {3, 5, 2, 7, 1, 4};
        bubbleSort(arr);
        System.out.println("버블 정렬: " + Arrays.toString(arr));

        arr = new int[]{3, 5, 2, 7, 1, 4};
        insertionSort(arr);
        System.out.println("삽입 정렬: " + Arrays.toString(arr));

        arr = new int[]{3, 5, 2, 7, 1, 4};
        selectionSort(arr);
        System.out.println("선택 정렬: " + Arrays.toString(arr));

    }
}
