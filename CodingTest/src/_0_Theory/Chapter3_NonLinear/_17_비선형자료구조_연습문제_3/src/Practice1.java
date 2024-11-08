package _0_Theory.Chapter3_NonLinear._17_비선형자료구조_연습문제_3.src;

public class Practice1 {
    static int normalCnt = 0;
    static int notNormalCnt = 0;
    static int[][] moves = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void solution(char[][] picture) {
        char[][] copy = new char[picture.length][picture[0].length];
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture.length; j++) {
                copy[i][j] = picture[i][j];
            }
        }

        System.out.println("일반");
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[i].length; j++) {
                if (start(picture, true, i, j)) {
                    normalCnt++;
                }
            }
        }
        System.out.println("적록");
        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[i].length; j++) {
                if (start(copy, false, i, j)) {
                    notNormalCnt++;
                }
            }
        }

        System.out.println("일반:" + normalCnt);
        System.out.println("적록:" + notNormalCnt);
    }

    public static boolean start(char[][] picture, boolean isNomal, int row, int col) {
        if (bfs(picture, isNomal, row, col, picture[row][col])) {
            return true;
        }

        return false;
    }


    public static boolean bfs(char[][] picture, boolean isNomal, int row, int col, char color) {

        if (row < 0 || row >= picture.length || col < 0 || col >= picture.length) {
            return false;
        }

        if (picture[row][col] == 'X') {
            return false;
        }
        boolean isSame;

        if (isNomal) {
            isSame = normalCheck(picture, color, row, col);
        } else {
            isSame = notNormalCheck(picture, color, row, col);
        }

        if (!isSame) {
            return false;
        }

        picture[row][col] = 'X';


        for (int i = 0; i < moves.length; i++) {
            int nextRow = row + moves[i][0];
            int nextCol = col + moves[i][1];
            bfs(picture, isNomal, nextRow, nextCol, color);
        }

        return true;
    }

    private static boolean normalCheck(char[][] picture, char color, int row, int col) {
        if (color == picture[row][col]) {
            return true;
        }
        return false;
    }

    private static boolean notNormalCheck(char[][] picture, char color, int row, int col) {
        char targetColor = picture[row][col];
        if (color == targetColor) {
            return true;
        }

        if (color == 'R' && targetColor == 'G') {
            return true;
        } else if (color == 'G' && targetColor == 'R') {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        // Test code
        char[][] pictures = {
                {'R', 'R', 'R', 'B', 'B'},
                {'G', 'G', 'B', 'B', 'B'},
                {'B', 'B', 'B', 'R', 'R'},
                {'B', 'B', 'R', 'R', 'R'},
                {'R', 'R', 'R', 'R', 'R'}};
        solution(pictures); // 4 3
    }
}
