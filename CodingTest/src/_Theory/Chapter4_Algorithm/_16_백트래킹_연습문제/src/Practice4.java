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


public class Practice4 {
    final static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void solution(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        backtracking(board);
    }

    public static void backtracking(char[][] board, int row, int col, int moveCnt) {
        if (moveCnt >= 10) {
            return; //최소 이동 횟수 구해야 하므로 어딘가에서 min() 해야함..
        }

        for (int i = 0; i < dirs.length; i++) {
            int nextRow = row + dirs[i][0];
            int nextCol = col + dirs[i][1];
            if (canMove()) {
                backtracking(board, nextRow, nextCol, moveCnt + 1);
            }else{
                //todo 이곳에서 최소 이동횟수 체크
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
}
