package _2_Java_Algo_Interview._1_문자열;

public class _6_가장_긴_팰린드롬_부분_문자열_내풀이 {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        int maxLen = Integer.MIN_VALUE;
        String longest = null;

        if (s.length() < 2) {
            return s;
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j > i; j--) {

                if (j - i < maxLen) {
                    continue;
                }
                if (palCheck(s, i, j)) {
                    String palindrome = s.substring(i, j + 1);
                    maxLen = Math.max(maxLen, palindrome.length());
                    longest = palindrome;
                }
            }
        }


        if (longest == null) {
            return String.valueOf(s.charAt(0));
        }

        return longest;
    }


    public static boolean palCheck(String s, int startIdx, int endIdx) {

        while (startIdx < endIdx) {
            if (s.charAt(startIdx) == s.charAt(endIdx)) {
                startIdx++;
                endIdx--;
            } else {
                return false;
            }
        }

        return true;
    }
}

