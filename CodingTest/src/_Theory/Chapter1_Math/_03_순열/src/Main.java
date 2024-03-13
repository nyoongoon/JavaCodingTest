package _Theory.Chapter1_Math._03_순열.src;// 기초 수학 - 순열

/**
 * 순열은 뽑아서 줄 세우기 -> 곱의법칙 응용
 * 5명 중 3명 줄 세우기 -> 5*4*3
 */
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
//      5명을 3줄로 세우는 경우의 수  -> 5 * 4 * 3
        int n = 5;
        int r = 3;
        result = 1;
        for (int i = n; i >= n - r + 1; i--) {
            result *= i;
        }

        System.out.println(result);

//      3. 중복 순열
        /**
         *
         * 중복 순열 이론 (중복 허용 순열)
         * cf) 하나의 대상이 여러번 등장하므로 사람의 예시는 안됨
         * ex) a, b, c 3문자로 5자리 문자 만들기
         * a, b, c -> ㅁ, ㅁ, ㅁ, ㅁ, ㅁ
         *            3 * 3 * 3 * 3 * 3 = 3^5
         *           -> 각각의 상황을 곱의 법칙으로 푸는 개념!
         *
         */
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
        /**
         * 원 순열 이론
         * -> 원순열은 자리에 고유번호가 없는 상태
         * -> 최초의 한 자리를 배정하면 나머지 고유번호가 생기는 것 -> 직순열이 됨.
         * ex) 3명이 원탁에 앉기
         * -> 최초 한 칸 채우는 자리의 수(어딜가나 자리 같음) * 2명 줄세우기(직순열)
         * == 1 * 2 * 1
         * ex) 6명이 원탁에 앉기
         * -> 1 * 5 * 4 * 3 * 2 * 1
         */
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
