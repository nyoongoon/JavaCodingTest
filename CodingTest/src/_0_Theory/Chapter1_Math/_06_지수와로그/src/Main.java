package _0_Theory.Chapter1_Math._06_지수와로그.src;// 기초 수학 - 지수와 로그

public class Main {


    /**
     * 로그 - log a b
     * => a가 b가 되기 위해서 제곱해야하는 수
     * ex) log 2 4 = 2 => 2가 4가 되기 위해서 2제곱해야한다.
     */
    public static void main(String[] args) {

//      1. 제곱, 제곱근, 지수
        System.out.println("== 제곱 ==");
        System.out.println(Math.pow(2, 3));
        System.out.println(Math.pow(2, -3));
        System.out.println(Math.pow(-2, -3));

        System.out.println("== 제곱근 ==");
        System.out.println(Math.sqrt(16));
        System.out.println(Math.pow(16, 1.0 / 2));

//      참고) 절대 값
        System.out.println("== 절대 값 ==");
        System.out.println(Math.abs(5));
        System.out.println(Math.abs(-5));

//      2. 로그
        System.out.println("== 로그 ==");
        System.out.println(Math.E); // 자연상수
        System.out.println(Math.log(Math.E));
        System.out.println(Math.log10(1000));
        System.out.println(Math.log(4) / Math.log(2)); // log 2 4

    }
}
