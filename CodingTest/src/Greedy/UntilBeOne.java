package Greedy;
import java.util.Scanner;
// 이코테 99p
public class UntilBeOne {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int k = stdIn.nextInt();
		int count = 0;
		while (n != 1) {
			if(n % k == 0) {
				n /= k;
				count++;
			}else {
				n -= 1;
				count++;
			}
		}
		System.out.println(count);
	}
}
