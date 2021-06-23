package Greedy;
import java.util.Arrays;
import java.util.Scanner;
//이코테 96p
public class CardGame {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();//행의 개수
		int m = stdIn.nextInt();//열의 개수
		int[] array;
		int max = 0;
		for(int i = 0; i<n; i++) {
			array = new int [m];
			for(int j = 0; j<m; j++) {
				array[j] = stdIn.nextInt();
			}
			Arrays.sort(array);
			int min = array[0];
			if(max < min) {
				max = min;
			}
		}
		
		System.out.println(max);
	}
}
