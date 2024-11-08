package _0_Theory.Chapter1_Math._05_점화식과재귀함수.src;// Practice2
// 최대공약수를 재귀함수로 구현하시오.

/**
 * 유클리드 호제법
 * - 정수 h,n,m에 대해서 h|n이고 h|m이면 임의의 정수 i와 j에 대해서 h|(in+jm)이 성립한다.
 * => 즉, gcd(n,m)이 n과 m의 최대공약수라 할 때, n과 m이 둘 다 0이 아니라면,
 * gcd(n,m) = in + jm이 성립하는 i와 j가 존재한다..
 */
public class Practice2 {
    //https://ko.wikipedia.org/wiki/%EC%9C%A0%ED%81%B4%EB%A6%AC%EB%93%9C_%ED%98%B8%EC%A0%9C%EB%B2%95
    //https://www.youtube.com/watch?v=rb71JCx6Hb0 //유니온티비 증명 보기...
    public static int gcd(int a, int b) { // ...?? -> 유클리드 호제법
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
//      Test code
        System.out.println(gcd(3, 5));
        System.out.println(gcd(2, 6));
        System.out.println(gcd(8, 12));
    }
}
