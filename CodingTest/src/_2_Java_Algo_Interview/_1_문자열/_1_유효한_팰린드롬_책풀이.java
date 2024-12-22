package _2_Java_Algo_Interview._1_문자열;

/**
 * 자바에서 제공하는 메서드 기억하기
 * Charater.toLowerCase(); //소문자로 변환
 * Charater.isLetterOrDigit(); //영숫자인지
 */
public class _1_유효한_팰린드롬_책풀이 {
    public static void main(String[] args) {
        boolean result = isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(result);
    }

    public static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;

        while(start < end){
            if(!Character.isLetterOrDigit(s.charAt(start))){
                start++;
            }else if(!Character.isLetterOrDigit(s.charAt(end))){
                end--;
            }else{
                if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))){
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }
}
