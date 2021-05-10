import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CacaoTuple {
    public int[] solution(String s){
        //중복 검사하기 위해 set
        Set<String> set = new HashSet<String>();
        //정규식, replaceAll(),split(),trim() 알아두기
        String[] strings = s.replaceAll("[{]"," ").replaceAll("[}]", " ").trim().split(" , ");
        //길이로 정렬
        int[] answer = new int[strings.length];
        Arrays.sort(strings, (a, b)->a.length() - b.length());
        int idx = 0;
        for(String arr : strings){
            String[] string2 = arr.split(",");
            for(String str : string2){
                if(set.add(str)){
                    answer[idx++] = Integer.parseInt(str);
                }
            }
        }

        return answer;
    }
}
