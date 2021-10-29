package String;


import java.util.HashSet;
import java.util.Scanner;

public class Duplicated_inf_6 {
	public static void main(String[]args) {
		HashSet<Character> set = new HashSet<>();
		Scanner stdIn = new Scanner(System.in);
		
		String str = stdIn.nextLine();
		char[] chars = str.toCharArray();
		for(int i = 0; i<chars.length; i++) {
			char c = chars[i];
			if(!set.add(c)) {
				chars[i] = ' ';
			}
		}
		
		for(int i = 0; i<chars.length;i++) {
			if(chars[i]== ' ') {
				continue;
			}
			System.out.print(chars[i]);
		}
	}
}