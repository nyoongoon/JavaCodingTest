package String;

import java.util.Scanner;

public class CompressString_int_11_A {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		String str = stdIn.nextLine() + " ";
		char[] chars = str.toCharArray();
		String answer = "";
		
		int cnt = 1;
		
		for(int i = 0; i<chars.length-1; i++) {
			
			if(chars[i] == chars[i+1]) {
				
				cnt+=1;
				
			}else {
				if(cnt == 1) {
					answer += chars[i];
				}else {
					answer+= chars[i];
					answer+= Integer.toString(cnt);
					cnt = 1;
				}
				
			}
		}
		
	
		System.out.println(answer);
	}
}
