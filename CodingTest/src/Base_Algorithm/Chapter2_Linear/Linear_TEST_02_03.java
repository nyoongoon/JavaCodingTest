package Base_Algorithm.Chapter2_Linear;

public class Linear_TEST_02_03 {

    public static void main(String[] args) {
        String code1 = "5{he2{l}o}friend";
        System.out.println(recur(1, code1));

        String code2 = "f2{a3{bc}}z";  // f abcbcbc abcbcbc z
        System.out.println(recur(1, code2));
    }

    public static String recur(int multiply, String code) {
        // 숫자 제외 재귀 넣고
        // 나오면 } 찾아서 x번 반복해여 붙이기
        String before = "";
        String after = "";
        for (int i = 0; i < code.length(); i++) {
            if (Character.isDigit(code.charAt(i))) { // 문자가 숫자일 경우 -> 재귀 조건
                int nextMultiply = code.charAt(i) - '0';
                before = code.substring(0, i);
                after = recur(nextMultiply, code.substring(i + 2));

                code =  before + after;
            }

            if(code.charAt(i) == '}'){ // 문자가 } 인 경우 -> 종료 조건
                String multipledTarget = multiplyTarget(multiply, code.substring(0, i));
                return multipledTarget + code.substring(i + 1);
            }
        }

        return code;
    }

    public static String multiplyTarget(int mutiply, String target){
        String returnStr = "";
        for (int i = 0; i < mutiply; i++) {
            returnStr += target;
        }
        return returnStr;
    }
}




