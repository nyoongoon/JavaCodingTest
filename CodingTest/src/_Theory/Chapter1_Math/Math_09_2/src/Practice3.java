package _Theory.Chapter1_Math.Math_09_2.src;

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
        boolean isMinus = false;

        for (int i = 0; i < str.length(); i++) {
            int tmpStp = str.charAt(i);

            if(tmpStp == '+'){
                isMinus = false;
            }else if (tmpStp == '-'){
                isMinus = true;
            }else if(tmpStp == 'x'){
                result[0] += (isMinus) ? -1 : 1;
            }else{
                if(i < str.length()-1 && str.charAt(i+1) == 'x'){
                    result[0] += (isMinus) ? -1 * (tmpStp-1) : (tmpStp-1);
                }else{
                    result[1] += (isMinus) ? -1 * tmpStp : tmpStp;
                }
            }
        }
        return result;
    }


    // # 2 정규표현식 사용
    public static int[] evaluate2(String str) {
        int[] result = new int [2];
        for(String s : str.split("(?=[+-])")){
            if(s.equals("+x") || s.equals("x")){
                result[0]++;
            }else if (s.equals("-x")){
                result[0]--;
            }else if(s.contains("x")){
                result[0] += Integer.parseInt(s.substring(0, s.length()-1));
            }else{
                result[1] += Integer.parseInt(s);
            }
        }
        return result;
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
