package Base_Algorithm;

import java.util.ArrayList;

public class PrintDuplications_re_18_3_2 {
    public static ArrayList<Integer> solution(int[] nums) {
        // 값을 곧 인덱스로 활용함 !!!
        // (중복확인 -> (두번 중복이므로) -> 음수를 곱해서 인덱스로 활용할땐 절댓값 사용, 음수로 중복 판단 !!! ...

        ArrayList<Integer> al = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i])-1;
            if(nums[idx] < 0){
                al.add(idx+1);
            }else{
                nums[Math.abs(nums[i])-1] *= -1;
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
