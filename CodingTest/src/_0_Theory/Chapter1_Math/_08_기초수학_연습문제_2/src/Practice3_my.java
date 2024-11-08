package _0_Theory.Chapter1_Math._08_기초수학_연습문제_2.src;

import java.util.ArrayList;

public class Practice3_my {
    public static String solution(String equation) {
        int[] resultArr = evaluate(equation);

        if (resultArr[0] == 0) {
            return "Infinite solutions";
        }

        return "x = " + (-1 * resultArr[1] / resultArr[0]);
    }

    public static int[] evaluate(String str) { // x 하나인 경우 처리 못함
        int[] result = new int[2];
        int sign = 1;
        // 숫자 발견 시 앞, 뒤 조사
        ArrayList<Character> al1 = new ArrayList<>();
        ArrayList<Character> al2 = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            al1.add(str.charAt(i));
        }

        // x 단독
        int i = 0;
        while (i < al1.size()) {
            if (al1.get(i) == 'x') {
                int tmp = 0;
                if (i == 0 ||
                        al1.get(i - 1) == '+' ||
                        al1.get(i - 1) == '=') {

                    result[0] += sign * 1;
                    al1.remove(i);
                    if (i != 0 && al1.get(i - 1) == '+') {
                        al1.remove(i - 1);
                        i--;
                    }
                }
                if (i != 0 && al1.get(i - 1) == '-') {
                    result[0] += sign * -1;
                    al1.remove(i);
                    al1.remove(i - 1);
                }
                // 음수 양수 계산은 밑에서...
            }
            if (i < al1.size() && al1.get(i) == '=') {
                sign = -1;
            }
            i++;
        }
//        System.out.println("result[0] == " + result[0]); //x는 된듯?
//        System.out.println("result[1] == " + result[1]);           
        for (int j = 0; j < al1.size(); j++) {
            System.out.println(al1.get(j));
        }
        sign = 1;
        for (i = 0; i < al1.size(); i++) {
//            if (i == 0 && al1.get(i) == 'x' ||
//                    al1.get(i) == 'x' && Character.isDigit(al1.get(i - 1)))

                if (Character.isDigit(al1.get(i))) {
                    int tmp = 0;
                    // 앞
                    if (i == 0 || al1.get(i - 1) == '+') {
                        tmp = sign * (al1.get(i) - '0');
                    }

                    if (i > 0 && al1.get(i - 1) == '-') {
                        tmp = -1 * sign * (al1.get(i) - '0');
                    }

                    // 뒤
                    if (i < al1.size() - 1 && al1.get(i + 1) == 'x') {
                        result[0] += tmp;
//                        System.out.println(result[0]);
                    } else {
                        result[1] += tmp;
                    }

                }

            if (al1.get(i) == '=') {
                sign = -1;
            }

        }


//        System.out.println("result[0] == " + result[0]); //x는 된듯?
//        System.out.println("result[1] == " + result[1]);

        return result;
    }


    public static int[] evaluate3(String str) { // x 하나인 경우 처리 못함
        int[] result = new int[2];
        int sign = 1;
        // 숫자 발견 시 앞, 뒤 조사
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i == 0 && chars[i] == 'x' ||
                    chars[i] == 'x' && Character.isDigit(chars[i - 1]))

                if (Character.isDigit(chars[i])) {
                    int tmp = 0;
                    // 앞
                    if (i == 0 || chars[i - 1] == '+') {
                        tmp = sign * (chars[i] - '0');
                    }

                    if (i > 0 && chars[i - 1] == '-') {
                        tmp = -1 * sign * (chars[i] - '0');
                    }

                    // 뒤
                    if (i < chars.length - 1 && chars[i + 1] == 'x') {
                        result[0] += tmp;
                        System.out.println(result[0]);
                    } else {
                        result[1] += tmp;
                    }

                }

            if (chars[i] == '=') {
                sign = -1;
            }

        }

        System.out.println("result[0] == " + result[0]);
        System.out.println("result[1] == " + result[1]);
        return result;
    }


    // # 2 정규표현식 사용
    public static int[] evaluate2(String str) {
        return null;
    }

    public static void main(String[] args) {
        // Test code
//        String equation = "x+5-3+x=6+x-2";
//        System.out.println(solution(equation));

//        equation = "x=x";
//        System.out.println(solution(equation));

        String equation = "2x=x";
        System.out.println(solution(equation));
    }
}
