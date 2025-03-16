package _2_Java_Algo_Interview._1_문자열;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 성능 넘 안조아짐.. -> 오히려 책 풀이보다 빠르다?
 */
public class _3_로그파일_재정렬_내풀이_다시풀이_1 {

    class Solution {
        public String[] reorderLogFiles(String[] logs) {
            List<String[]> strs = new ArrayList<>();
            List<String[]> digits = new ArrayList<>();
            for(String s : logs){
                String[] splited = s.split(" ", 2);
                if(Character.isDigit(splited[1].charAt(0))){
                    digits.add(splited);
                }else{
                    strs.add(splited);
                }
            }
            strs.sort((x, y) -> x[1].equals(y[1]) ? x[0].compareTo(y[0]) : x[1].compareTo(y[1]));

            String[] result = new String[logs.length];
            int idx = 0;
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i<strs.size(); i++){
                sb.append(strs.get(i)[0]);
                sb.append(" ");
                sb.append(strs.get(i)[1]);
                result[idx++] = sb.toString();
                sb.setLength(0);
            }
            for(int i = 0; i<digits.size(); i++){
                sb.append(digits.get(i)[0]);
                sb.append(" ");
                sb.append(digits.get(i)[1]);
                result[idx++] = sb.toString();
                sb.setLength(0);
            }

            return result;
        }
    }
}
