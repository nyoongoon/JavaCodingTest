package _3_프로그래머스_코딩_테스트_문제_풀이_전략_자바편._2_문자열;

/**
 * 책은 StringBuilder의 reverse()를 활용함
 * - String을 new StringBuilder(str); 하여 통째로 변환하는 것 암기 !!
 */
public class _1_자연수_뒤집어_배열로_만들기_책풀이 {
    public static void main(String[] args) {

    }
    class Solution {
        public int[] solution(long n) {
            String str = String.valueOf(n);
            String reversed = new StringBuilder(str).reverse().toString();
            char[] chars = reversed.toCharArray();
            int[] answer = new int[chars.length];
            for(int i = 0; i<answer.length; i++){
                answer[i] = chars[i] - '0';
            }
            return answer;
        }
    }
}
