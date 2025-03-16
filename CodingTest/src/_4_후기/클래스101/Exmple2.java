package _4_후기.클래스101;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exmple2 {
    public static void main(String[] args) {
        System.out.println(solution("7"));
    }
    public static int solution(String S) {
        String s = S;

        int len = s.length();
        int limit = (int)Math.pow(10, len) - 1;

//        if(len == 1){
//            return 3;
//        }

        Set<Integer> set = new HashSet<>();
        for(int i = 3; i < limit; i += 3){
            set.add(i);
        }

         for(int n : set){
             System.out.println("n == " + n);
         }

        int result = 0;
        Set<Integer> all = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            List<Integer> nums = getNums(i, s);
            all.addAll(nums);
        }

        for(Integer num : all){
            if(set.contains(num)){
                result++;
            }
        }
        return result;
    }

    public static List<Integer> getNums(int idx, String s){
        List<Integer> nums = new ArrayList<>();
        char[] chars = s.toCharArray();
         System.out.println(chars);
        for(int i = 0; i<= 9; i++){
            chars[idx] = (char) (i + '0');
            String str = new String(chars);
             System.out.println("str == " + str);
            nums.add(Integer.parseInt(str));
        }
        return nums;
    }
}
