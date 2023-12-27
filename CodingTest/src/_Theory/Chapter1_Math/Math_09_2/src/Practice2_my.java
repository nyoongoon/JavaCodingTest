package _Theory.Chapter1_Math.Math_09_2.src;

public class Practice2_my {
    public static int solution(String str) {
        char[] chars = str.toCharArray();
        if (0 == palindrome(chars, -1)) {
            return 0;
        }
        for (int i = 0; i < chars.length; i++) {
            if(1 == palindrome(chars, i)){
                return 1;
            }
        }

        return 2;
    }

    static int palindrome(char[] chars, int delNo) {

        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            if (left == delNo) {
                left++;
                continue;
            }
            if (right == delNo) {
                right--;
                continue;
            }
            if (chars[left] != chars[right]) {
                return 2;
            }
            left++;
            right--;
        }

        if (delNo == -1) {
            return 0;
        }
        return 1;
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
