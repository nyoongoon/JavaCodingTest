package _4_후기.클래스101;

public class Example {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int x = 1;
        int y = 1;
        int[] arr = {1, 1, 11, 7, 1, 1000000000, 1000000000, 1};
        int solution1 = solution.solution(x, y, arr);
        System.out.println(solution1);
    }
    static class Solution {
        public int solution(int X, int Y, int[] A) {
            if(X == Y) return A.length - 1;
            int N = A.length;
            int result = -1;
            int nX = 0;
            int nY = 0;
            for (int i = 0; i < N; i++) {
                if (A[i] == X)
                    nX += 1;
                else if (A[i] == Y)
                    nY += 1;
                if (nX == nY)
                    result = i;
            }
            return result;
        }
    }
}
