package _2_Java_Algo_Interview._1_문자열;

public class _2_문자열뒤집기_내풀이_책풀이 {
    public static void main(String[] args) {
        char[] s = {'r', 'a', 'c', 'e', 'c', 'a', 'r'};
        reverseString(s);
    }

    public static void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while (start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;

            start++;
            end--;
        }
    }
}
