package _Theory.Chapter4_Algorithm._16_백트래킹_연습문제.src;// Practice4
// 2차원 배열 board 가 주어졌다.
// 해당 배열 데이터에는 'o', '#', '.' 의 정보가 기입되어 있다.
// 'o': 동전을 의미
// '#': 벽을 의미
// '.': 빈칸을 의미

// 동전은 항상 두개가 주어진다.
// 두 동전이 함께 이동하다가 하나가 보드에서 떨어지는 경우의 최소 이동 횟수를 출력하는 프로그램을 작성하세요.
// 단, 이동 규칙은 다음과 같다.
// 동전은 좌, 우, 위, 아래로 이동 가능하며 같은 방향으로 함께 이동
// 빈칸이나 동전이 있는 칸으로는 이동 가능
// 벽일 때는 이동 불가
// 이동 횟수가 10번을 넘으면 중지하고 -1 반환

// 입출력 예시
// board: {{'.', '#'}, {'.', '#'}, {'.', '#'}, {'o', '#'}, {'o', '#'}, {'#', '#'}}
// 결과: 4


import java.util.ArrayList;
import java.util.List;

public class Practice4 {
    final static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int min;

    public static void solution(char[][] board) {
        min = Integer.MAX_VALUE;
        List<Coin> coins = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'o') {
                    Coin coin = new Coin(i, j);
                    coins.add(coin);
                }
            }
        }

        Coin coin1 = coins.get(0);
        Coin coin2 = coins.get(1);

        backtracking(board, coin1.row, coin1.col, coin2.row, coin2.col, 0);

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    public static void backtracking(char[][] board, int row1, int col1, int row2, int col2, int moveCnt) {
        if (moveCnt >= 10) {
            return;
        }

        for (int i = 0; i < dirs.length; i++) {
            int cntOfCrossed = 0;
            int nextRow1 = row1 + dirs[i][0];
            int nextCol1 = col1 + dirs[i][1];
            int nextRow2 = row2 + dirs[i][0];
            int nextCol2 = col2 + dirs[i][1];

            // 범위 넘어가면 카운트
            if (0 > nextRow1 || nextRow1 >= board.length || 0 > nextCol1 || nextCol1 >= board[0].length) {
                cntOfCrossed++;
            }
            if (0 > nextRow2 || nextRow2 >= board.length || 0 > nextCol2 || nextCol2 >= board[0].length) {
                cntOfCrossed++;
            }


            if (cntOfCrossed > 1) {
                continue;
            } else if (cntOfCrossed == 0) {
                if (board[nextRow1][nextCol1] == '#') {
                    nextRow1 = row1;
                    nextCol1 = col1;
                }
                if (board[nextRow2][nextCol2] == '#') {
                    nextRow2 = row2;
                    nextCol2 = col2;
                }
                backtracking(board, nextRow1, nextCol1, nextRow2, nextCol2, moveCnt + 1);
            } else {
                min = Math.min(min, moveCnt + 1);
            }
        }
    }

    public static void main(String[] args) {
        // Test code
        char[][] board = {{'.', '#'}, {'.', '#'}, {'.', '#'}, {'o', '#'}, {'o', '#'}, {'#', '#'}};
        solution(board);

        board = new char[][]{{'#', '#', '#'}, {'.', 'o', '.'}, {'#', '.', '#'}, {'.', 'o', '.'}, {'#', '#', '#'}};
        solution(board);

        board = new char[][]{{'#', '#', '#'}, {'.', 'o', '.'}, {'#', '#', '#'}, {'.', 'o', '.'}, {'#', '#', '#'}};
        solution(board);
    }

    public static class Coin {
        int row;
        int col;

        public Coin(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
