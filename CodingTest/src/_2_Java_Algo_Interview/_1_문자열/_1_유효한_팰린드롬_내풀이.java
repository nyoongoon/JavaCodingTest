package _2_Java_Algo_Interview._1_문자열;

public class _1_유효한_팰린드롬_내풀이 {
    public static void main(String[] args) {
        boolean result = isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(result);
    }

    public static boolean isPalindrome(String s) {
        String str = clean(s); //lower, 공백제거
        // System.out.println((int)'Z'); //90
        // System.out.println((int)'a'); //97
        // System.out.println((int) '0'); //48
        // System.out.println((int) '9'); //57
        return check(str);
        // return true;
    }

    public static String clean(String str){
        StringBuilder sb= new StringBuilder();

        for(int i =0; i<str.length(); i++){
            char c = str.charAt(i);

            if(48 <= (int)c && 57 >= (int)c){
                sb.append(c);
            }

            if((65 <= (int)c && 90 >= (int)c) || (97 <= (int)c && 122 >= (int)c)){
                c = Character.toLowerCase(c);
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static boolean check(String str){
        System.out.println(str);
        int p1 = 0;
        int p2 = str.length()-1;

        while(p1 < p2){
            char frontChar = str.charAt(p1);
            char backChar = str.charAt(p2);

            if(frontChar != backChar){
                return false;
            }
            p1++;
            p2--;
        }

        return true;
    }
}
