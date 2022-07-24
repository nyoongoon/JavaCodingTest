package Math;

import java.util.ArrayList;

public class GCDAndLCM_03 {
    public ArrayList getDivisor(int num) {
        ArrayList result = new ArrayList();
        int div = 1;
        while(div<=num){
            if(num / div == 0){
                result.add(num);
            }
            div++;
        }



        return result;
    }

    //  최대 공약수
//  GCD: the Greatest Common Denominator
    public int getGCD(int numA, int numB) {
        int gcd = -1;
        int x = 1;
        while(x<=numA && x <= numB){
            if(numA % x == 0 && numB % x == 0){
                gcd = Math.max(gcd, x);
            }
            x++;
        }



        return gcd;
    }

    //  최소 공배수
//  LCM: the Lowest Common Multiple
    public int getLCM(int numA, int numB) {
        int lcm = -1;
        int x = Math.max(numA, numB);
        while(lcm == -1){
            if(x % numA == 0 && x % numB == 0 ){
                lcm = x;
                break;
            }
            x++;
        }


        return lcm;
    }

    public static void main(String[] args) {

//      Test code
        int number1 = 10;
        int number2 = 6;

        GCDAndLCM_03 p = new GCDAndLCM_03();
        ArrayList l1 = p.getDivisor(number1);   // 10: 1, 2, 5, 10
        ArrayList l2 = p.getDivisor(number2);   // 6: 1, 2, 3, 6
        System.out.println("l1 = " + l1);
        System.out.println("l2 = " + l2);

        System.out.println("최대 공약수: " + p.getGCD(number1, number2));
        System.out.println("최대 공배수: " + p.getLCM(number1, number2));
    }
}
