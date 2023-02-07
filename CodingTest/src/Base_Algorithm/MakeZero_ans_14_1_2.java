package Base_Algorithm;

public class MakeZero_ans_14_1_2 {

    public static void solution(int[][] matrix) {
        // 매트릭스 한번 순회하고
        // 0값이 있는 경우 해당 [i][0], [0][j] (외곽)에 0으로 임시 표시
        // 다시 순회하면서 외곽에 0 인값 0처리
        // 외곽 불리언 체크로 외곽 처리.
        boolean frZero = false;
        boolean fcZero = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0){
                    if( i == 0){
                        frZero = true; // 외곽일경우
                    }

                    if( j == 0){
                        fcZero = true; // 외곽일경우
                    }
                    // 현재 위치를 매트리스 상의 외곽으로 생각하기
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        //행렬의 하나 안쪽부터 각각의 원소들을 비교해보면서 0으로 바꿔주기
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(frZero){ // => 외곽 row에 0이 있었나?
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }

        if(fcZero){ //=> 외곽 col에 0이 있었나?
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[i][0] = 0;
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
