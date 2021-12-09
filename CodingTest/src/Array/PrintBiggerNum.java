package prac;

import java.util.Scanner;

public class PrintBiggerNum {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int[] nums = new int[n];
		for(int i = 0; i<n; i++) {
			nums[i] = stdIn.nextInt();
		}
		int[] answer = new int[n];
		answer[0] = nums[0];
		System.out.print(answer[0] + " ");
		int idx = 1;
		
		for(int i = 1; i<nums.length; i++) {
			if(nums[i-1] < nums[i]) {
				answer[idx] = nums[i];
				System.out.print(answer[idx] + " ");
				idx++;
			}
		}
		
		
		
	}
}
