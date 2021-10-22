package Greedy;
import java.util.Arrays;
import java.util.Scanner;

public class Divisor_1037 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = stdIn.nextInt();
		}
		Arrays.sort(arr);

		if (arr.length % 2 == 0) {// 짝수개
			System.out.println(arr[0] * arr[arr.length - 1]);

		} else {// 홀수개
			System.out.println(arr[(arr.length) / 2] * arr[(arr.length) / 2]);

		}
	}
}
