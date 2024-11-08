package _0_Theory.Chapter3_NonLinear._15_비선형자료구조_연습문제_1.src;

public class Practice2_ans {
    public static void solution(char[][] board) {
        print(board);

        for (int i = 0; i < board.length; i++) {
            dfs(board, i, 0);
            dfs(board, i, board[0].length - 1);
        }

        for (int i = 0; i < board[0].length; i++) {
            dfs(board, 0, i);
            dfs(board, board.length - 1, i);
        }

        starToCircle(board);

        print(board);
    }

    private static void starToCircle(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private static void dfs(char[][] board, int i, int j) {
//        System.out.println("i, j == " + i + ", " + j);
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length) {
            return;
        }

        if (board[i][j] == 'O') {
            board[i][j] = '*';

            dfs(board, i, j - 1);
            dfs(board, i + 1, j);
            dfs(board, i, j + 1);
            dfs(board, i - 1, j);
        }
    }


    public static void print(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test code
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};

        solution(board);

        board = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'O', 'X'}};
        solution(board);

        board = new char[][]{
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'O', 'O'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'O', 'X'}};
        solution(board);

        board = new char[][]{
                {'X', 'X', 'O', 'O'},
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}};

        solution(board);

    }


}
