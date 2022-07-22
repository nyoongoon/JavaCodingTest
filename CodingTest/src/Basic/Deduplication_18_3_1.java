package Basic;

public class Deduplication_18_3_1 { // 내 풀이 !!!
    public static void solution(int[] nums) {
        int max = Integer.MIN_VALUE;
        int idx = 0 ;
        int to = 0;
        //int nextIdx = 2;
        while (idx< nums.length) {
            if(nums[idx] > max ){

                max = nums[idx];
                nums[to] = max;
                to++;
            }
            idx++;
        }

        while(to< nums.length){ // 그냥 이부분의 코드 없이 to 인덱스까지 출력하면 될듯
            nums[to++] = -1;
        }

        for(int p : nums){
            if(p != -1){
                System.out.print(p + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test code
        solution(new int[] {1, 1, 2});
        solution(new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
    }
}
