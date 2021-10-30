package String;

import java.util.Scanner;

public class CountOfMatchsInTournament_LeetCode_1688 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int count = 0; 
		while(n > 1) {
			int matches = n/2;
			if(n%2 ==0 ) { //짝수
				
				n = n / 2;
				
				count += matches;
			}else { // 홀수
				n = n / 2 + 1;
				
				count += matches;
			}
		}
		
		System.out.println(count);
		
	}
}
