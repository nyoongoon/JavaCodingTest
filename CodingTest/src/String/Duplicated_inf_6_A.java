package String;

import java.util.Scanner;

public class Duplicated_inf_6_A {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		String str = stdIn.next();
		
		String answer = "";
		for(int i = 0; i<str.length(); i++) {
			//System.out.println(str.charAt(i) + " " +i+" "+str.indexOf(str.charAt(i))); // 중복되어있으면 두 값이 다름 !
			if(str.indexOf(str.charAt(i)) == i) {// indexOf는 가장 먼저 나온 문자의 인덱스를 리턴!
				answer += str.charAt(i);
			}
		}
		
	}
}
