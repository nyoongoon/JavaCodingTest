package String;

import java.util.Scanner;

public class Cipher_inf_12 {
	public static void main(String[] args) {
	
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		stdIn.nextLine();
		String strs = stdIn.nextLine();
		char[] chars = strs.toCharArray();
		//int[] cipher = new int[7];
		String cipher = "";
		char[] result = new char[chars.length/7];
		int idx = 0;
		int cidx = 0;
		//int binary = 0;
		int decimal = 0;
		for(char c : chars) {
			idx++;
			if(c == '#') {
				cipher += "1";
			}else {
				cipher += "0";
			}
			
			//cipher [idx++] = chars[idx]; 
			if(idx>6) {
				//int[] to int --> 이진수 -> 십진수 -> 아스키 char -->result배열에 저장
				//binary = Integer.parseInt(cipher);
				decimal = Integer.parseInt(cipher, 2);
				result[cidx++]= (char)(decimal+0);
				idx = 0;
				cipher = "";
			}
		}
		System.out.println(result);
  }
}
