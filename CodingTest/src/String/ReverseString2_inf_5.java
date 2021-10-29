package String;

import java.util.Scanner;
import java.util.Stack;

public class ReverseString2_inf_5 {
	public static void main(String[]args) {
		Scanner stdIn = new Scanner(System.in);
		String origin = stdIn.nextLine();
		char[] originTochars = origin.toCharArray();
		//아스키 65~122 영대소문자
		//ArrayList<Character> al = new ArrayList<>();
		Stack<Character> stk = new Stack<>();
		for(char c : originTochars) {
			if(c+0 >64 && c+0 < 123) {
				// 영대소문자
				c = (char)c;
				stk.add(c);
			}
		}
		
		for(int i = 0; i<originTochars.length; i++) {
			char c = originTochars[i];
			if(c+0 >64 && c+0 < 123) {
				// 영대소문자
				originTochars[i] = stk.pop();
			}
		}
		
		System.out.println(originTochars);
	}

}
