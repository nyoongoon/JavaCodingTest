package _3_프로그래머스_코딩_테스트_문제_풀이_전략_자바편._2_문자열;

import java.util.ArrayList;
import java.util.List;

/**
 * 내풀이로는 못 품
 * 앞에서부터 고정길이로 자르는 요구사항 주의
 * <p>
 * int를 StringBuilder 추가하고 싶을 때 -> 그냥 append(int i) 하면 됨
 *
 */
public class _4_문자열_압축_책풀이 {
    class Solution {
        public int solution(String s) {
            int min = s.length();
            for(int i = 1; i <= s.length() / 2; i++){
                List<String> list = split(s, i);
                String str = compress(list);
                min = Math.min(min, str.length());
            }

            return min;
        }

        public String compress(List<String> list){
            StringBuilder sb = new StringBuilder();
            String prevStr = "";
            int prevCnt = 0;

            for(String str : list){
                if(prevStr.equals(str)){
                    prevCnt++;
                    continue;
                }

                if(prevCnt > 1){
                    sb.append(prevCnt);
                }
                sb.append(prevStr);

                prevStr = str;
                prevCnt = 1;
            }

            if(prevCnt > 1){
                sb.append(prevCnt);
            }
            sb.append(prevStr);
            return sb.toString();
        }

        public List<String> split(String s, int len){
            List<String> list = new ArrayList<>();
            for(int i = 0; i < s.length(); i += len){
                if(i + len >= s.length()){
                    list.add(s.substring(i, s.length()));
                    break;
                }
                list.add(s.substring(i, i + len));
            }

            return list;
        }
    }
}
