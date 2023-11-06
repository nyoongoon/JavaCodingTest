package Base_Algorithm.Chapter2_Linear.LinearDS_14_1.src;

import java.util.HashSet;

public class Practice2_ans {

    public static int[][] solution(int[][] matrix) { // m X n
        boolean frZero = false;
        boolean fcZero = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0){
                    if(i == 0){
                        frZero = true;
                    }
                    if(j == 0){
                        fcZero = true;
                    }
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(frZero){
            for (int j = 0; j <matrix.length ; j++) {
                matrix[0][j] = 0;
            }
        }
        if(fcZero){
            for (int i = 0; i <matrix.length ; i++) {
                matrix[i][0] = 0;
            }
        }
        return matrix;
    }



    public static void main(String[] args) {
        // Test code
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        printArr(solution(matrix));

        System.out.println();
        matrix = new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        printArr(solution(matrix));
    }


    public static void printArr(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
