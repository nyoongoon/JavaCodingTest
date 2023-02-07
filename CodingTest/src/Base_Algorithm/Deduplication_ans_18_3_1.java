package Base_Algorithm;

public class Deduplication_ans_18_3_1 {
    public static void solution(int[] nums) {
        int idx = 0;
        for(int num : nums){
            if(idx == 0 || num > nums[idx-1]){
                nums[idx++] = num;
            }
        }// ..끝..??

        for (int i = 0; i < idx; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void main(String[] args) {
        // Test code
        solution(new int[] {1, 1, 2});
        solution(new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
    }
}
