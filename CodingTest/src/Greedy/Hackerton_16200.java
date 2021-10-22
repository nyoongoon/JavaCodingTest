package Greedy;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Hackerton_16200 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 팀원의 수는 최대로, 팀의 수는 최소로. i번 학생은 팀원수가 x명 이하일 때만 참가.
		Scanner stdIn = new Scanner(System.in);

		int n = stdIn.nextInt();
		if (n != 1) {
			int[] arr = new int[n];
			int count = 0;

			for (int i = 0; i < n; i++) {
				arr[i] = stdIn.nextInt();
			}

			Arrays.sort(arr);

			for (int i = 0; i < n; ) {
				if (i + arr[i] >= arr.length - 1) {// 값 만큼 건너 뜀
					count++;
					break;
				} else {
					i += arr[i];
					count++;
				}
			}

			System.out.println(count);
		}else {
			System.out.println(1);
		}
	}
}
