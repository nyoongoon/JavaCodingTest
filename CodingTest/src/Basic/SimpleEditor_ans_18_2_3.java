package Basic;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.LinkedList;

public class SimpleEditor_ans_18_2_3 {
    public static String solution(String input, String cmd) {
        // 문자열이 빈번히 변경되므로 스트링 버퍼 사용
        StringBuffer sb = new StringBuffer(input);
        ArrayList<String> cmdArr = new ArrayList<>();

        for(String s : cmd.split(" ")){
            cmdArr.add(s);
        }

        int curSor = sb.length();
        int cmdIdx = 0;
        while(cmdIdx != cmdArr.size()){
            String cur = cmdArr.get(cmdIdx);
            if(cur.equals("L")){
                curSor = Math.max(0, curSor - 1);
            }else if(cur.equals("D")){
                curSor = Math.min(sb.length(), curSor+1);
            }else if(cur.equals("B")){
                if(curSor == 0){
                    cmdIdx++;
                    continue;
                }
                sb.delete(curSor-1, curSor);
                curSor = Math.max(0, curSor-1);
            }else if(cur.equals("P")){
                String s = cmdArr.get(++cmdIdx);
                sb.insert(curSor, s);
                curSor +=1;
            }
            cmdIdx++;

        }

        return sb.toString();
    }

    public static void main(String[] args) {
        // test code
        System.out.println(solution("aba", "L B"));
        System.out.println(solution("abcd", "P x L P y"));
        System.out.println(solution("abc", "L L L P x L B P y"));
        System.out.println(solution("a", "B B L L D D P a P b P c"));
    }
}
