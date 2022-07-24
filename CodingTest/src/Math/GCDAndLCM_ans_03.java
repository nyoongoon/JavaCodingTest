package Math;

import java.util.ArrayList;

public class GCDAndLCM_ans_03 {
    public ArrayList getDivisor(int num) {
        ArrayList result = new ArrayList();

        for(int i = 1; i<= (int)num/2; i++){ // num의 절반까지만 보면 됨 !!!
            if(num % i == 0){
                result.add(i);
            }
        }
        result.add(num);



        return result;
    }

    //  최대 공약수
//  GCD: the Greatest Common Denominator
    public int getGCD(int numA, int numB) {
        int gcd = -1;
        ArrayList divisorA = this.getDivisor(numA);
        ArrayList divisorB = this.getDivisor(numB);

        for(int itemA : (ArrayList<Integer>)divisorA){
            for(int itemB : (ArrayList<Integer>)divisorB){
                if(itemA == itemB){
                    if(itemA > gcd){
                        gcd = itemA;
                    }
                }
            }
        }
        return gcd;
    }

    //  최소 공배수   <<== 최소 공배수 구하기 공식 활용 -> lcm = numA * numB /gcd;
//  LCM: the Lowest Common Multiple
    public int getLCM(int numA, int numB) {
        int lcm = -1;

        int gcd = this.getGCD(numA, numB);

        if(gcd != -1){
            lcm = numA * numB /gcd;
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
        System.out.println("최소 공배수: "+ p.getLCM(number1, number2));
    }
}
