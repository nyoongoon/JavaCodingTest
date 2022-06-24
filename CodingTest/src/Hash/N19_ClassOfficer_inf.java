package Hash;

import java.util.HashMap;
import java.util.Scanner;

public class N19_ClassOfficer_inf { // 강의 문제 풀이
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        int n = stdIn.nextInt();
        String s = stdIn.next();
        char answer = ' ';
        HashMap<Character, Integer> map = new HashMap<>();

        for(char x : s.toCharArray()){ //향상된 for문과 toCharArray()로 더 간단하게 !!!
            map.put(x, map.getOrDefault(x, 0)+1);  //getOrDefault() 기억하기 !!!
        }



        int max  = Integer.MIN_VALUE;
        for(char key: map.keySet()){    //향상된 for문과 map.keySet() 으로 간단하게 !!!
            if(map.get(key) > max){
                max = map.get(key);
                answer = key;
            }
        }

        System.out.println(answer);
    }
}
