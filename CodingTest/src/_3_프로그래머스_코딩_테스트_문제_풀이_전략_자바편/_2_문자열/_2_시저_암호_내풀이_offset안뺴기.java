package _3_프로그래머스_코딩_테스트_문제_풀이_전략_자바편._2_문자열;

public class _2_시저_암호_내풀이_offset안뺴기 {
    class Solution {
        public String solution(String s, int n) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                sb.append(push(s.charAt(i), n));
            }
            return sb.toString();
        }

        public char push(char c, int n) {
            if (!Character.isAlphabetic(c)) {
                return c;
            }
            int offset = Character.isUpperCase(c) ? 'A' : 'a';

            if ((c + n) / ('Z' - 'A' + 1 + offset) < 1) {
                return (char) (c + n);
            }

            return (char) (offset + (c + n) % ('Z' - 'A' + 1 + offset));

        }
    }
}
