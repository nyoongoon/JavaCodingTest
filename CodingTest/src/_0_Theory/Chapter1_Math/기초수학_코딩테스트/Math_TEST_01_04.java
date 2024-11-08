package _0_Theory.Chapter1_Math.기초수학_코딩테스트;

public class Math_TEST_01_04 {
    static int num = 1;
    static int[][] cal = new int[][]{{0, 0}, {0, -1}, {1, -1}, {1, 0}};

    public static int solution(int n, int i, int j) {
        num = 1;
        // n == 2, 4, 8, 16 ...
        //int endNum = n * n; //4, 16, 64, ...
        int[][] arr = new int[n][n];


        recur(arr, arr.length / 2, arr.length - 1, n / 2, "left");

        for (int k = 0; k < arr.length; k++) {
            for (int l = 0; l < arr[0].length; l++) {
                System.out.print(arr[k][l] + " ");
            }
            System.out.println();
        }


        return arr[i][j];
    }


    public static void recur(int[][] arr, int rowIdx, int colIdx, int n, String direction) {
        if (n == 1) {
            System.out.println("rowIdx == " + rowIdx);
            System.out.println("colIdx == " + colIdx);
            int targetRowIdx = rowIdx - 1;
            render(arr, targetRowIdx, colIdx);
            render(arr, targetRowIdx, colIdx - 1);
            render(arr, targetRowIdx + 1, colIdx - 1);
            render(arr, targetRowIdx + 1, colIdx);

            return;
        }

        if (direction.equals("left")) {
            recur(arr, rowIdx, colIdx - n, n, "up");
        } else if (direction.equals("up")) {
            recur(arr, rowIdx - n, colIdx, n, "right");
        } else if (direction.equals("right")) {
            recur(arr, rowIdx, colIdx + n, n, "down");
        }
//        else if (direction.equals("down")) {
//            recur(arr, rowIdx + (n / 2), colIdx, n / 2, "left");
//        }
        //down
        recur(arr, rowIdx + (n / 2), colIdx, (n / 2), "left");

    }

    public static void render(int[][] arr, int rowIdx, int colIdx) {
        if (rowIdx >= 0 && rowIdx < arr.length && colIdx >= 0 && colIdx < arr[0].length) {
            arr[rowIdx][colIdx] = num++;
        }
    }


    public static void main(String[] args) {
//        System.out.println(solution(4, 1, 3));
//        System.out.println(solution(8, 1, 3));
        System.out.println(solution(16, 1, 3));
    }

}
