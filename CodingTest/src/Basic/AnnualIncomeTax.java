package Basic;

import java.util.Scanner;

public class AnnualIncomeTax {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("[과세금액 계산 프로그램]");
        System.out.print("연소득을 입력해주세요.:");
        int income = stdIn.nextInt();

        double[] texRate = {0.06, 0.15, 0.24, 0.35, 0.38, 0.40, 0.42, 0.45};
        int[] taxation = {12000000, 46000000, 88000000, 150000000, 300000000, 500000000, 1000000000};
        int[] deduction = {0, 1080000, 5220000, 14900000, 25400000, 35400000, 65400000};

        int step = 0;
        for (int i = 0; i < 7; i++) {
            if (taxation[i] > income) {
                step = i + 1;
                break;
            }
        }

        int calculated = income;
        int tex = 0;
        for (int i = 0; i < step; i++) {
            if (income > taxation[i]) {
                if (i == 0) {
                    calculated -= taxation[i];
                    tex += taxation[i] * texRate[i];
                    //System.out.println(taxation[i] + " * " + (int)(texRate[i]*100) + "% = " + (int)(taxation[i] * texRate[i]));
                    System.out.printf("%10d * %2d%% = %10d%n", taxation[i], (int) (texRate[i] * 100), (int) (taxation[i] * texRate[i]));
                } else {
                    calculated -= taxation[i] - taxation[i - 1];
                    tex += (taxation[i] - taxation[i - 1]) * texRate[i];
                    //System.out.println((taxation[i]-taxation[i-1]) + " * " + (int)(texRate[i]*100) +"% = " + (int)((taxation[i] - taxation[i-1]) * texRate[i]) );
                    System.out.printf("%10d * %2d%% = %10d%n", (taxation[i] - taxation[i - 1]), (int) (texRate[i] * 100), (int) ((taxation[i] - taxation[i - 1]) * texRate[i]));
                }

            } else {
                tex += calculated * texRate[i];
                //System.out.println(calculated + " * " + (int)(texRate[i]*100) + "% = " + (int)(calculated * texRate[i])) ;
                System.out.printf("%10d * %2d%% = %10d%n", calculated, (int) (texRate[i] * 100), (int) (calculated * texRate[i]));
            }
        }
        System.out.println();
        System.out.printf("%-15s %d%n", "[세율에 의한 세금]:", tex);
        System.out.printf("%-15s %d%n", "[누진공제 계산에 의한 세금]:", (int) (((income * (texRate[step - 1] * 100)) / 100 - deduction[step - 1])));
    }
}
