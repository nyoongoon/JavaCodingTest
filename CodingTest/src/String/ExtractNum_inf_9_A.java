package String;

import java.util.Scanner;

public class ExtractNum_inf_9_A {
	public static void main(String[] args) {
		// 0 -> 48 ~~ 9 -> 57
		//answer = answer * 10 + (x-48) // 한자리씩 올려주고 1의자리 계산하여 덧붙이는 개념
		Scanner stdIn = new Scanner(System.in);
		String str = stdIn.nextLine();
		int answer =0;
		char[] chars = str.toCharArray();
		for(char c : chars) {
			if(c >= 48 && c<=57) {
				answer = answer * 10 + c-48;
			}
		}
		System.out.println(answer);
	}
}
