package _Theory.Chapter1_Math._04_조합.src;// 기초 수학 - 조합


/**
 * 직관적인 느낌과 다르게 순열보다 조합이 계산이 더 복잡
 * 조합 = 순열 / 줄 세우는 방법의 수
 * <p>
 * 조합(줄 세우지 않는 뽑기 경우의 수)
 * == 먼저 줄 세워서 뽑은 후(순열) 줄세우는 것을 취소함(줄세우는 방법 경우의 수로 나눔)
 * <p>
 * 5C3 = (5P3 == 5 * 4 * 3) / (3! == 줄세우는 방법의 수) --> 3!의 의미는 뭐지? (줄 세우는 방법의 수?)
 * <p>
 * cf) 5C3 과 5C2의 결과는 같음.
 * 5개중 3개를 뽑는 것이 곧 나머지 2개를 뽑는 것.
 */
public class Main {

    public static int combination(int n, int r) {
        int nResult = 1;
        for (int i = n; i >= n - r + 1; i--) {
            nResult *= i;
        }
        int rResult = 1;
        for (int i = r; i >= 1; i--) {
            rResult *= i;
        }
        return nResult / rResult;
    }

    public static void main(String[] args) {
//      1. 조합 // nCr = nPr / r!  == n!/(n-r)! / r!
        System.out.println("== 조합 ==");

        int n = 4;
        int r = 2;

        int nResult = 1;
        for (int i = n; i >= n - r + 1; i--) {
            nResult *= i;
        }
        int rResult = 1;
        for (int i = r; i >= 1; i--) {
            rResult *= i;
        }

        System.out.println(nResult / rResult);


        /**
         *
         * 중복 조합 이론
         *
         * ex) 사람을 중복 조합으로 뽑는 것을 불가능함
         * ex) 페퍼로니 피자, 치즈 피자, 고구마 피자로 33개의 피자를 주문하는 방법의 수
         * -> 막대기 이론 응용
         * 중복조함 nHr = n+r-1Hr
         *
         */
//      2. 중복 조합
        System.out.println("== 중복 조합 ==");
        n = 2;
        r = 3;

        System.out.println(combination(n + r - 1, r));
    }
}
