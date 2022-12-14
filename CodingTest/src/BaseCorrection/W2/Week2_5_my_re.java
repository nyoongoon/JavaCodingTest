package BaseCorrection.W2;

public class Week2_5_my_re {
    public static void main(String[] args) {
        Week2_5_my w = new Week2_5_my();
        int[][] image = {{4, 5, 2, 6, 7},
                {5, 4, 2, 4, 6},
                {6, 8, 4, 8, 7},
                {7, 3, 6, 6, 4},
                {5, 0, 4, 1, 5}};
        int[][] result = w.solution(image, 3);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }


    public int[][] solution(int[][] image, int K) {

        return null;
    }
}
