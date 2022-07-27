package Math;

public class PowAndSqrt {
    public static double pow(int a, int b){
        double result = 1;
        boolean isMinus = false;

        if(b == 0){
            return 1;
        }else if(b < 0){
            b *= -1;
            isMinus = true;
        }

        for (int i = 0; i < b; i++) {
            result *= a;
        }
        return isMinus ? 1 / result : result;  // 음수 제곱일 땐 나누는 것 !!!
    }

    public static double sqrt(int a){
        double result = 1;
        // 바빌로니아 방법  (cf)뉴튼방법
        // 어떤수 n에 대해 제곱근을 구한다고 하면 ==>
        // 루트 N ==  Xn (어떤수 ) + E (앱실론==굉장히 작은 수)
        // N = (Xn + E)^2 = Xn^2 + 2XnE + E^2 (E는 굉장히 작은 수이므로 생략하기)
        // N == Xn^2 + 2XnE
        // E = N -Xn^2 / 2Xn // 처음에 대입하기
        // 루트 N = Xn + N - Xn^2 /  2Xn
        // = Xn + N / 2Xn - Xn/2
        // = Xn/2 + N/2Xn = 1/2(Xn + N/Xn)
        // Xn+1 = 1/2 (Xn + N / Xn)     => 반복하다보면 찾고자하는 값에 가까워 지도록 하기

        for(int i = 0 ; i< 10; i++){
            result = (result + (a/result)) / 2; // 제곱근 직접 구하는 식 (여러번 계산할 수록 더 근사치 값이 나옴)
        }
        return result /= a;
    }

    public static void main(String[] args) {

//      Test code
        System.out.println("== Math pow ==");
        System.out.println(Math.pow(2, 3));
        System.out.println(Math.pow(2, -3));
        System.out.println(Math.pow(-2, -3));

        System.out.println("== My pow ==");
        System.out.println(pow(2, 3));
        System.out.println(pow(2, -3));
        System.out.println(pow(-2, -3));

        System.out.println("== Math sqrt ==");
        System.out.println(Math.sqrt(16));
        System.out.println(Math.sqrt(8));

        System.out.println("== My sqrt ==");
//        System.out.println(sqrt(16));
//        System.out.println(sqrt(8));

    }
}
