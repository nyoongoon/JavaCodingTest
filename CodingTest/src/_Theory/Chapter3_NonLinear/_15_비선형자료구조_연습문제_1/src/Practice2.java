package _Theory.Chapter3_NonLinear._15_비선형자료구조_연습문제_1.src;

import java.util.LinkedList;
import java.util.Queue;

public class Practice2 {
    public static void solution(char[][] board) {
        int[][] dir = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
        boolean[][] visited = new boolean[board.length][board[0].length]; // 틀림..
        char[][] copy = new char[board.length][board[0].length];
        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[i].length; j++) {
                copy[i][j] = 'X';
            }
        }
//        setBoader(board, copy);


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < copy.length; j++) {
                if (i == 0 || j == 0 || i == board.length - 1 || j == board[i].length - 1) {
                    bfs(board, copy, visited, dir, new Index(i, j));
                }
            }
        }


        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[i].length; j++) {
                System.out.print(copy[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void bfs(char[][] border, char[][] copy, boolean[][] visited, int[][] dir, Index startIdx) {
        Queue<Index> queue = new LinkedList<>();
        queue.add(startIdx);

        while (!queue.isEmpty()) {
            Index idx = queue.poll();
            if (border[idx.i][idx.j] != 'O' || visited[idx.i][idx.j]) {
                continue;
            }

            visited[idx.i][idx.j] = true;
            copy[idx.i][idx.j] = 'O';
            for (int k = 0; k < dir.length; k++) {
                int nextI = idx.i + dir[k][0];
                int nextJ = idx.j + dir[k][1];

                if (check(border, nextI, nextJ)) {
                    queue.add(new Index(nextI, nextJ));
                }
            }
        }
    }

    private static boolean check(char[][] border, int i, int j) {
        if (i >= 0 && i < border.length && j >= 0 && j < border[i].length) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        // Test code
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        solution(board);
        System.out.println();

//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[i].length; j++) {
//                System.out.print(board[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();

        board = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'O', 'X'}};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        solution(board);
        System.out.println();
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[i].length; j++) {
//                System.out.print(board[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
        board = new char[][]{
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'O', 'O'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'O', 'X'}};

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        solution(board);
        System.out.println();


        board = new char[][]{
                {'X', 'X', 'O', 'O'},
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}};

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        solution(board);
        System.out.println();
    }


//    public static boolean check(char[][] board, boolean[][] visited, int[][] dir, int i, int j) {
//
//        if (0 > i || i >= board.length || 0 > j || j >= board[i].length) {
//            return true;
//        }
//
//        if (visited[i][j]) { // 방문했던 곳은 재방문해도 결과 같음
//            return false;
//        }
//
//        visited[i][j] = true;
//        if (board[i][j] == 'X') {
//            return false;
//        }
//
//        int nextI;
//        int nextJ;
//        for (int k = 0; k < dir.length; k++) {
//            nextI = i + dir[k][0];
//            nextJ = j + dir[k][1];
//            if (check(board, visited, dir, nextI, nextJ)) {
//                return true;
//            }
//        }
//        //dfs 결과 false인 경우 X표시
//        board[i][j] = 'X';
//
//
//        return false;
//    }

    static class Index {
        int i;
        int j;

        public Index(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
