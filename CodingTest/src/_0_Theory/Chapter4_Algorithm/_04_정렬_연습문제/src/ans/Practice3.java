package _0_Theory.Chapter4_Algorithm._04_정렬_연습문제.src.ans;// Practice3
// intervals 라는 구간으로 이루어진 배열이 주어졌을 때,
// 오버랩 되는 구간을 합치는 프로그램을 작성하세요.

// 입출력 예시
// 입력: [2, 6], [1, 3], [15, 18], [8, 10]
// 출력: [1, 6] [8, 10] [15, 18]

// 1, 3 |  2, 6  |  8, 10 | 15, 18

import java.util.ArrayList;
import java.util.Arrays;

public class Practice3 { // todo 정답이 틀린것 같아서 다시 풀어보기 -> 정렬시 int arr [1]도 함께 비교되어야하는 거 같음. 아니면 합칠때 max비교라도
    // --> 틀린 게 맞네..

    public static ArrayList<int[]> solution(int[][] intervals) {
        ArrayList<int[]> result = new ArrayList<>();
        sort(intervals);


        System.out.println("======= sorted =========");
        for(int[] arr : intervals){
            System.out.println(Arrays.toString(arr));
        }


        int[] cur = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (cur[1] >= intervals[i][0]) {
                // 정답 틀린것 고친 부분..
//                cur[1] = intervals[i][1];
                cur[1] = Math.max(cur[1], intervals[i][1]);
            } else {
                result.add(cur);
                cur = intervals[i];
            }
        }
        result.add(cur);
        return result;
    }

    public static void sort(int[][] intervals) { //퀵정렬
        quickSort(intervals, 0, intervals.length - 1);
    }

    public static void quickSort(int[][] intervals, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = partition(intervals, left, right);
        quickSort(intervals, left, pivot - 1);
        quickSort(intervals, pivot + 1, right);
    }

    public static int partition(int[][] arr, int left, int right) {
        int pivot = left;
        int lo = left;
        int hi = right;

        while (lo < hi) {
            if (arr[hi][0] > arr[pivot][0] && lo < hi) { //arr[pivot]보다 작거나 같은 것.
                hi--;
            } else if (arr[lo][0] <= arr[pivot][0] && lo < hi) { //arr[pivot] 보다 큰 것.
                lo++;
            } else {
                swap(arr, hi, lo);
            }
        }

        swap(arr, lo, pivot);
        return pivot;
    }

    public static void swap(int[][] arr, int a, int b) {
        int[] tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }


    public static void main(String[] args) {
        // Test code
        int[][] intervals = {{2, 6}, {1, 3}, {15, 18}, {8, 10}};

        for (int[] item : solution(intervals)) {
            System.out.print(Arrays.toString(item) + " ");
        }
        System.out.println();

        int[][] intervals2 = {{1, 2}, {1, 3}, {15, 18}, {8, 10}};

        for (int[] item : solution(intervals2)) {
            System.out.print(Arrays.toString(item) + " ");
        }
        System.out.println();

    }
}
