package _3_프로그래머스_코딩_테스트_문제_풀이_전략_자바편._2_문자열;

import java.util.ArrayList;
import java.util.List;

/**
 * 내풀이로는 못 품
 * 앞에서부터 고정길이로 자르는 요구사항 주의
 * <p>
 * int를 StringBuilder 추가하고 싶을 때 -> 그냥 append(int i) 하면 됨
 * <p>
 * if(prevCnt != 0){ // todo prevCnt > 1 --> 왜 틀렸는지 분석하기..
 * --> 앞의 숫자가 1씩 작게 출력됨 (0부터 카운트해서)
 * --> aaaaaaaaaabb -> 10a2b 같이 자리수가 변하는 경우 틀림!
 */
public class _4_문자열_압축_책풀이_보고_틀리게작성 {
    class Solution {
        public int solution(String s) {
            int min = s.length();
            for (int i = 1; i <= s.length() / 2; i++) {
                List<String> list = split(s, i);
                int len = getLen(list);
                // System.out.println("len == " + len);
                min = Math.min(len, min);
            }
            return min;
        }

        public int getLen(List<String> list) {
            StringBuilder sb = new StringBuilder();
            int prevCnt = 0;
            String prev = "";
            for (String s : list) {
                if (prev.equals(s)) {
                    prevCnt++;
                } else {
                    // char c = (char)(prevCnt + '0');
                    // System.out.println("prevCnt == " + c);
                    if (prevCnt != 0) { // todo prevCnt > 1
                        sb.append(prevCnt);
                    }
                    sb.append(prev);

                    prev = s;
                    prevCnt = 0; // todo prevCnt = 1;
                }
            }
            if (prevCnt != 0) { // todo prevCnt > 1
                sb.append(prevCnt);
            }
            sb.append(prev);
            // System.out.println("sb.toString() == " + sb.toString());
            return sb.length();
        }


        public List<String> split(String s, int len) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < s.length(); i += len) {
                int endIdx = i + len > s.length() ? s.length() : i + len;
                list.add(s.substring(i, endIdx));
            }
            // for(String str : list){
            //     System.out.println("str == " + str);
            // }
            return list;
        }
    }
}
