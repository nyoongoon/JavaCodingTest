package String;

import java.util.Scanner;

public class Palindrome2_inf_8 {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		String str = stdIn.nextLine();
		str = str.toLowerCase();
		String answer = "YES";
		char[] chars = str.toCharArray();

		int lt = 0;
		int rt = chars.length - 1;

		while (lt < rt) {

			if (Character.isAlphabetic(chars[lt]) == true && Character.isAlphabetic(chars[rt]) == true) {
				if (chars[lt] == chars[rt]) {
					lt++;
					rt--;
				} else {
					answer = "NO";
					break;
				}
			} else {
				while (!Character.isAlphabetic(chars[lt]) && lt < rt) {
					lt++;
				}

				while (!Character.isAlphabetic(chars[rt]) && lt < rt) {
					rt--;
				}
			}
		}

		System.out.println(answer);
	}
}
