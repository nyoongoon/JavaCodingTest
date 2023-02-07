package Base_Algorithm;

public class Stars_ans {
    public static void solution(int n, int type) {
        if (type == 1) {
            type1(n);
        } else if (type == 2) {
            type2(n);
        } else if (type == 3) {
            type3(n);
        } else if (type == 4) {
            type4(n);
        } else if (type == 5) {
            type5(n);
        }


    }

    public static void type1(int n) {
        System.out.println("== Type1 ==");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

    }

    public static void type2(int n) {
        System.out.println("== Type2 ==");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i+1; j++) {
                System.out.println('*');
            }
        }
        System.out.println();
    }

    public static void type3(int n) {
        System.out.println("== Type3 ==");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(j < n - 1 - i){
                    System.out.print(" ");
                }else{
                    System.out.println("*");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void type4(int n) {
        System.out.println("== Type4 ==");
        for (int i = 0; i <n; i++) {
            //공백 출력 부분
            for (int j = 0; j < n - 1 - i; j++) {
                System.out.println(" ");
            }

            //start
            for (int j = 0; j < i * 2 + 1; j++) {
                System.out.println("*");
            }
            System.out.println();
        }

        System.out.println();
    }

    public static void type5(int n) {
        System.out.println("== Type5 ==");

        //상단부
        for (int i = 0; i <= n/2; i++) {
            //공백
            for (int j = 0; j < n/2-i; j++) { // 좀 다름 -> 절반만 생각
                System.out.println(" ");
            }
            //stars
            for (int j = 0; j < i*2+1; j++) {
                System.out.println("*");
            }
            System.out.println();
        }

        //하단부
        for (int i = n/2; i > 0; i--) {
            for (int j = 0; j < n/2+1-i; j++) { // 어려움;;
                System.out.println(" ");
            }
            for (int j = 0; j < i * 2 -1; j++) { // 어려움;; ==> 공백의 갯수 & 별의 갯수. 최대한 귀납적 수학적으로 풀어보기 !!
                System.out.println("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test code
        solution(3, 1);
        solution(3, 2);
        solution(3, 3);
        solution(3, 4);
        solution(5, 5);
    }
}
