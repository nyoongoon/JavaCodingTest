package Base_CodingTest.W2;

public class Week2_5_my {
    public static void main(String[] args) {
        Week2_5_my w = new Week2_5_my();
        int[][] image = {{4, 5, 2, 6, 7},
                {5, 4, 2, 4, 6},
                {6, 8, 4, 8, 7},
                {7, 3, 6, 6, 4},
                {5, 0, 4, 1, 5}};
        int[][] result = w.solution(image, 3);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length ; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }


    public int[][] solution(int[][] image, int K) {
        int [][] result = image.clone();
        int row = 0;
        int col = 0;
        int sum = start(image, K); // 구해야함.
        System.out.println(sum);
        result[row][col] = sum/9;

        while (row != image.length - 1 || col != image[row].length - 1) {
            System.out.println(row + ", " + col);
            if (row % 2 == 0) {
                if (col == image[row].length - 1) {
                    row += 1;
                    sum = down(image, K, row, col, sum);
                    System.out.println("sum == " + sum);
                    result[row][col] = sum/9;
                } else {
                    col+=1;
                    sum = right(image, K, row, col, sum);
                    System.out.println("sum == " + sum);
                    result[row][col] = sum/9;
                }
            } else {
                if (col == 0) {
                    row+=1;
                    sum = down(image, K, row, col, sum);
                    System.out.println("sum == " + sum);
                    result[row][col] = sum/9;
                } else {
                    col-=1;
                    sum = left(image, K, row, col, sum);
                    System.out.println("sum == " + sum);
                    result[row][col] = sum/9;
                }
            }
        }
        return result;
    }

    public int right(int[][] images, int K, int row, int col, int sum) {
        int range = K / 2;
        for (int i = row - range; i <= row + range; i++) {
            int j = col - range;
            if (i >= 0 && i < images.length && j >= 0) {
                sum -= images[i][j];
            }
            int k = col + range;
            if (i >= 0 && i < images.length && k < images[i].length) {
                sum += images[i][k];
            }
        }
        return sum;
    }

    public int left(int[][] images, int K, int row, int col, int sum) {
        int range = K / 2;
        for (int i = row - range; i <= row + range; i++) {
            int j = col - range;
            if (i >= 0 && i < images.length && j >= 0) {
                sum += images[i][j];
            }
            int k = col + range;
            if (i >= 0 && i < images.length && k < images[i].length) {
                sum -= images[i][k];
            }
        }
        return sum;
    }

    public int down(int[][] images, int K, int row, int col, int sum) {
        int range = K / 2;
        for (int i = col - range; i <= col + range; i++) {
            int j = row - range;
            if (i >= 0 && i < images.length && j >= 0) {
                sum -= images[j][i];
            }
            int k = row + range;
            if (i >= 0 && i < images.length && k < images[i].length) {
                sum += images[k][i];
            }
        }
        return sum;
    }

    public int start(int[][] images, int K) {
        int sum = 0;
        int range = K / 2;
        for (int i = -range; i <= range; i++) {
            for (int j = -range; j <= range; j++) {
                if (i >= 0 && i < images.length && j >= 0 && j < images[i].length) {
                    sum += images[i][j];
                }
            }
        }
        return sum;
    }


}
