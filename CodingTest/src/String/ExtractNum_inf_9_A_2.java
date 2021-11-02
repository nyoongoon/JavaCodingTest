package String;

import java.util.Scanner;

public class ExtractNum_inf_9_A_2 {
	public static void main(String[] args) {
		// 0 -> 48 ~~ 9 -> 57
		//answer = answer * 10 + (x-48) // 한자리씩 올려주고 1의자리 계산하여 덧붙이는 개념
		Scanner stdIn = new Scanner(System.in);
		String str = stdIn.nextLine();
		String answer = "";
		
		for(char c : str.toCharArray()) {
			if(Character.isDigit(c)) { //숫자인가?
				answer += c; // 0이 포함 !
			}
		}
		System.out.println(Integer.parseInt(answer)); // parseInt()하면 앞의 0이 사라진다 !
	}
}
