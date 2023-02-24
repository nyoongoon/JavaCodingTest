package Base_Algorithm.Chapter1_Math.Math_06.src;// Practice2
// 최대공약수를 재귀함수로 구현하시오.

public class Practice2_my {
    public static int gcd(int a, int b){
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        if(max % min == 0){
            return min;
        }

        for (int i = min - 1; i > 0; i--) {
            if(min % i == 0){
                min = i;
                break;
            }
        }

        return gcd(min, max);
    }

    public static void main(String[] args) {
//      Test code
        System.out.println(gcd(3, 5));
        System.out.println(gcd(2, 6));
        System.out.println(gcd(8, 12));
    }
}
