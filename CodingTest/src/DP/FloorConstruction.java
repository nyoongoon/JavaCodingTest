package DP;
import java.util.Scanner;
//p.223
public class FloorConstruction {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int[] dt = new int [n+1];
		dt[1] = 1;
		dt[2] = 3;
		
		
		for(int i = 3; i<n+1; i++) {
			dt[i] = dt[i-1]*dt[1] + dt[i-2] * dt[2] - 1;
		}
		
		System.out.println(dt[n]%796769);
	}
}
