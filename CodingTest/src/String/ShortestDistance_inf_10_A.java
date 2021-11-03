package String;

import java.util.Scanner;

public class ShortestDistance_inf_10_A {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		String str = stdIn.next();
		char c = stdIn.next().charAt(0);
		int[] answer = new int[str.length()];
		int dis = 99;
//		for(int i = 0; i<answer.length; i++) {
//			answer[i] = Integer.MAX_VALUE;
//		}
		
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == c) {
				dis = 0;
				answer[i] = dis;
			}else {
				if(dis != 99) {
					dis++;
				}
				answer[i] = dis;
			}
		}
		for(int n : answer) {
			System.out.print(n + " ");
		}
		dis = 99;
		System.out.println();

		for (int i = str.length()-1; i >= 0; i--) {
			if(str.charAt(i) == c) {
				dis = 0;
				answer[i] = dis;
			}else {
				if(dis != 99) {
					dis++;
				}
				if(answer[i] > dis) {
					answer[i] = dis;
				}
			}
		}
		
		for(int n : answer) {
			System.out.print(n + " ");
		}
	}
}
