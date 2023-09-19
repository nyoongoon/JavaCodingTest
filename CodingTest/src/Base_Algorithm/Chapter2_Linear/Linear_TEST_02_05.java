package Base_Algorithm.Chapter2_Linear;

public class Linear_TEST_02_05 {

    public static void main(String[] args) {
        int[][] image = {{4, 5, 2, 6, 7},
                {5, 4, 2, 4, 6},
                {6, 8, 4, 8, 7},
                {7, 3, 6, 6, 4},
                {5, 0, 4, 1, 5}};
        int K = 3;

        printTwoDimensionArr(solution(image, K));

    }

    public static int[][] solution(int[][] image, int K) {
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                if (i % 2 == 0) { //짝
                    // row, col 어디서 + 시켜주지..?
                } else { // 홀..

                }
            }

        }

    }

    public static int goRight(int[][] intArr, int row, int col, int sum) {
        for (int i = -1; i <= 1; i++) {
            sum -= getValue(intArr, row + i, col - 1);
            sum += getValue(intArr, row + i, col + 1);
        }

        return sum;
    }

    public static int goLeft(int[][] intArr, int row, int col, int sum) {
        for (int i = -1; i <= 1; i++) {
            sum -= getValue(intArr, row + i, col + 1);
            sum += getValue(intArr, row + i, col - 1);
        }
        return sum;
    }

    public static int goDown(int[][] intArr, int row, int col, int sum) {
        // 123
        // 456   5-> row:1 col:1
        // 789
        for (int i = -1; i <= 1; i++) {
            sum -= getValue(intArr, row - 1, col + i);
            sum += getValue(intArr, row + 1, col + i);
        }
        return sum;
    }

    public static int getValue(int[][] intArr, int row, int col) {
        if (0 <= row && row < intArr.length && 0 <= col && col < intArr[row].length) {
            return intArr[row][col];
        }
        return 0;
    }

    public static void printTwoDimensionArr(int[][] intArr) {
        for (int i = 0; i < intArr.length; i++) {
            for (int j = 0; j < intArr[i].length; j++) {
                System.out.print(intArr[i][j] + " ");
            }
            System.out.println();
        }
    }

}




