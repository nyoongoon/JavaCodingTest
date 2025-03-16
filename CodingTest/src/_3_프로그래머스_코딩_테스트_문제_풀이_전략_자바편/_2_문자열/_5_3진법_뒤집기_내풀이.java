package _3_프로그래머스_코딩_테스트_문제_풀이_전략_자바편._2_문자열;

/**
 * int Integer.parseInt(String s, int radix)
 * - radix 진법으로 숫자를 표현하는 문자열 s를 정수로 변환
 * <p>
 * String Integer.toString(int v, int radix)
 * - 정수 v를 radix 진법의 문자열로 변환
 * <p>
 * long Long.parseLong(String s, int radix)
 * - radix 진법으로 숫자를 표현하는 문자열 s를 정수로 변환
 * <p>
 * String Long.toString(long v, int radix)
 * - 정수 v를 radix 진법의 문자열로 변환
 * <p>
 * String binary = "1010";
 * int value = Integer.parseInt(binary, 2);
 * String hex = Integer.toString(value, 16);
 */
public class _5_3진법_뒤집기_내풀이 {
    class Solution {
        public int solution(int n) {
            String threeRadixStr = Integer.toString(n, 3);
            StringBuilder sb = new StringBuilder(threeRadixStr);
            sb.reverse();

            int answer = Integer.parseInt(sb.toString(), 3);
            return answer;
        }
    }
}
