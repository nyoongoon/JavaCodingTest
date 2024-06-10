package _Theory.Chapter4_Algorithm._06_이진탐색_연습문제.src;// Practice1
// 이진 탐색 추가 구현
// target 값이 arr 내에 있으면 해당 인덱스 반환
// 없으면 해당 값이 있을 경우의 위치에 -1을 곱하고 1을 뺀 값을 반환

// 입출력 예시
// 입력 arr: 1, 2, 5, 10, 20, 30, 40, 50, 60

// target: 30
// 출력: 5

// target: 3
// 출력: -3

public class Practice1 {
    public static int solution(int[] arr, int target) {
        return binarySearch(arr, target, 0, arr.length);
    }

    public static int binarySearch(int[] arr, int target, int left, int right) {
        if (left > right) {
            //항상 left가 대상인 이유 -> 재귀 끝나는 순간 -> right, left가 되고 사이에 값이 들어가야하므로 left자리가 대상값의 위치가 된다!
            return (left * -1) - 1;
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
        int[] arr = {1, 2, 5, 10, 20, 30, 40, 50, 60};
        System.out.println(solution(arr, 30));  // 5
        System.out.println(solution(arr, 3));   // -3
        System.out.println(solution(arr, 11));  // -5
        System.out.println(solution(arr, 35));  // -7
    }
}
