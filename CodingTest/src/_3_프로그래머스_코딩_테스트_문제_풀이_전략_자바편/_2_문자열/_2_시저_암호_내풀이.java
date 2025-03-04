package _3_프로그래머스_코딩_테스트_문제_풀이_전략_자바편._2_문자열;

/**
 *
 */
public class _2_시저_암호_내풀이 {
    class Solution {
        public String solution(String s, int n) {
            String answer = "";
            char[] chars = s.toCharArray();

            char[] result = new char[chars.length];
            for(int i = 0; i<chars.length; i++){
                char c = chars[i];
                Character next;

                if(c >= 65 && c <= 90) {
                    next = c + n <= 90 ? (char) (c + n) : (char)(64 + (c + n) % 90);
                }else if(c >= 97 && c <= 122){
                    next = c + n <= 122 ? (char) (c + n) : (char)(96 + (c + n) % 122);
                }else {
                    next = c;
                }
                result[i] = next;
            }

            return new String(result);
        }
    }
}
