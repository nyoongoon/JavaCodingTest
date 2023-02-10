package Base_Algorithm.Chapter1_Math.Math_04.src;// 기초 수학 - 순열

public class Main {
    public static void main(String[] args) {

//      1. 팩토리얼
        System.out.println("== 팩토리얼 ==");
//      5!
        int result = 1;
        for (int i = 1; i <= 5; i++) {
            result *= i;
        }
        System.out.println(result);
//      2. 순열 (n!/(n-r)!)
        System.out.println("== 순열 ==");
//      5명을 3줄로 세우는 경우의 수
        int n = 5;
        int r = 3;
        result = 1;
        for (int i = n; i >= n - r + 1; i--) {
            result *= i;
        }
        System.out.println(result);

//      3. 중복 순열
        System.out.println("== 중복 순열 ==");
//      서로 다른 4개의 수 중 2개를 뽑는 경우의 수 (중복 허용)
        result = 1;
        n = 4;
        r = 2;
        for (int i = 0; i < r; i++) {
            result *= n;
        }
        System.out.println(result);
//      4. 원 순열
        System.out.println("== 원 순열 ==");
//      원 모양의 테이블에 3명을 앉히는 경우의 수
        result = 1;
        n = 3;
        for (int i = 1; i <= n-1 ; i++) {
            result *= i;
        }
        System.out.println(result);
    }
}
