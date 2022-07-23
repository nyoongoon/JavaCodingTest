package Basic;

import java.util.ArrayList;
import java.util.Arrays;

public class PrintDuplications_18_3_2 {
    public static ArrayList<Integer> solution(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> al = new ArrayList<>();
        int prevNum = 0;
        for(int n : nums){
            if(n == prevNum){
                al.add(prevNum);
            }else{
                prevNum = n;
            }
        }
        return al;
    }

    public static void main(String[] args) {
        // Test code
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(solution(nums));

        nums = new int[]{1, 1, 2};
        System.out.println(solution(nums));

        nums = new int[]{1, 3, 1, 3, 5, 5};
        System.out.println(solution(nums));
    }
}
