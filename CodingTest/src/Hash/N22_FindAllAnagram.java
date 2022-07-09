package Hash;

import java.util.HashMap;
import java.util.Scanner;

public class N22_FindAllAnagram { // 내풀이 -> 맞춤 !!!
    public static void main(String[] args){

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        Scanner stdIn = new Scanner(System.in);
        String s = stdIn.nextLine();
        String t = stdIn.nextLine();

        char[] chars = s.toCharArray();
        char[] compareChars = t.toCharArray();

        int result = 0;


        for(int i = 0; i < compareChars.length; i++){ // 처음만 계산.
            map1.put(chars[i], map1.getOrDefault(chars[i], 0) + 1);
        }

        for(int i = 0; i<compareChars.length; i++){
            map2.put(compareChars[i], map2.getOrDefault(compareChars[i], 0) + 1);
        }

        for(int j = 0; j<compareChars.length; j++){
            //System.out.println(j);
            if(map1.get(compareChars[j]) != map2.get(compareChars[j])){
                break;
            }else{
                if(j == compareChars.length - 1){

                    //System.out.println(j);
                    result += 1;
                }
            }
        }




        for(int i = 1; i < chars.length - compareChars.length+1; i++){


            map1.put(chars[i-1], map1.getOrDefault(chars[i-1], 1) - 1);
            map1.put(chars[i+compareChars.length-1], map1.getOrDefault(chars[i+compareChars.length-1], 0) + 1);


            for(int j = 0; j<compareChars.length; j++){
                //System.out.println(j);
                if(map1.get(compareChars[j]) != map2.get(compareChars[j])){
                    break;
                }else{
                    if(j == compareChars.length - 1){
                        //System.out.println(i);
                        //System.out.println(j);
                        result += 1;
                    }
                }
            }
        }

        System.out.println(result);




    }
}
