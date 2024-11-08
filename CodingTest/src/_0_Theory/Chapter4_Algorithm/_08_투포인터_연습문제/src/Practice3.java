package _0_Theory.Chapter4_Algorithm._08_투포인터_연습문제.src;// Practice
// 문자열 s 를 거꾸로 출력하는 프로그램을 작성하세요.
// 단, 각 단어의 알파벳 순서는 그대로 출력합니다.
// 문장에 공백이 여러개일 시, 단어와 단어 사이 하나의 공백을 제외한 나머지 공백은 제거하세요.

// 입출력 예시
// 문자열 s: "the sky is blue"
// 출력: "blue is sky the"

// 문자열 s: "  hello      java    "
// 출력: "java hello"


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Practice3 {
    public static String solution(String s) {
        List<Character> charList = s.chars()
                .mapToObj(c -> (char) c).collect(Collectors.toList());

        trimFront(charList);
        trimRear(charList);

        List<String> words = toWords(charList);

        StringBuilder sb = new StringBuilder();
        for (int i = words.size() - 1; i >= 0; i--) {
            sb.append(words.get(i));
            if (i != 0) {
                sb.append(' ');
            }
        }

        return sb.toString();
    }

    private static List<String> toWords(List<Character> charList) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        char beforeChar = ' ';
        for (int i = 0; i < charList.size(); i++) {
            if (charList.get(i) == ' ' || i == charList.size() - 1) {
                if (i != 0 && beforeChar == ' ') {
                    continue;
                }
                if (i == charList.size() - 1) {
                    sb.append(charList.get(i));
                }
                String word = sb.toString();
                if (word != null) {
                    result.add(word);
                    sb = new StringBuilder();
                }
            } else {
                sb.append(charList.get(i));
            }
            beforeChar = charList.get(i);
        }
        return result;
    }

    private static void compare(List<Character> charList, int frontIdx, int rearIdx) {
        while (frontIdx <= rearIdx) {
            if (charList.get(frontIdx) == ' ' && charList.get(rearIdx) == ' ') {
                charList.remove(rearIdx--);
                charList.remove(frontIdx); //프론트인덱스는 삭제해도 그대로
            } else {
                char tmp = charList.get(frontIdx);
                charList.remove(frontIdx);
                rearIdx--;
                charList.add(frontIdx, charList.get(rearIdx));
                rearIdx++;
                charList.remove(rearIdx);
                charList.add(rearIdx, tmp);
                frontIdx++;
                rearIdx--;
            }
        }
    }


    private static void trimFront(List<Character> charList) {
        while (charList.get(0) == ' ') {
            charList.remove(0);
        }
    }

    private static void trimRear(List<Character> charList) {
        for (int i = charList.size() - 1; i >= 0; i--) {
            if (charList.get(i) != ' ') {
                return;
            }
            charList.remove(i);
        }
    }
//
//    public static String removeSpaces(String s) {
//        int p1 = 0;
//        int p2 = 0;
//
//        char[] cArr = s.toCharArray();
//        int length = s.length();
//
//        while (p2 < length) {
//            // 단어 앞 쪽 공백 skip
//            while (p2 < length && cArr[p2] == ' ') {
//                p2++;
//            }
//
//            // 공백 아닌 경우 해당 문자로 채워넣기
//            while (p2 < length && cArr[p2] != ' ') {
//                cArr[p1++] = cArr[p2++];
//            }
//
//            // 단어 뒤쪽 공백 skip
//            while (p2 < length && cArr[p2] == ' ') {
//                p2++;
//            }
//
//            // 단어와 단어 사이 공백 하나는 추가
//            if (p2 < length) {
//                cArr[p1++] = ' ';
//            }
//        }
//
//        // 공백 정리해서 앞쪽부터 채워넣은 부분 문자열 반환
//        return new String(cArr).substring(0, p1);
//    }
//
//    public static void reverseString(char[] cArr, int i, int j) {
//        while (i < j) {
//            char tmp = cArr[i];
//            cArr[i++] = cArr[j];
//            cArr[j--] = tmp;
//        }
//    }

//    public static void reverseWords(char[] cArr, int length) {
//        int p1 = 0;
//        int p2 = 0;
//
//        while (p1 < length) {
//            // p1, p2 로 공백 제외 단어 부분 시작, 끝 설정
//            while (p1 < p2 || p1 < length && cArr[p1] == ' ') {
//                p1++;
//            }
//
//            while (p2 < p1 || p2 < length && cArr[p2] != ' ') {
//                p2++;
//            }
//
//            reverseString(cArr, p1, p2 - 1);
//        }
//    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution("the sky is blue"));
        System.out.println(solution("  hello      java    "));

    }
}
