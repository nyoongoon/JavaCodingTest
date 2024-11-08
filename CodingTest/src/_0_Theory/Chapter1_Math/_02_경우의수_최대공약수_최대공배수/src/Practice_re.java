package _0_Theory.Chapter1_Math._02_경우의수_최대공약수_최대공배수.src;// Practice
// 약수 구하기, 두 수의 최대공약수와 최소공배수 구하기
// 활용) 1~10의 수 중 A의 약수 또는 B의 약수인 경우의 수
// 활용) 1~10의 수 중 A의 약수이면서 B의 약수인 경우의 수

import java.util.ArrayList;
import java.util.List;

public class Practice_re {
    //  약수 --> 나눠서 나머지가 발생하지 않는 수
    public List<Integer> getDivisor(int num) {
        List<Integer> result = new ArrayList();
        for (int i = 1; i <= num / 2; i++) { // 절반까지 체크 //제곱근이 더 효율적임!!!
            if (num % i == 0) {
                result.add(i);
            }
        }
        result.add(num); // 자기 자신도 약수..
        return result;
    }

    // 두 자연수의 곱 == 최대 공약수 * 최소 공배수
    //  최대 공약수
//  GCD: the Greatest Common Denominator
    public int getGCD(int numA, int numB) {
        int gcd = -1;
        List<Integer> aDvisors = getDivisor(numA);
        List<Integer> bDvisors = getDivisor(numB);

        for (int itemA : aDvisors) {
            for (int itemB : bDvisors) {
                if (itemA == itemB && gcd < itemA) {
                    gcd = itemA;
                }
            }
        }
        return gcd;
    }

    //  최소 공배수 == (a * b) / GCD(a, b)   <- 두 원소 곱하고 최대 공약수로 나누기.
//  LCM: the Lowest Common Multiple
    public int getLCM(int numA, int numB) {
        int lcm = -1;
        int gcd = this.getGCD(numA, numB);
        if (gcd == -1) {
            lcm = numA * numB / gcd;
        }
        return lcm;
    }
    public static void main(String[] args) {

//      Test code
        int number1 = 10;
        int number2 = 6;

        Practice_re p = new Practice_re();
        List<Integer> l1 = p.getDivisor(number1);   // 10: 1, 2, 5, 10
        List<Integer> l2 = p.getDivisor(number2);   // 6: 1, 2, 3, 6
        System.out.println("l1 = " + l1);
        System.out.println("l2 = " + l2);

        System.out.println("최대 공약수: " + p.getGCD(number1, number2));
        System.out.println("최대 공배수: " + p.getLCM(number1, number2));
    }
}
