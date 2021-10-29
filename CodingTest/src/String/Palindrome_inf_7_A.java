package String;

import java.util.Scanner;

public class Palindrome_inf_7_A {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		String str = stdIn.next();
		str.toUpperCase();
		String answer = "YES";
//		int len = str.length();
//		for(int i = 0; i< len/2; i++) { //절반 비교
//			if(str.charAt(i) != len-1-i) {
//				answer = "NO";
//				break;
//			}
//		}
		String tmp = new StringBuilder(str).reverse().toString(); // 스트링 빌더로 뒤집고 비교
		if(!str.equals(tmp)) { //eqaulsIgnoreCase(tmp) 대소문자 무시
			System.out.println("NO");
		}else {
			System.out.println("YES");
		}
		
		//System.out.println(answer);
	}
}
