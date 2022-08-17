package Basic;

public class LinearEquation {
    public static String solution(String equation) {
        String[] strs = equation.split("=");
        int xCons = 0;
        int cons = 0;
        int[] before = evaluate(strs[0]);
        for (int i = 0; i < before.length; i++) {
            System.out.println(before[i]);
        }
        int[] after = evaluate(strs[1]);
        for (int i = 0; i < after.length; i++) {
            System.out.println(after[i]);
        }

        xCons += before[0];
        xCons -= after[0];

        cons -= before[1];
        cons += after[1];

        try{
            System.out.println("x=" + cons/xCons);
        }catch (ArithmeticException e){
            if(xCons == 0){
                System.out.println("Infinite solutions");
            }else{
                System.out.println("No solution");
            }
        }
        return "";
    }

    public static int[] evaluate(String str) {
        int[] arr = new int[2];
        int isMinus = 1; // true면 1
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == 'x'){
                arr[0] += 1*isMinus;
                isMinus = 1;
            }else if(c == '-'){
                isMinus = -1;
            }else if (c == '+'){
                isMinus = 1;
            }else{
                if(i<str.length()-1 && str.charAt(i+1) == 'x'){
                    arr[0] += (c - '0') * isMinus;
                    i++;
                }else{
                    arr[1] += (c - '0') * isMinus;
                    isMinus = 1;
                }
            }
        }
        return arr;
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
