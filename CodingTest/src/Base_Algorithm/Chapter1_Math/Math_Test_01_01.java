package Base_Algorithm.Chapter1_Math;

public class Math_Test_01_01 { //n보다 작은 소수의 개수
    public static int solution2(int n) {
        // 에라토스테네스의 체로 풀어보기
        int result = 0;
        boolean[] era = new boolean[n + 1];
        for (int i = 2; i < n; i++) { // n 범위 더 좁힐 수 있음 !
            if (era[i] == true) { //이미 지워졌다면 누군가의 배수라는 의미...
                continue;
            }
            for (int j = 2; j <= n / i; j++) {
                era[i * j] = true;
            }
        }

        for (int i = 2; i < era.length; i++) {
            if (era[i] == false) {
                result++;
            }
        }
        return result;
    }


    public static int solution(int n) {
        int result = 0;
        for (int i = 1; i < n; i++) {
            if (isPrime(i)) {
                result++;
            }
        }
        return result;
    }

    public static boolean isPrime(int num) {
        if (num == 0 || num == 1) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution(100));
        System.out.println(solution2(100));
    }
}
