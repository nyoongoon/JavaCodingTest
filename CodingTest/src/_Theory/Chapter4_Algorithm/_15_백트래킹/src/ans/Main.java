package _Theory.Chapter4_Algorithm._15_백트래킹.src.ans;// 알고리즘 - 백트래킹

public class Main {

    static int n = 4;
    static int[] board = new int[n];
    static int cnt;

    public static int nQueen(int row) {
        if (row == n) {
            cnt++;
            return cnt;
        }

        for (int i = 0; i < n; i++) {
            board[row] = i; //row행 i열에 퀸 두기

            if (isPromising(row)) {
                nQueen(row + 1);
            }
        }

        return cnt;
    }

    // 현재 row에 둔 퀸이 이전에 둔 퀸들과 충돌하지 않는지 검증
    private static boolean isPromising(int row) {
        for (int i = 0; i < row; i++) {
            if (board[i] == board[row] || //다른행에 열이 같은 경우
                    Math.abs(i - row) == Math.abs(board[i] - board[row])) { // 다른행이 대각선에 위치한 경우
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // Test code
        System.out.println("경우의 수: " + nQueen(0));  // 2
    }
}
