package _0_Theory.Chapter4_Algorithm._06_이진탐색_연습문제.src;// Practice
// 원형 정렬 상태 배열에서의 이진 탐색
// nums 배열에 원형 상태로 데이터가 정렬되어 있을 때,
// 이진 탐색으로 데이터를 찾는 프로그램을 작성하세요.
// O(log n) 유지
// 배열을 재 정렬하지 않고 풀기

// 입출력 예시
// arr: 4, 5, 6, 7, 8, 0, 1, 2

// arr:  8, 0, 1, 2, 4, 5, 6, 7,

// target: 0
// 출력: 5

// target: 3
// 출력: -1

public class Practice2 {
    public static int solution(int[] arr, int target) {
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
                minIdx = i;
            }
        }

        if (minIdx == 0) {
            return binarySearch(arr, target, 0, arr.length);
        }

        int resultByLeft = binarySearch(arr, target, 0, minIdx - 1);
        System.out.println("resultByLeft == " + resultByLeft);
        int resultByRight = binarySearch(arr, target, minIdx, arr.length - 1);
        System.out.println("resultByRight == " + resultByRight);

        return resultByLeft != -1 ? resultByLeft : resultByRight;
    }

    public static int binarySearch(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return binarySearch(arr, target, mid + 1, right);
        } else { // target < arr[mid]
            return binarySearch(arr, target, left, mid - 1);
        }
    }

    public static void main(String[] args) {
        // Test code
        int[] nums = {4, 5, 6, 7, 8, 0, 1, 2};
        System.out.println(solution(nums, 0));  // 5
        System.out.println(solution(nums, 3));  // -1
    }
}
