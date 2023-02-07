package Base_Algorithm;

import java.util.HashMap;

public class RomanNumerals {
    public static void solution(String s) {
        // 다음 문자가 작은값인지 큰 값인지 판단
        // 다음 문자가 작은 값이면 그대로 합
        // 다음문자가 큰값이면 2개로 판단

        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);

        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i < s.length()-1 && map.get( String.valueOf(s.charAt(i))) < map.get(String.valueOf(s.charAt(i + 1))) ) {
                result +=  map.get(String.valueOf(s.charAt(i)) + (s.charAt(i + 1)));
                i++;
            }else{
                result += map.get(String.valueOf(s.charAt(i)));
            }
        }
        System.out.println(result);

   /*   I	1
        V	5
        X	10
        L	50
        C	100
        D	500
        M	1000
        IV: 4, IX: 9
        XL: 40, XC: 90
        CD: 400, CM: 900
        */
    }

    public static void main(String[] args) {
        // Test code
        solution("III");
        solution("IV");
        solution("VI");
        solution("XIII");
        solution("XXVI");
        solution("MCMXCIV");
    }
}
