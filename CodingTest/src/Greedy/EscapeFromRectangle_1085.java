package Greedy;
import java.util.Arrays;
import java.util.Scanner;

public class EscapeFromRectangle_1085 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int x = stdIn.nextInt();
		int y = stdIn.nextInt();
		int w = stdIn.nextInt();
		int h = stdIn.nextInt();
		
		int[] arr = {x, y, h-y, w-x};
		Arrays.sort(arr);
		
		System.out.println(arr[0]);
		
		
	}
}
