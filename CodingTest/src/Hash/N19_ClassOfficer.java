package Hash;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class N19_ClassOfficer {
    public static void main(String[] args) {
        HashMap<Character, Integer> map = new HashMap<>();
        Scanner stdIn = new Scanner(System.in);
        int n = stdIn.nextInt();
        String str = stdIn.next();
        char[] chars = str.toCharArray();
        int max = Integer.MIN_VALUE;
        char chef = ' ';

        for(int i = 0; i<n; i++){
            if(map.containsKey(chars[i])){ // 있는 경우
                map.put(chars[i], map.get(chars[i])+1);
            }else{//없는 경우
                map.put(chars[i], 1);
            }
        }

        Iterator<Character> keys = map.keySet().iterator();


        while(keys.hasNext()){
            Character key = keys.next();
            Integer num = map.get(key);
            max = Math.max(max, num);
            if(max == num){
                chef = key;
            }
        }

        System.out.println(chef);
    }
}
