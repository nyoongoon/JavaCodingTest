package String;

import java.util.Scanner;

public class Plaindrome2_inf_8_A {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		String str = stdIn.nextLine();
		String answer = "NO";
									// 대문자 A~Z가 아니면 제거
		str = str.toUpperCase().replaceAll("[^A-Z]", "");
		String tmp = new StringBuilder(str).reverse().toString();
		if(str.equals(tmp)) {
			answer = "YES";
		}
		
		System.out.println(answer);
		
	}
}
