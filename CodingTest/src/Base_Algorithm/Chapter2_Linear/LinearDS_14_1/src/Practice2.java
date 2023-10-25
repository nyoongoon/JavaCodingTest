package Base_Algorithm.Chapter2_Linear.LinearDS_14_1.src;

import java.util.HashSet;

public class Practice2 {

    public static int[][] solution(int[][] matrix) { // m X n
        HashSet<Integer> setM = new HashSet<>();
        HashSet<Integer> setN = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0){
                    setM.add(i);
                    setN.add(j);
                }
            }
        }

        for(int i : setM){
            makeRowToZero(matrix, i);
        }

        for (int j : setN){
            makeColToZero(matrix, j);
        }

        return matrix;
    }
    public static void makeRowToZero(int[][] matrix, int i){
        for (int j = 0; j < matrix[i].length; j++) {
            matrix[i][j] = 0;
        }
    }

    public static void makeColToZero(int[][] matrix, int j){
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][j] = 0;
        }
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
