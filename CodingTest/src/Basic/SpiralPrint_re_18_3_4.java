package Basic;

import java.util.ArrayList;

public class SpiralPrint_re_18_3_4 {
    public static ArrayList<Integer> solution(int[][] matrix) {
        ArrayList<Integer> al = new ArrayList<>();
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {
            for (int i = startCol; i <= endCol; i++) {
                al.add(matrix[startRow][i]);
            }
            //endCol--;
            startRow++;
            for (int i = startRow; i <= endRow; i++) {
                al.add(matrix[i][endCol]);
            }
            endCol--;

            if(startRow <= endRow) { // 기준 주의 !!! <<<--- 이해 안감 !!!
                for (int i = endCol; i >= startCol; i--) {
                    al.add(matrix[endRow][i]);
                }
            }
            endRow--;

            if(startCol <= endCol){
                for (int i = endRow; i >= startRow; i--) {
                    al.add(matrix[i][startCol]);
                }
            }

            startCol++;
        }


        return al;
    }

    public static void main(String[] args) {
        // Test code
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println((solution(matrix)));

        matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println((solution(matrix)));
    }
}
