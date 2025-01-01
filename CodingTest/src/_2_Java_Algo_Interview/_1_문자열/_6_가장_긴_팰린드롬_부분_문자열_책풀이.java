package _2_Java_Algo_Interview._1_문자열;


// maxLen =  endIdx - 1 - (startIdx + 1) +  1;
public class _6_가장_긴_팰린드롬_부분_문자열_책풀이 {
    public static void main(String[] args) {
        longestPalindrome("babad"); //bab
    }
    static int left;
    static int maxLen;
    public static String longestPalindrome(String s) {
        if(s.length() < 2){
            return s;
        }

        for(int i = 0; i< s.length(); i++){
            getPalindrome(s, i, i + 1);
            getPalindrome(s, i, i + 2);
        }

        return s.substring(left, left + maxLen);
    }

    public static void getPalindrome(String s, int startIdx, int endIdx){
        while(startIdx >= 0 && endIdx < s.length() && s.charAt(startIdx) == s.charAt(endIdx)){
            startIdx--;
            endIdx++;
        }

        if(maxLen < endIdx - 1 - (startIdx + 1) + 1){
            left = startIdx + 1;
            maxLen = endIdx - 1 - (startIdx + 1) + 1;
        }
    }
}
