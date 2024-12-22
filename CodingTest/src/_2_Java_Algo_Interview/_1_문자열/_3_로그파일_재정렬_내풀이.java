package _2_Java_Algo_Interview._1_문자열;

import java.util.*;

public class _3_로그파일_재정렬_내풀이 {
    public static void main(String[] args) {
        //["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
        String[] strs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        String[] results = reorderLogFiles(strs);
        System.out.println(Arrays.toString(results));
    }
    public static String[] reorderLogFiles(String[] logs) {
        PriorityQueue<StrLog> strLogList = new PriorityQueue<>(
                (x,y)-> x.log.compareTo(y.log) == 0 ? x.id.compareTo(y.id) : x.log.compareTo(y.log)
        );

        ArrayList<String> digitList = new ArrayList<>();

        for(String str : logs){
            String[] strs = str.split(" ");
            if(Character.isDigit(strs[1].charAt(0))){
                digitList.add(str);
            }else{
                StrLog strLog = new StrLog(strs);
                strLogList.add(strLog);
            }
        }


        String[] results = new String[strLogList.size() + digitList.size()];
        int idx = 0;
        while(!strLogList.isEmpty()){
            StrLog strLog = strLogList.poll();
            results[idx++] = strLog.toString();
        }
        for(int i = 0; i<digitList.size(); i++){
            results[idx++] = digitList.get(i);
        }

        return results;
    }

    static class StrLog{
        public String id;
        public String log;
        StrLog(String[] strs){
            id = strs[0];
            StringBuilder sb =new StringBuilder();
            for(int i = 1; i<strs.length; i++){
                sb.append(strs[i]);
                if(i != strs.length-1){
                    sb.append(" ");
                }
            }
            log = sb.toString();
        }
        public String toString(){
            return id +" " +log;
        }
    }
}
