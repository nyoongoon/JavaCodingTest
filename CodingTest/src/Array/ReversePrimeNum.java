package prac;

import java.util.Scanner;

public class ReversePrimeNum {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n  = stdIn.nextInt();
		stdIn.nextLine();
		String s = stdIn.nextLine();
		String[] sArr = s.split(" ");
	
		for(String primeNum : sArr) {
			StringBuffer sb = new StringBuffer(primeNum);
			int revNum = Integer.parseInt(sb.reverse().toString());
			if(isPrimeNum(revNum)){
				System.out.print(revNum + " ");
			}
		}
	}
		
	public static boolean isPrimeNum(int revNum) {
		if(revNum == 1) return false;
		for(int i = 2 ; i<=Math.sqrt(revNum); i++) {
			if(revNum % i==0) {
				//¼Ò¼ö°¡ ¾Æ´Ô
				return false;
			}
		}
		
		return true;
	}
}
