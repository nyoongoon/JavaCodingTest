package Base_Algorithm;

public class MakeZero_re_14_1_2 {

    public static void solution(int[][] matrix) {
        boolean isFirstRowZero = false;
        boolean isFirstColZero = false;

        for (int i = 0; i < matrix.length; i++) { //row
            for (int j = 0; j < matrix[i].length; j++) { //col
                if(matrix[i][j] == 0){
                    if(i == 0) isFirstRowZero = true;
                    if(j == 0) isFirstColZero = true;

                    // 해당 지점의 맨 처음 row 임시로 0으로 지정
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
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

        if(isFirstRowZero){
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

        if(isFirstColZero){
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
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
