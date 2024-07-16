package LeetCode.투포인터;

/**
 * 팰린드롬은 짝수 / 홀수 케이스 구분하는 것 주의
 */
public class LogestPalindromicSubstring {
    public static void main(String[] args) {
        String input = "dcbabcdd";

        LogestPalindromicSubstring solution = new LogestPalindromicSubstring();
        String output = solution.longestPalindrome(input);
        System.out.println(output); // dcbabcd
    }

    public String longestPalindrome(String s){
        if(s.length() < 2){
            return s;
        }

        String result = s.substring(0, 1); //제일 작은 팰린드롬은 글자 하나 (한글자도 팰린드롬이라고 보는 경우)

        for (int i = 0; i < s.length(); i++) {
            /**
             * 팰린드롬은 짝수 / 홀수 케이스 구분하는 것 주의
             */
            String evenStr = getMaxPalindrome(s, i, i + 1); //짝수
            String oddStr = getMaxPalindrome(s, i, i + 2); //홀수

            String longerStr = evenStr.length() > oddStr.length() ? evenStr : oddStr;
            result = result.length() > longerStr.length() ? result : longerStr;
        }

        return result;
    }

    private String getMaxPalindrome(String s, int left, int right) {
        if(left < 0 || right >= s.length()){
            return "";
        }

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }
}
