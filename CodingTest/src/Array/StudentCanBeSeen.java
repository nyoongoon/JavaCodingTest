package prac;

import java.util.Scanner;

public class StudentCanBeSeen {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int[] nums =  new int[n];
		for(int i = 0; i<n; i++) {
			nums[i] = stdIn.nextInt();
		}
		
		int max = 0;
		int result = 0;
		for(int i = 0; i<n; i++) {
			if(nums[i]>max) {
				max = nums[i];
				result++;
			}
		}
		
		System.out.println(result);
	}
}
