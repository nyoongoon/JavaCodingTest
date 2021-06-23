package Greedy;
import java.util.Scanner;
// 같은 동작을 반복할 때, 한 번에 수행할 수 있는 방법이 있는지 고민해본다!!

public class UntilBeOne2 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int k = stdIn.nextInt();
		int count = 0;
		while(true) {
			
			int target = (n / k) * k;	//n보다 작으거나 같으면서 k로 나누어 떨어지는 수 중 가장 큰 수
			count = n - target;	//한꺼번에 연산
			n = target;
			if(n<k) {
				break;
			}
			n /= k;
			count++;
		}
		
		count += n-1;
		System.out.println(count);
	}
}
