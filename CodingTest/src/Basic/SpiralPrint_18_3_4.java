package Basic;

import java.util.ArrayList;

public class SpiralPrint_18_3_4 {
    public static ArrayList<Integer> solution(int[][] matrix) {
        ArrayList<Integer> al = new ArrayList<>();
        int rowIdx = 0;
        int colIdx = 0;


        while (matrix[rowIdx][colIdx] != -1) {
            //col++
            while (colIdx < matrix[rowIdx].length && matrix[rowIdx][colIdx] != -1) {
                al.add(matrix[rowIdx][colIdx]);
                matrix[rowIdx][colIdx] = -1;
                colIdx++;
            }
            //row++
            colIdx--;
            rowIdx++;

            while (rowIdx < matrix.length && matrix[rowIdx][colIdx] != -1) {
                al.add(matrix[rowIdx][colIdx]);
                matrix[rowIdx][colIdx] = -1;
                rowIdx++;
            }
            rowIdx--;
            colIdx--;
            //col--
            // System.out.println(rowIdx);
            while (colIdx >= 0 && matrix[rowIdx][colIdx] != -1) {
                al.add(matrix[rowIdx][colIdx]);
                matrix[rowIdx][colIdx] = -1;
                colIdx--;
            }//row++
            colIdx++;
            rowIdx--;
            while (rowIdx >= 0 && matrix[rowIdx][colIdx] != -1) {
                al.add(matrix[rowIdx][colIdx]);
                matrix[rowIdx][colIdx] = -1;
                rowIdx--;
            }
            rowIdx++;
            colIdx++;

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
