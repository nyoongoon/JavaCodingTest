package Basic;

import java.util.Scanner;

public class RRN {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        boolean is21st = true;

        String result = "";
        System.out.println("출생년도를 입력해주세요.(yyyy):");
        String bYear = stdIn.nextLine();
        result += bYear.charAt(2);
        result += bYear.charAt(3);

//        System.out.println(bYear.charAt(2));
//        System.out.println(bYear.charAt(3));

        if (bYear.charAt(0) == '1') {
            is21st = false;
        }

        System.out.println("출생월을 입력해주세요.(mm):");
        String bMonth = stdIn.nextLine();
        result += bMonth;

        System.out.println("출생일을 입력해주세요.(dd):");
        String bDay = stdIn.nextLine();
        result += bDay;


        String sexNum = "-";
        System.out.println("성별을 입력해주세요.(m/f):");
        char sex = stdIn.nextLine().charAt(0);
        if (sex == 'm') {
            if (is21st) {
                sexNum += "3";
            } else {
                sexNum += "1";
            }

        } else if (sex == 'f') {
            if (is21st) {
                sexNum += "4";
            } else {
                sexNum += "2";
            }

        }

        result += sexNum;


        for (int i = 0; i < 6; i++) {
            result += (int) (Math.random() * 10);
        }

        System.out.println(result);
    }
}
