package _3_프로그래머스_코딩_테스트_문제_풀이_전략_자바편._2_문자열;

/**
 * 왜틀린지 모르겠네
 * StrinBuilder 말고 char[]로 해보자
 */
public class _2_시저_암호_내풀이 {
    class Solution {
        public String solution(String s, int n) {
            String answer = "";
            // System.out.println((int)'a');
            // System.out.println((int)'z');
            // System.out.println((int)'A');
            // System.out.println((int)'Z');
            // 91이상이면 - 26
            // 123 이상이면 - 26
            char[] chars = s.toCharArray();
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i<chars.length; i++){
                char c = chars[i];
                if(c + n >= 123){
                    sb.append((char)(c + n - 26));
                }else if(c + n >= 97){
                    sb.append((char)(c + n));
                }else if(c + n >= 91){
                    sb.append((char)(c + n - 26));
                }else if(c == ' '){
                    sb.append(' ');
                }else{
                    sb.append((char)(c + n));
                }
            }

            return sb.toString();
        }
    }
}
