package _0_Theory.Chapter4_Algorithm._06_이진탐색_연습문제.src;// Practice3
// 2차원 행렬에서 이진 탐색으로 데이터 찾기
// row x col 행렬 데이터가 주어졌을 때, target 을 이진 탐색으로 찾는 프로그램을 작성하세요.
// 각 행의 데이터는 오름차순으로 정렬 상태

// 입출력 예시
// 행렬: {{1, 3, 7, 8}, {10, 11, 15, 20}, {21, 30, 35, 60}}

// target: 3
// 출력: true

// target: 13
// 출력: false

public class Practice3 {
    public static boolean solution(int[][] matrix, int target) {
        int[] arr = new int[matrix.length * matrix[0].length];
        int idx = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                arr[idx++] = matrix[i][j];
            }
        }

        int result = binarySearch(arr, target, 0, arr.length - 1);


        return result == -1 ? false : true;
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
        } else { // arr[mid] > target
            return binarySearch(arr, target, left, mid - 1);
        }
    }

    public static void main(String[] args) {
        // Test code
        int[][] matrix = {{1, 3, 7, 8}, {10, 11, 15, 20}, {21, 30, 35, 60}};
        System.out.println(solution(matrix, 3));    // true
        System.out.println(solution(matrix, 13));   // false
        System.out.println(solution(matrix, 35));   // true
    }
}
