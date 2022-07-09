package Hash;

import java.util.HashMap;
import java.util.Scanner;

public class N22_FindAllAnagram_inf { // 강의 풀이 => 접근법은 같은데 맵 비교 함수를 사용 !!!  * map.equals() *
    public static void main(String[] args){
        HashMap<Character, Integer> am = new HashMap<>();
        HashMap<Character, Integer> bm = new HashMap<>();

        Scanner stdIn = new Scanner(System.in);
        String a = stdIn.nextLine();
        String b = stdIn.nextLine();
        int answer = 0;

        //b 미리 셋팅
        for(char x : b.toCharArray()){
            bm.put(x, bm.getOrDefault(x, 0) + 1);
        }

        int l = b.length()-1;
        for(int i = 0; i<l; i++){ // 맨마지막 인덱스는 이곳에서 처리 x => 투포인터를 위해
            am.put(a.charAt(i), am.getOrDefault(a.charAt(i), 0) + 1); //str.charAt()으로 String에서 char 바로 접근 !
        }
        int lt = 0;
        for(int rt = l; rt<a.length(); rt++){ // 이곳에서 슬라이딩 윈도우
            am.put(a.charAt(rt), am.getOrDefault(a.charAt(rt), 0) + 1 ); // rt 카운팅 => 비교
            if(am.equals(bm)){
                answer++;
            }
            am.put(a.charAt(lt), am.get(a.charAt(lt))-1);
            if(am.get(a.charAt(lt))==0){
                am.remove(a.charAt(lt));
            }
            lt++;
        }
    }
}
