package _Theory.Chapter4_Algorithm._15_백트래킹.src.ans;// 알고리즘 - 백트래킹

public class Main {

    static int n = 4;
    static int[] board = new int[n];
    static int cnt;

    public static int nQueen(int row) {
        if (row == n) {
            cnt++;

            for (int i = 0; i < n; i++) {
                System.out.print(board[i] + " ");
            }
            System.out.println();
            return -1; // 여기서 return은 재귀 종료용
        }

        for (int i = 0; i < n; i++) {
            board[row] = i;

            if (promising(row)) {
                nQueen(row + 1);
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        // Test code
        System.out.println("경우의 수: " + nQueen(0));  // 2
    }

    private static boolean promising(int row) {
        for (int i = 0; i < row; i++) {
            if (board[i] == board[row] ||
                    Math.abs(i - row) == Math.abs(board[i] - board[row])
            ) {
                return false;
            }
        }

        return true;
    }
}
