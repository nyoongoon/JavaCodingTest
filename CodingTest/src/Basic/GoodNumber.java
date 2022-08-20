package Basic;

public class GoodNumber {

    public static int solution(long n) {
        long result = 0;
        long min = (long) Math.pow(10, n - 1);
        System.out.println("min == " + min);
        if(min == 1){
            min = 0;
        }
        long max = (long) Math.pow(10, n);
        System.out.println("max == " + max);

        //System.out.println(min);
        //System.out.println(max);
        //System.out.println(isPrime(n));
        for (long i = min; i < max; i++) {
            String str = String.valueOf(i);
            System.out.println();
            System.out.println("str  == "+ str);
            for (int j = 0; j < str.length(); j++) {

                if (j % 2 == 0) { //짝수 인덱스

                    if ((str.charAt(j)-'0') % 2 == 0) { //짝수 인덱스 짝수인경우

                        //pass
                        //System.out.println("짝수");
                    } else {
                        break;
                    }
                } else { // 홀


                    if (isPrime(str.charAt(j)-'0')) {
                        //pass
                        //System.out.println("소수");
                    } else {
                        break;
                    }
                }

                if (j == str.length() - 1) {
                    System.out.println(j+"번째 자리수");
                    System.out.println(str.charAt(j)-'0');
                    System.out.println();
                    result++;
                }
            }
        }


        return (int)(result % (Math.pow(10, 9)+7));
    }

    public static boolean isPrime(long n) {
        if(n < 2){
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            //System.out.println(i);
            if (n % i == 0) {
                return false;
            } else {
                continue;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        // Test code
        //System.out.println(solution(1));
        //System.out.println(solution(2));
        System.out.println(solution(3));
        //System.out.println(solution(4));
        //System.out.println(solution(50));

    }
}
