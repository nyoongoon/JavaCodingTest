package _Theory.Chapter4_Algorithm._06_이진탐색_연습문제.src;// Practice3
// 2차원 행렬에서 이진 탐색으로 데이터 찾기
// row x col 행렬 데이터가 주어졌을 때, target 을 이진 탐색으로 찾는 프로그램을 작성하세요.
// 각 행의 데이터는 오름차순으로 정렬 상태

// 입출력 예시
// 행렬: {{1, 3, 7, 8}, {10, 11, 15, 20}, {21, 30, 35, 60}}

// target: 3
// 출력: true

// target: 13
// 출력: false

public class Practice3_ans {
    public static boolean solution(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int result = binarySearch(matrix, target, 0, rows * cols);


        return result == -1 ? false : true;
    }

    public static int binarySearch(int[][] matrix, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int cols = matrix[0].length;
        int mid = (left + right) / 2;
        /**
         * 2차원 배열을 1차원 배열의 인덱스로 처리하는 방법
         * -> 1차원 배열의 마지막 인덱스 = matrix.length * matrix[0].length
         * -> 2차원 배열의 row = 1차원 배열의 인덱스 / matrix[0].length의 길이 (몫)
         * -> 2차원 배열의 col = 1차원 배열의 인덱스 % matrix[0].length의 길이 (나머지)
         */
        if (matrix[mid / cols][mid % cols] == target) {
            return target;
        } else if (target < matrix[mid / cols][mid % cols]) {
            return binarySearch(matrix, target, left, mid - 1);
        } else { // matrix[mid / cols][mid % cols] < target
            return binarySearch(matrix, target, mid + 1, right);
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
