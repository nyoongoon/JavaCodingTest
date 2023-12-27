package _Theory.Chapter1_Math.Math_05.src;// 기초 수학 - 조합

public class Main {

    public static int combination(int n, int r){
        int nResult = 1;
        for (int i = n; i >= n - r + 1; i--) {
            nResult *= i;
        }
        int rResult = 1;
        for (int i = r; i >=1 ; i--) {
            rResult *= i;
        }
        return nResult / rResult;
    }

    public static void main(String[] args) {
//      1. 조합 // nCr = nPr / r!  == n!/(n-r)!r!
        System.out.println("== 조합 ==");

        int n = 4;
        int r = 2;

        int nResult = 1;
        for (int i = n; i >= n - r + 1; i--) {
            nResult *= i;
        }
        int rResult = 1;
        for (int i = r; i >=1 ; i--) {
            rResult *= i;
        }

        System.out.println(nResult/rResult);



//      2. 중복 조합
        System.out.println("== 중복 조합 ==");
        n = 2;
        r = 3;

        System.out.println(combination(n+r-1, r));

    }
}
