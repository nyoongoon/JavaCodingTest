package _3_프로그래머스_코딩_테스트_문제_풀이_전략_자바편._2_문자열;

public class _3_이상한_문자_만들기_내풀이 {
    class Solution {
        public String solution(String s) {
            char[] chars = s.toCharArray();

            int idx = 0;
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(c == ' '){
                    idx = 0;
                    continue;
                }
                if(idx % 2 == 0){
                    c =  Character.toUpperCase(c);
                }else{
                    c = Character.toLowerCase(c);
                }
                chars[i] = c;
                idx++;
            }

            return new String(chars);
        }
    }
}
