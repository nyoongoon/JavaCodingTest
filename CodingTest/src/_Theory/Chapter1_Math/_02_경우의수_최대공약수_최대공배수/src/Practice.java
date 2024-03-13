package _Theory.Chapter1_Math._02_경우의수_최대공약수_최대공배수.src;// Practice
// 약수 구하기, 두 수의 최대공약수와 최소공배수 구하기
// 활용) 1~10의 수 중 A의 약수 또는 B의 약수인 경우의 수
// 활용) 1~10의 수 중 A의 약수이면서 B의 약수인 경우의 수

import java.util.ArrayList;

//# 최대 공약수 & 최소 공배수
//## 약수
//- 해당 수를 나눠서 나머지가 0이 되는 수
//- **해당 수 /2 까지 나머지가 0인 수 + 해당 수 **
//## 최대 공약수
//- 두 수의 약수 중 공통적으로 나오는 약수이면서 가장 큰 수
//## 최소 공배수
//- 배수 중 공통적으로 배수면서 가장 작은 수
//- 최소 공배수 == (a * b) / GCD(a, b)   <- **두 원소 곱하고 최대 공약수로 나누기.**
public class Practice {

    public static void main(String[] args) {

//      Test code
        int number1 = 10;
        int number2 = 6;

        Practice p = new Practice();
        ArrayList l1 = p.getDivisor(number1);   // 10: 1, 2, 5, 10
        ArrayList l2 = p.getDivisor(number2);   // 6: 1, 2, 3, 6
        System.out.println("l1 = " + l1);
        System.out.println("l2 = " + l2);

        System.out.println("최대 공약수: " + p.getGCD(number1, number2));
        System.out.println("최대 공배수: " + p.getLCM(number1, number2));
    }

    //  약수
    public ArrayList getDivisor(int num) {
        ArrayList result = new ArrayList();
        for (int i = 1; i <= num / 2; i++) { // 절반까지 체크 //제곱근이 더 효율적임!!!
            if (num % i == 0) {
                result.add(num);
            }
        }
        result.add(num);

        return result;
    }

    //  최대 공약수
//  GCD: the Greatest Common Denominator
    public int getGCD(int numA, int numB) {
        int gcd = -1;
        ArrayList aDivisor = getDivisor(numA);
        ArrayList bDivisor = getDivisor(numB);

        for (int a : (ArrayList<Integer>) aDivisor) {
            for (int b : (ArrayList<Integer>) bDivisor) {
                if (a == b && gcd < a) { //? 부등호
                    gcd = a;
                }
            }
        }
        return gcd;
    }

    //  최소 공배수 == (a * b) / GCD(a, b)   <- 두 원소 곱하고 최대 공약수로 나누기.
//  LCM: the Lowest Common Multiple
    public int getLCM(int numA, int numB) {
        int lcm = -1;
        int gcd = getGCD(numA, numB);
        if(gcd != -1){
            lcm = numA * numB / gcd;
        }
        return lcm;
    }
}
