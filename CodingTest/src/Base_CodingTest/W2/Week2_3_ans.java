package Base_CodingTest;

public class Week2_3_ans {
    static int i = 0;

    public static void main(String[] args) {
        String code = "6{a2{b4{c}d}e}f";
        System.out.println(solution(code));
    }

    public static String solution(String code) {

        return recur(code);
    }

    public static String recur(String code) {
        StringBuffer sb = new StringBuffer();
        int num = -1;
        while (i < code.length()) {
            char c = code.charAt(i);
            if(Character.isDigit(c)){
                i++;
                num = c - '0';
            }else if(c == '{'){
                i++;
                String temp = recur(code);
                sb.append(temp.repeat(num));
            }else if(c == '}'){
                i++;
                break;
            }else{
                i++;
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
