package Base_Algorithm.Chapter2_Linear;

public class Linear_TEST_02_05 {

    public static void main(String[] args) {
        int[][] image = {
                        {4, 5, 2, 6, 7},
                        {5, 4, 2, 4, 6},
                        {6, 8, 4, 8, 7},
                        {7, 3, 6, 6, 4},
                        {5, 0, 4, 1, 5}};
        int K = 3;

        printTwoDimensionArr(solution(image, K));
    }

    public static int[][] solution(int[][] image, int K) {
        int[][] resultTwoDimension = new int[image.length][image[0].length];
        int row = -1;
        int col = 0;
        int sum = start(image, row, col, K);
        System.out.println("sum == " + sum);

        // go ... 할때 자르고 더하는 로우 및 칼럼이 한 칸 씩 더 차이나야함...
        for (int i = 0; i < image.length; i++) {
            row += 1;
            sum = goDown(image, row, col, sum, K);

            resultTwoDimension[row][col] = sum/9;

            for (int j = 0; j < image[i].length - 1; j++) {
                if (i % 2 == 0) { //짝 goRight
                    col += 1;
                    sum = goRight(image, row, col, sum, K);

                    resultTwoDimension[row][col] = sum/9;
                } else { // 홀..
                    col -= 1;
                    sum = goLeft(image, row, col, sum, K);

                    resultTwoDimension[row][col] = sum/9;
                }
            }
        }

        return resultTwoDimension;
    }

    public static int goRight(int[][] intArr, int row, int col, int sum, int K) {
        for (int i = -K / 2; i <= K / 2; i++) {
            sum -= getValue(intArr, row + i, col - 2);
            sum += getValue(intArr, row + i, col + 1);
        }

        return sum;
    }

    public static int goLeft(int[][] intArr, int row, int col, int sum, int K) {
        for (int i = -K / 2; i <= K / 2; i++) {
            sum -= getValue(intArr, row + i, col + 2);
            sum += getValue(intArr, row + i, col - 1);
        }
        return sum;
    }

    public static int goDown(int[][] intArr, int row, int col, int sum, int K) {
        // 1 2 3 4
        // 4 5 6 7   5-> row:1 col:1
        // 7 8 9 10
        // 11121314
        for (int i = -K / 2; i <= K / 2; i++) {
            sum -= getValue(intArr, row - 2, col + i);
            sum += getValue(intArr, row + 1, col + i);
        }
        return sum;
    }


    public static int start(int[][] intArr, int row, int col, int K) {
        int sum = 0;
        for (int i = row - K / 2; i <= row + K / 2; i++) {
            for (int j = col - K / 2; j <= col + K / 2; j++) {
                sum += getValue(intArr, i, j);
            }
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




