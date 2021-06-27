package Simulation;

import java.util.Scanner;
//p.112
public class UpDownLeftRight {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		// !!! next() vs nextLine() !!!
		// !!! 2번 넣는 이유!!
		stdIn.nextLine();
		String plan = stdIn.nextLine();
		System.out.println(plan);
		plan = plan.replaceAll(" ", "");
		char[] arr = plan.toCharArray();
		for(int i = 0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		int times = arr.length;
		int x = 1; int y = 1;//시작지점
		int idx = 0;
		for(int i = 0; i< arr.length; i++) {
			
			char move = arr[idx++];
			switch (move) {
			case 'L' : 
				x--; if(x<1) x++;
				break;
			case 'R' :
				x++; if(x>n) x--;
				break;
			case 'U' :
				y--; if(y<1) y++;
				break;
			case 'D' :
				y++; if(y>n) y--;
				break;
			}
		}
		System.out.println(y +" " + x);		
	}
}
