package _3_프로그래머스_코딩_테스트_문제_풀이_전략_자바편._2_문자열;

/**
 * 나는 문자열을 캐릭터 배열로 변환한 뒤
 * 인덱스 뒤에서부터 역으로 배열에 저장하는 방식으로 풀었다.
 */
public class _1_자연수_뒤집어_배열로_만들기_내풀이 {
    public static void main(String[] args) {

    }
    class Solution {
        public int[] solution(long n) {

            String str = String.valueOf(n);
            char[] chars = str.toCharArray();
            int[] answer = new int[chars.length];

            for(int i = chars.length - 1; i >= 0; i--){
                answer[chars.length - 1 - i] = chars[i] - '0';
            }

            return answer;
        }
    }
}
