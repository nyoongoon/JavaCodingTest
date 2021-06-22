package Greedy;
import java.util.Arrays;
import java.util.Scanner;

public class LowOfMaxValue {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int m = stdIn.nextInt(); // m번 더한다
		int k = stdIn.nextInt(); // k번 초과해서 반복 더할 수 없다.
		int count = 0;
		int sum = 0; //합계
		int[] array = new int [n];
		for(int i = 0; i<n; i++) {
			array[i] = stdIn.nextInt();
		}
		Arrays.sort(array);
		for(int i = 0; i<array.length; i++) {
			System.out.print(array[i]);	
		}
		
		for(int i = 0; i < m; i++) {
			if(count<k) {
				count++;
				sum += array[n-1];
			}else {
				count = 0;
				sum += array[n-2];
			}
		}
		System.out.println(sum);
	}
}
