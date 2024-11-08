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

public class Practice2_ans {
    public static int solution(int[] arr, int target) {
        return binarySearch(arr, target, 0, arr.length - 1);
    }

    public static int binarySearch(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;

        if (arr[mid] == target) {
            return mid;
        }

        if (arr[left] <= arr[mid]) { // mid 이하가 정렬되어있을 때  ex)  3 4 5 6 7 8 9 1 2
            if (arr[left] <= target && target < arr[mid]) { // 타겟이 arr[left]보다는 크거나 같고 정렬되어 있는 부분에 target이 있는가?
                return binarySearch(arr, target, left, mid - 1);
            } else {
                return binarySearch(arr, target, mid + 1, right);
            }

        } else { //mid 이상이 정렬되어 있을 때  ex) 8 9 1 2 3 4 5 6 7
            if (target <= arr[right] && arr[mid] < target) { // 타겟이 arr[right] 보다는 작거나 같고 정렬되어 있는 부분에 target이 있는가?
                return binarySearch(arr, target, mid + 1, right);
            } else {
                return binarySearch(arr, target, left, mid - 1);
            }
        }
    }

    public static void main(String[] args) {
        // Test code
        int[] nums = {4, 5, 6, 7, 8, 0, 1, 2};
        System.out.println(solution(nums, 0));  // 5
        System.out.println(solution(nums, 3));  // -1
    }
}
