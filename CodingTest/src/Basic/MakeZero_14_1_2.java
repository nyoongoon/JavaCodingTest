package Basic;

import java.util.Arrays;
import java.util.LinkedList;

public class MakeZero_14_1_2 {

    public static void solution(int[][] matrix) { //시간복잡도 O(n^3) => 답안풀이 참고
        LinkedList<int[]> ll = new LinkedList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0){
                    ll.add(new int[]{i, j});
                }
            }
        }

        for (int i = 0; i < ll.size(); i++) {
            int[] result = ll.get(i);
            if(matrix[result[0]][result[1]] == 0){
                // matrix= makeZero(matrix, result[0], result[1]);
                makeZero(matrix, result[0], result[1]);
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] makeZero(int[][] matrix, int row, int col){
        for (int i = 0; i < matrix.length; i++) {
            matrix[row][i] = 0;
        }
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[i][col] = 0;
        }
        return matrix;
    }

    public static void main(String[] args) {
        // Test code
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        solution(matrix);

        System.out.println();
        matrix = new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        solution(matrix);
    }
}
