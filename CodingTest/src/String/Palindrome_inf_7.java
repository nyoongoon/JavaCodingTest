package String;

import java.util.Scanner;

public class Palindrome_inf_7 {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		String str = stdIn.nextLine();
		str = str.toLowerCase();
		String answer = "YES";
		char[] chars = str.toCharArray();

		int lt = 0;
		int rt = chars.length - 1;

		while (lt < rt) {
			if (chars[lt] == chars[rt]) {
				lt++;
				rt--;
			} else {
				answer = "NO";
				break;
			}
		}

		System.out.println(answer);
	}
}
