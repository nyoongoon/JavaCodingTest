package Base_Algorithm;

public class CatalanNumber_ans { // 재귀 호출 연습... => 재귀로 풀면 점화식 그대로 아주 쉽게 품...

    public static int solution(int n) {

        // f(n+1) = f(i) * f(n-i)
        // f(n) = f(i) * f(n-i-1)

        int result = 0;

        if(n <= 1){
            return 1;
        }

        for (int i = 0; i < n; i++) {
            result += solution(i) * solution(n - i - 1);
        }


        return result;
    }


    public static void main(String[] args) {
        // Test code
        System.out.println(solution(0));
        System.out.println(solution(2));
        System.out.println(solution(5));
        System.out.println(solution(7));
    }
}
