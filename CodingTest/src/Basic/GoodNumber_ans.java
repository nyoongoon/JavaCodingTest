package Basic;

public class GoodNumber_ans { /// 이해 못했음 ... !!! ㅜㅜㅜ

    final static int mod = (int) 1e9 + 7;

    public static int solution(long n) {
        // 조합 -> 짝수번째 경우의 수 -> 5C1 , 홀수 -> 4C1

        return (int)(recursion(5, (n+1/2)) * recursion(4, n/2) % mod);
    }

    public static long recursion(long x, long y) { // y는 재귀에 대한 횟수
        if (y == 0) {
            return 1;
        }

        long p = recursion(x, y / 2);
        return p * p * (y % 2 > 0 ? x : 1) % mod;
    }


    public static void main(String[] args) {
        // Test code
        System.out.println(solution(1));
        System.out.println(solution(2));
        System.out.println(solution(3));
        System.out.println(solution(4));
        System.out.println(solution(50));

    }
}
