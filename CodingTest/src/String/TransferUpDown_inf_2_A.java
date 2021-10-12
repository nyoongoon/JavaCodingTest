package String;

import java.util.Scanner;

public class TransferUpDown_inf_2_A {
	public String solution(String str) {
		String answer = "";
		for(char x : str.toCharArray()) {
//			if(Character.isLowerCase(x)) {
//				answer+=Character.toUpperCase(x);
//			}else {
//				answer+=Character.toLowerCase(x);
//			}
			if(x>=97 && x<= 122) {
				answer += (char)(x-32); // <-- 대문자와 소문자의 차이값은 32!!! // += 자동 형변환 안됌! 
			}else{
				answer += (char)(x+32);
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		TransferUpDown_inf_2_A T = new TransferUpDown_inf_2_A();
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		System.out.print(T.solution(str));
	}
}
