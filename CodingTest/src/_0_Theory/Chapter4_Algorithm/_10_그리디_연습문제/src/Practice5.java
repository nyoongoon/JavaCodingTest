package _0_Theory.Chapter4_Algorithm._10_그리디_연습문제.src;// Practice
// 정수 num 이 주어졌을 때,
// num 숫자에서 두 자리를 최대 한번만 교체하여 얻을 수 있는 최대값을 출력하세요.

// 입출력 예시
// num: 2736
// 출력: 7236

// 입력: 7116
// 출력: 7611

public class Practice5 {
    public static int solution(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int max = Integer.MIN_VALUE;
        int[] maxArr = new int[chars.length];
        for (int i = chars.length - 1; i >= 0; i--) {
            max = Math.max(max, chars[i] - '0');
            maxArr[i] = max;
        }

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] - '0' < maxArr[i]) {
                // 원본 idx 찾기
                for (int j = maxArr.length - 1; j >= 0; j--) {
                    if (maxArr[i] == maxArr[j]) {
                        swap(chars, i, j);
                        return Integer.parseInt(String.valueOf(chars));
                    }
                }
            }
        }
        return  num;
    }

    private static void swap(char[] chars, int originIdx, int targetIdx) {
        char tmp = chars[originIdx];
        chars[originIdx] = chars[targetIdx];
        chars[targetIdx] = tmp;
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution(2736));
        System.out.println(solution(7116));
        System.out.println(solution(91));
    }
}
