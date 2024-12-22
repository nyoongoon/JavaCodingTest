package _2_Java_Algo_Interview._1_문자열;

import java.util.*;
// str.split(regex, limit) 기억하기 !
// list.toArray(new String[0]); // List -> Array 변환 기억하기 !
/**
 * str.split(String regex, int limit); -> 이 메서드 암기
 * <p>
 * String target = "1-2-3--5-6---";
 * <p>
 * -> limit = 0 (뒤에 값이 빈 값이면 생략) (limit 생략시 기본값)
 * --> System.out.println(Arrays.toString(target.split("-", 0)));
 * ---> [1, 2, 3, , 5, 6]
 * <p>
 * -> limit > 0 (limit 개수만큼만 배열되고 마지만 요소는 이어붙임)
 * --> System.out.println(Arrays.toString(target.split("-", 5)));
 * ---> [1, 2, 3, , 5-6---]
 * <p>
 * -> limit < 0 (limit 뒤에 빈값이여도 배열 요소로 생성)
 * --> System.out.println(Arrays.toString(target.split("-", -1)));
 * ---> [1, 2, 3, , 5, 6, , , ]
 */
public class _3_로그파일_재정렬_책풀이 {
    public static void main(String[] args) {
        //["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
        String[] strs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        String[] results = reorderLogFiles(strs);
        System.out.println(Arrays.toString(results));
    }

    public static String[] reorderLogFiles(String[] logs) {
        ArrayList<String> strList = new ArrayList<>();
        ArrayList<String> digitList = new ArrayList<>();

        for(String str : logs){
            if(Character.isDigit(str.split(" ")[1].charAt(0))){
                digitList.add(str);
            }else{
                strList.add(str);
            }
        }

        strList.sort(
                (x, y) -> {
                    String[] xStrs = x.split(" ", 2);
                    String[] yStrs = y.split(" ", 2);

                    int compare = xStrs[1].compareTo(yStrs[1]);
                    if(compare == 0){
                        return xStrs[0].compareTo(yStrs[0]);
                    }else{
                        return compare;
                    }
                }
        );

        strList.addAll(digitList);
        return strList.toArray(new String[0]); // List -> Array 변환 기억하기 !
    }
}
