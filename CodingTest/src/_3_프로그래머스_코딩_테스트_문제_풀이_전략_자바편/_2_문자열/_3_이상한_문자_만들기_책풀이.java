package _3_프로그래머스_코딩_테스트_문제_풀이_전략_자바편._2_문자열;

/**
 * Character.isSpaceChar() 암기..
 */
public class _3_이상한_문자_만들기_책풀이 {
    class Solution {
        public String solution(String s) {
            StringBuilder sb = new StringBuilder();
            char[] chars = s.toCharArray();
            boolean toUpper = true;
            for(int i = 0; i < chars.length; i++){
                char c = c  hars[i];
                if(Character.isSpaceChar(c)){
                    sb.append(c);
                    toUpper = true;
                    continue;
                }

                if(toUpper){
                    c = Character.toUpperCase(c);
                }else{
                    c = Character.toLowerCase(c);
                }
                sb.append(c);
                toUpper = !toUpper;
            }

            return sb.toString();
        }
    }
}
