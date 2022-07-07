package Hash;

import java.util.HashMap;
import java.util.Scanner;

public class N21_Anagram_inf {
    public static void main(String[] args){
        HashMap<Character, Integer> map = new HashMap<>();
        String answer = "YES";

        Scanner stdIn = new Scanner(System.in);

        String s1 = stdIn.nextLine();
        String s2 = stdIn.nextLine();

        for(char x : s1.toCharArray()){
            map.put(x, map.getOrDefault(x, 0)+1);
        }

        for(char x : s1.toCharArray()){
            if(!map.containsKey(x) || map.get(x) == 0){
                answer = "NO";
            }else{
                map.put(x, map.get(x)-1); // 두번째 map 생성하지 않고 첫번째 map에서 계산 가능 !!!
            }
        }

        System.out.println(answer);
    }
}
