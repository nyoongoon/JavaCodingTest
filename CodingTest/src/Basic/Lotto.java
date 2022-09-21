package Basic;

import java.util.HashSet;
import java.util.Scanner;

public class Lotto {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.println("[로또 당첨 프로그램]");
        System.out.print("로또 개수를 입력해주세요. (숫자 1 ~ 10):");
        int cnt = stdIn.nextInt();


        for (int i = 0; i < cnt; i++) {
            System.out.print((char) (i + 65) + "   ");
            HashSet<Integer> myLotto = lottoNums();
            printLottoNums(myLotto);
        }
        System.out.println();

        HashSet<Integer> announcement = lottoNums();
        System.out.println("[로또 발표]");
        System.out.print("    ");
        printLottoNums(announcement);
        System.out.println();

        System.out.println("[내 로또 결과]");
        for (int i = 0; i < cnt; i++) {
            System.out.print((char) (i + 65) + "   ");
            HashSet<Integer> myLotto = lottoNums();
            printLottoNums(myLotto, announcement);
        }
    }

    public static HashSet<Integer> lottoNums() {
        HashSet<Integer> set = new HashSet<>();
        while (set.size() < 6) {
            set.add((int) (Math.random() * 45) + 1);
        }

        return set;
    }

    public static void printLottoNums(HashSet<Integer> lotto) {
        String result = "";
        for(int num : lotto){
            result += String.format("%02d", num) + ",";
        }
        System.out.println(result.substring(0, result.length()-1));
    }

    public static void printLottoNums(HashSet<Integer> mylotto, HashSet<Integer> announcement) {
        int common = 0;
        String result = "";
        for(int num : mylotto){
            result += String.format("%02d", num) + ",";
            if(announcement.contains(num)){
                common++;
            }
        }
        System.out.println(result.substring(0, result.length()-1) + " => " + common + "개 일치");
    }
}
