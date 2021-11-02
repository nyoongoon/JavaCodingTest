package String; 

import java.util.Scanner;

 

public class ExtractNum_inf_9 {

	public static void main(String[] args) {

		// 65 ~ 122

		Scanner stdIn = new Scanner(System.in);
		String str = stdIn.nextLine();
		char[] chars = str.toCharArray();
		char[] answer = new char[chars.length];
		int idx = 0;
		for(int i = 0; i<chars.length; i++) {
			char c = chars[i];
			if(c<65 || c>122) {
				answer[idx++] =c ;
			}
		}

		if(answer[0] == '0') {
			String result  = String.valueOf(answer);
			result = result.substring(1);
			System.out.println(result);
		}else {
			System.out.println(answer);
		}

	}

}