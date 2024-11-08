package _0_Theory.Chapter3_NonLinear._15_비선형자료구조_연습문제_1.src;

public class Practice1 {
    static int[][] move = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    //dfs ... -> stack..
    public static boolean solution(char[][] board, String word) {
        //체크하면서 스택에 넣기? -> 큐..?bfs라고ㄷ봐도되나..?


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
//                System.out.println(" == start == ");
//                System.out.println("board["+i+"]["+j+"] == " + board[i][j]);
                if (dfs(visited, board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(boolean[][] visited, char[][] board, int i, int j, String word, int idx) {
        if (word.length() == idx) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length) {
            return false;
        }
//        System.out.println("board[" + i + "][" + j + "] == " + board[i][j]);
        if (board[i][j] != word.charAt(idx)) {
//            System.out.println("!=");
            return false;
        }

        if (visited[i][j]) {
//            System.out.println("visited");
            return false;
        }

        visited[i][j] = true;
        for (int k = 0; k < move.length; k++) {

            if (dfs(visited, board, i + move[k][0], j + move[k][1], word, idx + 1)) {
                return true; // 하나만 true라도 true
            }
        }
        visited[i][j] = false;

        return false;
    }

    public static void main(String[] args) {
        // Test code
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(solution(board, "ABCCED"));
        System.out.println(solution(board, "SEE"));
        System.out.println(solution(board, "ABCB"));
    }
}
