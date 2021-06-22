package Greedy;
import java.util.Arrays;
import java.util.Scanner;

//반복되는 수열을 파악하고 더하기!!
public class LowOfMaxValue2 {
	public static void main(String[] args) {

		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int m = stdIn.nextInt(); // m번 더한다
		int k = stdIn.nextInt(); // k번 초과해서 반복 더할 수 없다.

		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = stdIn.nextInt();
		}
		Arrays.sort(array);

		int times = (m / (k + 1));// 반복되는 수열을 더하는 횟수 구하기
		int last = m % (k + 1);
		// 합계
		int sum = (array[n-1] * k + array[n - 2]) * times + (array[n-1] * last);
		System.out.println(sum);
	}
}