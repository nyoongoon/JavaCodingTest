package _Theory.Chapter4_Algorithm._06_이진탐색_연습문제.src;// Practice4
// 정수형 배열 weights 와 정수 days 가 주어졌다.
// weights 에는 각 상품의 무게들의 정보가 들어있고, days 는 운송 납기일이다.
// 상품들은 weights 에 적혀있는 순서대로 실어서 운송해야 하는데,
// days 이내에 운송을 하기 위한 차량의 최소한의 적재량을 계산하는 프로그램을 작성하세요.

// 입출력 예시
// weights: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
// days: 5
// 출력: 15

// weights: 3, 2, 2, 4, 1, 4
// days: 3
// 출력: 6


public class Practice4 { // todo 문제를 모르겠음..
    public static int solution(int[] weights, int days) {
        quickSort(weights, 0, weights.length - 1);
        int sum = 0;
        for (int i = 0; i < days; i++) {

        }
        return 0;
    }

    public static void main(String[] args) {
        // Test code
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(solution(weights, 5));   // 15

        weights = new int[]{3, 2, 2, 4, 1, 4};
        System.out.println(solution(weights, 3));   // 6
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = left;
        int lo = left;
        int hi = right;

        while (lo < hi) {
            if (arr[pivot] < arr[hi] && lo < hi) {// arr[hi]가 arr[pivot]보다 작거나 같은 것 찾기
                hi--;
            } else if (arr[pivot] >= arr[lo] && lo < hi) {
                lo++;
            } else {
                swap(arr, lo, hi);
            }
        }

        swap(arr, lo, pivot);
        return pivot;
    }

    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }

        int pivot = partition(arr, left, right);
        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }
}
