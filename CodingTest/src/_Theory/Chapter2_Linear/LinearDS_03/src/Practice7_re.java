package _Theory.Chapter2_Linear.LinearDS_03.src;// Practice7
// 2차원 배열 arr 을 시계방향 90도 회전시킨 결과를 출력하세요.

// 입출력 예시:
// arr:
// 1 2 3 4 5       1 -> (0,0) => (0, 2)  2-> (0,1) => (1, 2)  3-> (0,2) =? (2, 2)
// 6 7 8 9 10
// 11 12 13 14 15   11 -> (2,0) =>  (0,0)
// 결과:
// 11 6 1
// 12 7 2
// 13 8 3
// 14 9 4
// 15 10 5


import java.util.Arrays;

public class Practice7_re {
    public static void main(String[] args) {
        // arr:
// 1 2 3 4 5
// 6 7 8 9 10
// 11 12 13 14 15
        int[][] arr = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}
        };

        int[][] newArr = new int[arr[0].length][arr.length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                newArr[j][arr.length - 1 - i] = arr[i][j];
            }
        }

        for (int i = 0; i < newArr.length; i++) {
            for (int j = 0; j < newArr[0].length; j++) {
                System.out.print(newArr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
