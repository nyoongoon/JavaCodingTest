package _0_Theory.Chapter4_Algorithm._10_그리디_연습문제.src;// Practice
// 양의 정수 n 이 주어지고 다음의 연산을 수행할 수 있을 때,
//    1. n 이 짝수인 경우, 2로 나누기 연산
//    2. n 이 홀수일 때는 1 을 더하거나 1을 빼는 연산
// 주어진 n 이 1 이 되는데 필요한 최소한의 연산 횟수를 반환하세요.

// 입출력 예시
// n: 8
// 출력: 3

// n: 7
// 출력: 4

// n: 9
// 출력: 4

/**
 * 짝수가 4의 배수일 때 최적 .. -> 똑같은거 아닌가? 3 제외하면..
 */
public class Practice3_ans {
    public static int solution(int n) {
        if (n == 0 || n == 2) {
            return 1;
        }
        if (n == 1) {
            return 0;
        }

        int cnt = 0;
        while (n != 1) {
            if (n == 3) {
                return cnt += 2;
            }

            if (n % 2 == 0) {
                n /= 2;
            } else if ((n + 1) % 4 == 0) {
                n += 1;
            } else if ((n - 1) % 4 == 0) {
                n -= 1;
            }
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution(8));    // 3
        System.out.println(solution(7));    // 4
        System.out.println(solution(9));    // 4
        System.out.println(solution(6));    // 3
    }
}
