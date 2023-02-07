package Base_Algorithm;

public class Palindrome {
    public static int solution(String str) {
        int i = -1;

        int result = isPalindrome(0, str.length() - 1, str.toCharArray(), i);
        if (result == 0) {
            return 0;
        }

        for (i = 0; i < str.length(); i++) {
            result = isPalindrome(0, str.length() - 1, str.toCharArray(), i);
            if (result == 0) {
                return 1;
            }
        }

        return 2;
    }

    public static int isPalindrome(int left, int right, char[] arr, int delCnt) {
        while(left < right){
            //System.out.println("무한");
            if(left == delCnt){
                left++;
            }
            if(right == delCnt){
                right--;
            }

            if(arr[left] != arr[right]){
                return -1;
            }
            left++;
            right--;
        }

        return 0;
    }

    public static void main(String[] args) {
        // Test code
        String[] str = {"abba", "summuus", "xabba", "xabbay", "comcom", "comwwmoc", "comwwtmoc"};
        System.out.println(solution("abba"));
        System.out.println(solution("summuus"));
        System.out.println(solution("xabba"));
        System.out.println(solution("xabbay"));
        System.out.println(solution("comcom"));
        System.out.println(solution("comwwmoc"));
        System.out.println(solution("comwwtmoc"));
    }
}
