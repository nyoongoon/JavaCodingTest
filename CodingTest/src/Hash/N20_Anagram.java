package Hash;

import java.util.HashMap;
import java.util.Scanner;

public class N20_Anagram {
    public static void main(String[] args){
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        Scanner stdIn = new Scanner(System.in);

        String str1 = stdIn.nextLine();
        String str2 = stdIn.nextLine();
        String answer = "YES";

        for(char c : str1.toCharArray()){
            if(map1.containsKey(c)){
                map1.put(c, map1.get(c)+1);
            }else{
                map1.put(c, 1);
            }
        }

        for(char c : str2.toCharArray()){
            if(map2.containsKey(c)){
                map2.put(c, map2.get(c)+1);
            }else{
                map2.put(c, 1);
            }
        }

        for(char c : map1.keySet()){
            if(map1.get(c) != map2.get(c)){
                answer = "NO";
                break;
            }
        }

        System.out.println(answer);
    }
}
