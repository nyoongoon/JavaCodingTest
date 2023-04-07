package Base_Algorithm.Chapter1_Math.Math_09_2.src;

public class Practice3 {
    public static String solution(String equation) {
        int x = 0;
        int con = 0;
        int[] resultArr1 = evaluate(equation.split("=")[0]);
        int[] resultArr2 = evaluate(equation.split("=")[1]);
        x += resultArr1[0] - resultArr2[0];
        con += -resultArr1[1] + resultArr2[1];
        if (x == 0){
            return "INF";
        }
        return "x = " + con / x;
    }

    public static int[] evaluate(String str) {
        int[] result = new int[2];
        char[] chars = str.toCharArray();
        boolean isMinus = false;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '-') {
                isMinus = true;
            } else if (chars[i] == '+') {
                isMinus = false;
            } else if (chars[i] == 'x') {
                int tmp = (isMinus) ? -1 : 1;
                result[0] += tmp;
            } else {
                int tmp = 0;
                if (i < chars.length - 1 && chars[i + 1] == 'x') {
                    tmp = (isMinus) ? -1 * (chars[i] - '0' -1) : (chars[i] - '0' -1);
                    result[0] += tmp;
                } else {
                    tmp = (isMinus) ? -1 * (chars[i] - '0') : (chars[i] - '0');
                    result[1] += tmp;
                }
            }
        }
        return result;
    }


    // # 2 정규표현식 사용
    public static int[] evaluate2(String str) {
        return null;
    }

    public static void main(String[] args) {
        // Test code
        String equation = "x+5-3+x=6+x-2";
        System.out.println(solution(equation));

        equation = "x=x";
        System.out.println(solution(equation));

        equation = "2x=x";
        System.out.println(solution(equation));
    }
}
