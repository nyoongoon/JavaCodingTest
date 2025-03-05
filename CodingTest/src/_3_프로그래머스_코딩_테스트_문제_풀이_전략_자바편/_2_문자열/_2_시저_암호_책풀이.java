package _3_프로그래머스_코딩_테스트_문제_풀이_전략_자바편._2_문자열;

/**
 * 대소문자 동일하게 offset 개념으로 깔끔하게 푸는 것 암기
 * --> offset 처리를 해놓는다면 (시작값 초기화) -> 관심 있는 범위 내에서  += x % m 을 통해 가능 (안넘기면 그냥 더해지고, 넘기면 초기화되서 더해짐)
 * --> offset 처리가 되있지 않다면 범위 넘은지 안넘은지에 대한 분기가 필요 !
 * Character.isAlphabetic() 암기
 */
public class _2_시저_암호_책풀이 {
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
            int position = c - offset;
            position = (position + n) % ('Z' - 'A' + 1);
            return (char) (offset + position);
        }
    }
}
