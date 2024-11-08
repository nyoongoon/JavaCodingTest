package _0_Theory.Chapter4_Algorithm._15_백트래킹.src;// 알고리즘 - 백트래킹

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
            return cnt;
        }
        // 한 row에 모든 열을 둬 보는 건지???? -> 백트랙킹이라 안하는거 아닌지 -> 그게 아니라 첫번째row에 퀸이 어디어디 들어갈 수 있는지 각 상황을 보는 것..
        for (int i = 0; i < n; i++) {
            board[row] = i; // 퀸을 row행에 i열에 두는 경우..

            //promising
            if (isPromising(row)) { // 현재 둘 수 있는지 판단
                nQueen(row + 1); // 현재 row에 퀸을 두고 row + 1 자리 검증 시도
            }
        }

        return cnt;
    }

    private static boolean isPromising(int row) { // 현재 퀸을 놓기로한 자리(row)에 놓을 수 있는지 검증..
        for (int i = 0; i < row; i++) { // 왜 row 까지 인지 -> 기존에 퀸을 놓은 자리(i)와 현재 놓을 자리(row)를 비교하는 것
            // 이곳이 가지치기..
            /**
             * 대각선 구하는 공식 암기 -> abs(행-행) = abs(열-열)
             */
            if (board[i] == board[row] || // 같은 열이 있는지 판단 (값이 열) board[i]가 기존에 놓았던 퀸
                    Math.abs(i - row) == Math.abs(board[i] - board[row])) { // 대각선 판단.. abs(행-행) == abs(열-열)
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
