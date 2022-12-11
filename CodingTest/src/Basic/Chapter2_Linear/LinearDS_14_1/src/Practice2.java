package LinearDS_14_1.src;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Practice2 {
    static int cnt =0;

    public static void solution(int[][] matrix) {
        HashMap<Integer, Integer> rowMap = new HashMap<>();
        HashMap<Integer, Integer> colMap = new HashMap<>();

        for (int i = 0; i < matrix.length; i++) {
            //col == 0 일때
            if(matrix[i][0] == 0){
                rowMap.put(i, 0);
                //makeZero(matrix, i, 0);
                continue;
            }
            rowMap.put(i, 1);
        }

        for(Integer row : rowMap.keySet()){
            int rowNum = rowMap.get(row);
            if(rowNum == 0){
                makeZero(matrix, rowNum, 0);
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            //row == 0 일때
            if(matrix[0][i] == 0){
                colMap.put(i, 0);
                //makeZero(matrix, 0, i);
                continue;
            }
            colMap.put(i, 1);
        }

        for(Integer col : colMap.keySet()){
            int colNum = colMap.get(col);
            if(colNum == 0){
                makeZero(matrix, 0, colNum);
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        LinkedList<int[]> zeroVal = new LinkedList<>();

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0){
                    // 체크
                    //zeroVal.add(new int[] {i, j});
                    if(rowMap.get(i) != 0){
                        zeroVal.add(new int[] {i, j});
                    }
                    if(colMap.get(j) != 0){
                        zeroVal.add(new int[] {i, j});
                    }
                }
            }
        }

        for (int i = 0; i < zeroVal.size(); i++) {
            int row = zeroVal.get(i)[0];
            int col = zeroVal.get(i)[1];
            makeZero(matrix, row, col);
        }

        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("ctn == " + cnt);
        System.out.println();System.out.println();System.out.println();


    }

    public static void makeZero(int[][] matrix, int row, int col){
        cnt++;
        for (int i = 0; i < matrix.length; i++) {
            matrix[row][i] = 0;
        }

        for (int i = 0; i < matrix[0].length; i++) {
            matrix[i][col] = 0;
        }

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
