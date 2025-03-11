package _2_Java_Algo_Interview._1_문자열;

/**
 * 정규식 + 메서드 까먹음...
 * --------------------------------- 기억하기 --- ------------------------------
 * 영문 (a-zA-Z)과 숫자 (0-9)를 제외한 나머지를 선택하는 정규식 ->[^a-zA-Z0-9]+
 * [^...] : 대괄호 안의 문자들을 제외하고 매칭
 * a-zA-Z0-9 : 영문 대소문자와 숫자
 * + : 한 개 이상 연속된 경우
 * ---------------------------------------------------------------------------
 * Character.toLowerCase()
 * Character.isLetterOrDegit() << 기억 안났음
 * ---------------------------------------------------------------------------
 * 추가로 다시 기억하기 정규식..
 * \\W+ << 문자(숫자포함)이 아닌 것 하나 이상
 * \\w+ << 문자(숫자포함) 하나 이상
 */
public class _1_유효한_팰린드롬_내풀이_다시풀이_1 {
    public static void main(String[] args) {

    }

    class Solution {
        public boolean isPalindrome(String s) {
            s = s.toLowerCase();
            s = s.replaceAll("\\W+", "");
            s = s.replaceAll("_", "");
            int left = 0;
            int right = s.length()-1;

            while(left < right){
                if(s.charAt(left) != s.charAt(right)){
                    return false;
                }
                left++;
                right--;
            }

            return true;
        }
    }
}
