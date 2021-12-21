package prac;

import java.util.Scanner;

public class Rank_inf_A {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int[] student = new int[n];
		int[] result = new int [n];
		for(int i = 0; i<n; i++) {
			student[i] = stdIn.nextInt();
		}
		
		for(int i = 0 ;i<n;i++) {
			int rank = 1;
			for(int j = 0; j<n; j++) {
				if(student[i] < student[j]) {
					rank++;
				}
			}
			result[i] = rank;
		}
		
		for(int i = 0 ; i<n; i++) {
			System.out.print(result[i] + " ");
		}
	}
}
