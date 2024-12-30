package _2_Java_Algo_Interview._1_문자열;

public class _6_가장_긴_팰린드롬_부분_문자열_내풀이_2 {
    static String longest = "";
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        if(s.length() < 2){
            return s;
        }

        for(int i = 0; i < s.length(); i++){
            getPalindrome(s, i, i + 1);
            getPalindrome(s, i, i + 2);
        }

        return longest.equals("") ? String.valueOf(s.charAt(0)) : longest;
    }

    public static void getPalindrome(String s, int startIdx, int endIdx){
        String substr = "";
        while(startIdx >= 0 && endIdx < s.length()){
            if(s.charAt(startIdx) == s.charAt(endIdx)){
                substr = s.substring(startIdx, endIdx + 1);

                startIdx--;
                endIdx++;

            }else{
                break;
            }
        }

        if(longest.length() < substr.length()){
            longest = substr;
        }
    }
}

