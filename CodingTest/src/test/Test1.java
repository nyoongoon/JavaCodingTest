package test;

import java.util.HashSet;
import java.util.Set;

public class Test1 {
    public static void main(String[] args) {

        System.out.println(solution(new int[]{0, 0, 1, 1}, new int[]{2})); // 3
        System.out.println(solution(new int[]{0, 0, 0, 0, 2, 3, 3}, new int[]{2, 5, 6})); // 5
        System.out.println(solution(new int[]{0, 0, 1, 2}, new int[]{1, 2})); // 3
        System.out.println(solution(new int[]{0, 3, 0, 0, 5, 0, 5}, new int[]{4, 2, 6, 1, 0})); // 7
    }

    static Set<Integer> set;
    static int result;

    public static int solution(int[] T, int[] A) {
        result = 1;
        set = new HashSet<>();
        // Implement your solution here

        set.add(0);
        for (int target : A) {
            recur(T, target);
        }

        return result;
    }

    public static void recur(int[] arr, int target){
        if(set.contains(target)){
            return;
        }else{
            recur(arr, arr[target]);
            result += 1;
//            System.out.println(target);
            set.add(target);
        }
    }
}
