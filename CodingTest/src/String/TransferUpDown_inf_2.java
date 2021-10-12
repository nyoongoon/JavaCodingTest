package String;

import java.util.Scanner;

public class TransferUpDown_inf_2 {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		//대문자의 아스키코드 정수값은 65~90
		char[] chars = stdIn.nextLine().toCharArray();
		for(int i = 0; i<chars.length; i++) {
			if(chars[i]>=65 && chars[i]<=90) {
				chars[i] = Character.toLowerCase(chars[i]);
			}else {
				chars[i] = Character.toUpperCase(chars[i]);
			}
		}

		for(char c : chars) {
			System.out.print(c);
		}
	}

}
