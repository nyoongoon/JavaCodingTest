package Basic;

import java.math.BigInteger;
import java.util.Scanner;

public class CashBack {
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        int cashback = 0;

        System.out.println("[캐시백 계산]");
        System.out.println("결제 금액을 입력해주세요. (금액):");
        int cost = stdIn.nextInt();

        if(cost >= 3000){
            cashback = 300;
        }else{
            cashback = cost / 1000 * 100;
        }

        System.out.println("결제 금액은 "+ cost+"원이고, 캐시백은 " + cashback+"원입니다.");

    }
}
