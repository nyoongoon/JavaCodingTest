package _Theory.Chapter1_Math._08_기초수학_연습문제_2.src;

public class Practice5 {

    public static void solution(int n) {
        recur(n, 1, 2, 3);
    }

    public static void recur(int cnt, int start, int middle, int end){
        if(cnt == 1){
            System.out.println(start +" -> " + end);
            return;
        }


        recur(cnt-1, start, end, middle);
        System.out.println(start +" -> " + end);
        recur(cnt-1, middle, start, end);
    }

    public static void main(String[] args) {
        // Test code
        solution(2);
        System.out.println();

        solution(3);
        System.out.println();

        solution(4);
    }
}
