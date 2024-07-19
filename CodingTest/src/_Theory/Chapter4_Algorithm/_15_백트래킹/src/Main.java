package _Theory.Chapter4_Algorithm._15_백트래킹.src;// 알고리즘 - 백트래킹

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

        for (int i = 0; i < n; i++) { // 한 row에 모든 열을 둬 보는 건지???? -> 백트랙킹이라 안하는거 아닌지?
            board[row] = i; // 퀸을 row행에 i열에 두는 경우..

            //promising
            if (isPromising(row)) {
                nQueen(row + 1); // 현재 row가 불가능하면 row row+1도 불가능하다?
            }
        }

        return cnt;
    }

    private static boolean isPromising(int row) {
        for (int i = 0; i < row; i++) {
            // 이곳이 가지치기..
            /**
             * 대각선 구하는 공식 암기 -> abs(행-행) = abs(열-열)
             */
            if (board[row] == board[i] || // 같은 row인지 판단
                    row - i == Math.abs(board[row] - board[i])) { // 대각선 판단.. abs(행-행) == abs(열-열)
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
