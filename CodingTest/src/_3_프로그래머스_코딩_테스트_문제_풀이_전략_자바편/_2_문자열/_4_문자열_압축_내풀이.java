package _3_프로그래머스_코딩_테스트_문제_풀이_전략_자바편._2_문자열;

public class _4_문자열_압축_내풀이 {
    class Solution {
        public int solution(String s) {

            int unit = s.length() / 2;

            while(unit > 0){
                int len = getUnitCnt(s, unit);
                if(len != -1){
                    return len;
                }
                unit--;
            }



            return s.length();
        }

        public int getUnitCnt(String s, int unit){
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < s.length(); i ++){
                StringBuilder sb = new StringBuilder(s);
                String tmp = null;
                int cnt = 0;
                for(int j = i; j < sb.length(); j += unit){

                    //todo if .. j 최적화..
                    if(j + unit <= sb.length()){
                        String subStr = sb.substring(j, j + unit);
                        System.out.println("unit == " + unit);
                        System.out.println(subStr);
                        if(tmp == null){
                            tmp = subStr;
                            continue;
                        }
                        if(tmp.equals(subStr)){

                        }else{

                        }
                    }
                }

            }

            return -1;
        }
    }
}
