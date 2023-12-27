package _Theory.Chapter1_Math.Math_06.src;// Practice2
// 최대공약수를 재귀함수로 구현하시오.

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
