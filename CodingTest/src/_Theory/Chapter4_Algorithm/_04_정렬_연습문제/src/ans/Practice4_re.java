package _Theory.Chapter4_Algorithm._04_정렬_연습문제.src.ans;// Practice4
// 정수 배열 nums 가 주어졌을 때
// 오름차순으로 정렬하기 위해 배열 내에서 정렬이 필요한 구간의 길이를 출력하는 프로그램을 작성하세요.

// 입출력 예시
// 입력: 2, 6, 4, 8, 5, 3, 9, 10
// 출력: 5

// 입력: 1, 3, 1
// 출력: 2
// 틀렸음, 더 좋게 푸는 방법 있음..
public class Practice4_re {
    public static int solution(int[] nums) { //틀려서 다시 품.. -> startIdx의 값보다 큰 것이 아니라 중간에 가장 큰 값..
        int startIdx = 0;
        int endIdx = 0; // max 보다 크면서 이후로 작은 값이 없는 것이 endIdx..

        startIdx = getStartIdx(nums);

        if(startIdx == -1){
            return 0;
        }

        endIdx = getEndIdx(nums, startIdx);

        return endIdx - startIdx + 1;
    }

    public static int getStartIdx(int[] nums) {
        int startIdx = -1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                startIdx = i;
                break;
            }
        }
        return startIdx;
    }

    public static int getEndIdx(int[] nums, int startIdx) {
        int max = nums[startIdx];
        int endIdx = nums.length - 1;

        for (int i = startIdx + 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i] && max < nums[i]) {
                if (isOrdered(nums, i)) {
                    System.out.println("last max == " + max); // --> 1번 문제의 8이 나와야 함..
                    endIdx = i - 1;
                    break;
                }else{
                    max = Math.max(max, nums[i]);
                }
            }
        }

        return endIdx;
    }

    public static boolean isOrdered(int[] nums, int idx) {
        for (int i = idx; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Test code
        int[] nums = {2, 6, 4, 8, 5, 3, 9, 10};
        System.out.println(solution(nums));

        nums = new int[]{1, 3, 1};
        System.out.println(solution(nums));

        nums = new int[]{1, 9, 3, 4, 5};
        System.out.println(solution(nums));

        nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(solution(nums));
    }
}
