package String;

import java.util.Scanner;

public class ShortestDistance_inf_10 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		String str = stdIn.next();
		char[] chars = str.toCharArray();  
		char target = stdIn.next().charAt(0);
		
		char[] answer = new char[2*chars.length];
		
		for(int i = 0 ; i<chars.length; i++) {
			int left = 0;
			int right = 0;
			int leftMin = Integer.MAX_VALUE;
			int rightMin = Integer.MAX_VALUE;
			while(i-left >= 0) {
				// 그냥 빠져나가서 최소값으로 빠질때가 있음 ! 
				if(chars[i-left] == target) {
					leftMin = left;
					break; 
				}else {
					left++;
				}
			}
			while(i+right < chars.length) {
				if(chars[i+right] == target) {
					rightMin = right;
					break;
				}else {
					right++;
				}
			}
			
			answer[2*i] = Character.forDigit(Math.min(leftMin, rightMin), 10);
			answer[2*i+1] = ' ';
		}	
		for(int i = 0 ;i<answer.length-1; i++) {
			System.out.print(answer[i]);
		}
	}
}