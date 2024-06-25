package _Theory.Chapter4_Algorithm._08_투포인터_연습문제.src;// Practice
// a, b, c, d 로 이루어진 알파벳 문자열에 대해서
// 다음과 같은 규칙으로 문자열을 정리한 후 남은 문자열을 반환하는 프로그램을 작성하세요.
// 양쪽의 문자를 비교한 후 같으면 삭제하는데, 연속해서 같은 문자가 등장하면 함께 삭제한다.
// 최종적으로 남은 문자열을 반환하세요.

// 입출력 예시
// 입력 s: "ab"
// 출력: "ab"

// 입력 s: "aaabbaa"
// 출력: (없음)

public class Practice1_ans {
    public static String solution(String s) {
        char[] charArray = s.toCharArray();
        int startIdx = 0;
        int rearIdx = charArray.length - 1;

        while (startIdx < rearIdx) {
            char startChar = charArray[startIdx];
            char rearChar = charArray[rearIdx];
            if (startChar != rearChar) {
                break;
            }
            startIdx++;
            rearIdx--;

            while (startIdx <= rearIdx) {
                if (startChar == charArray[startIdx]) {
                    startIdx++;
                } else if (rearChar == charArray[rearIdx]) {
                    rearIdx--;
                } else {
                    break;
                }
            }
        }

        return s.substring(startIdx, rearIdx + 1);
    }


    public static void main(String[] args) {
        // Test code
        System.out.println(solution("ab"));         // ab
        System.out.println(solution("aaabbaa"));    //
        System.out.println(solution("aabcddba"));   // cdd
    }
}
