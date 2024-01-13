package _Theory.Chapter2_Linear.선형자료구조_코딩테스트;

public class Linear_TEST_02_03_ans {
    static int i = 0;

    public static void main(String[] args) {
        String code1 = "5{he2{l}o}friend";
        System.out.println(recur(code1));

        i = 0;
        String code2 = "f2{a3{bc}}z";  // f abcbcbc abcbcbc z
        System.out.println(recur(code2));
    }

    public static String recur(String s) {
        StringBuilder sb = new StringBuilder();
        int num = 1;
        String temp = "";

        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                num = s.charAt(i) - '0';
                i++;
            } else if (s.charAt(i) == '{') {
                i++;
                temp = recur(s);
                sb.append(temp.repeat(num));
            } else if (s.charAt(i) == '}') {
                i++;
                return sb.toString();
            } else {
                sb.append(s.charAt(i));
                i++;
            }
        }

        return sb.toString();
    }


}




