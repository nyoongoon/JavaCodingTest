package String;

import java.util.Scanner;

public class WordInPharase_inf_3 {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		String input = stdIn.nextLine();
		String[] strs = input.split(" ");
		int max = 0;
		int maxIdx = 0;
		for(int i = 0 ; i<strs.length; i++) {
			int temp = strs[i].length();
			if(max<temp) {
				max = temp;
				maxIdx = i;
			}
		}

		System.out.println(strs[maxIdx]);
	}	

}
