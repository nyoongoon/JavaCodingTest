package _Theory.Chapter4_Algorithm._08_투포인터_연습문제.src;// Practice
// 문자열 s 를 거꾸로 출력하는 프로그램을 작성하세요.
// 단, 각 단어의 알파벳 순서는 그대로 출력합니다.
// 문장에 공백이 여러개일 시, 단어와 단어 사이 하나의 공백을 제외한 나머지 공백은 제거하세요.

// 입출력 예시
// 문자열 s: "the sky is blue"
// 출력: "blue is sky the"

// 문자열 s: "  hello      java    "
// 출력: "java hello"


public class Practice3_ans {
    public static String solution(String s) {
        s = removeWhiteSpace(s);
        String reversed = reverseString(s.toCharArray(), 0, s.length() - 1);
        String result = reverseWords(reversed);

        return result;
    }

    private static String removeWhiteSpace(String s) {
        char[] chars = s.toCharArray();
        int p1 = 0;
        int p2 = 0;

        /**
         * 문자열 trim하는 테크닉 기억하기..
         */
        while (p2 < chars.length) {
            while (p2 < chars.length && chars[p2] == ' ') {
                p2++;
            }
            while (p2 < chars.length && chars[p2] != ' ') {
                chars[p1++] = chars[p2++];
            }
            while (p2 < chars.length && chars[p2] == ' ') {
                p2++;
            }

            if (p2 < chars.length) {
                chars[p1++] = ' ';
            }
        }

        return String.valueOf(chars).substring(0, p1);
    }

    private static String reverseString(char[] chars, int p1, int p2) {
        while (p1 < p2) {
            char tmp = chars[p1];
            chars[p1] = chars[p2];
            chars[p2] = tmp;

            p1++;
            p2--;
        }
        return String.valueOf(chars);
    }

    private static String reverseWords(String reversed) {
        char[] chars = reversed.toCharArray();
        int p1 = 0;
        int p2 = 0;

        while (p2 < chars.length) {

            while (p2 < chars.length && chars[p2] != ' ') { //p2가 공백을 만나면 멈춤
                p2++;
            }
            reverseString(chars, p1, p2 - 1);
            p2++;
            p1 = p2;
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution("the sky is blue"));
        System.out.println(solution("  hello      java    "));

    }
}
