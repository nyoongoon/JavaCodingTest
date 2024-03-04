package _Theory.Chapter3_NonLinear._15_비선형자료구조_연습문제.src;

public class Practice4 {
    public static int solution(String[] deadends, String target) {

        return -1;
    }

    public static void main(String[] args) {
        // Test code
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        System.out.println(solution(deadends, "0202"));

        deadends = new String[] {"8888"};
        System.out.println(solution(deadends, "0009"));

    }
}
