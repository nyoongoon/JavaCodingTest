package Basic;

import java.util.ArrayList;
import java.util.Arrays;

public class PrintDuplications_ans_18_3_2 { // 강의 풀이 -> 정렬 사용하지 않음 !!!
    public static ArrayList<Integer> solution(int[] nums) {
        // 값을 곧 인덱스로 활용함 !!! (중복확인 -> (두번 중복이므로) -> 음수를 두번 곱하면 양수가 되는 것을 이용하여 중복 판단 !!!@
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1; // abs()<-음수로 바뀌어 있을지도 모른다 ..?

            if(nums[index] < 0){ // 이미 음수면 중복된 것임
                list.add(Math.abs(index + 1)); //위에서 뺸 값 다시 더해주기
            }

            nums[index] = -nums[index];
        }
        
        return list;
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
