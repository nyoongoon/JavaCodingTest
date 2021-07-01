package Sort;
import java.util.Arrays;
import java.util.Scanner;

//p.182
//!!! a배열의 값과 b 배열의 값 크기 비교를 해야함!!
public class ChangeElementsOfTwoArray {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		int n = stdIn.nextInt();
		int k = stdIn.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = stdIn.nextInt();
		}
		for (int i = 0; i < n; i++) {
			b[i] = stdIn.nextInt();
		}

		Arrays.sort(a);
		Arrays.sort(b);

		for (int i = 0; i < k; i++) {
			if (a[i] < b[n - i - 1]) {
				a[i] = b[n - i - 1];
			} else {
				break;
			}
		}

		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += a[i];
		}
		System.out.println(sum);
	}
}
