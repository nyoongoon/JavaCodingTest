package _Theory.Chapter1_Math.기초수학_코딩테스트;

public class Math_TEST_01_04_ans {
    public static int solution(int n, int i, int j) {
        return recursion(0, n, i, j);
    }

    public static int recursion(int count, int n, int row, int col) {
        if (n == 2) {
            //0,1
            if (row == 0 && col == 1) {
                return count += 1;
            }
            //0,0
            else if (row == 0 && col == 0) {
                return count += 2;
            }
            //1,0
            else if (row == 1 && col == 0) {
                return count += 3;
            }
            //1,1
            else if (row == 1 && col == 1) {
                return count += 4;
            }

            System.out.println("접근X_1");
        }

        int m = n / 2;
        if (row < m && col >= m) {
            return recursion(count, m, row, col - m);
        } else if (row < m && col < m) {
            return recursion(count + m * m, m, row, col);
        } else if (row >= m && col < m) {
            return recursion(count + m * m * 2, m, row - m, col);
        } else {
            return recursion(count + m * m * 3, m, row - m, col - m);
        }

    }


    public static void main(String[] args) {
        System.out.println(solution(4, 1, 3));
        System.out.println(solution(8, 1, 3));
        System.out.println(solution(16, 1, 3));
    }
}
