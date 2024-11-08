package _1_Two_Weeks_Algo;

import java.util.Scanner;

public class _3_연립방정식 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] strs = line.split(" ");

        int a = Integer.valueOf(strs[0]);
        int b = Integer.valueOf(strs[1]);
        int c = Integer.valueOf(strs[2]);
        int d = Integer.valueOf(strs[3]);
        int e = Integer.valueOf(strs[4]);
        int f = Integer.valueOf(strs[5]);


        for (int x = -999; x <= 999; x++) {
            for (int y = -999; y <= 999; y++) {
                if (a * x + b * y == c && d * x + e * y == f) {
                    System.out.print(x + " ");
                    System.out.print(y);
                }
            }
        }
    }
}
