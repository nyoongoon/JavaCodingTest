package String;

import java.util.Scanner;

public class ReverseString2_inf_5_A {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		String str = stdIn.nextLine();
		
		char[] chars = str.toCharArray();
		
		int lt = 0;
		int rt = chars.length-1;
		int count = 0;
		while(lt<rt) {
			count++;
//			if(chars[lt]+0 < 65 || chars[lt]+0 >122) {
//				lt++;
//			}
//			if(chars[rt]+0 < 65 || chars[rt]+0 >122) {
//				rt--;
//			}
//			if(chars[lt]+0 >= 65 && chars[lt]+0 <=122 && chars[rt]+0 >= 65 && chars[rt]+0 <=122) {
//				char temp = chars[lt];
//				chars[lt] = chars[rt];
//				chars[rt] = temp;
//				lt++;
//				rt--;
//			}
			
			if(!Character.isAlphabetic(chars[lt])){
				lt++;
			}else if(!Character.isAlphabetic(chars[rt])){
				rt--;
			}else{
				char tmp = chars[lt];
				chars[lt] = chars[rt];
				chars[rt] = tmp;
				lt++;
				rt--;
			}
		}
			
		System.out.println(chars);
		System.out.println("루프 횟수: " + count);
	}
}
