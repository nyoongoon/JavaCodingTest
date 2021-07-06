package BinarySearch;
import java.util.Scanner;

//p.201
public class MakeDdoek {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		// 떡의 갯수
		int n = stdIn.nextInt();
		int m = stdIn.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = stdIn.nextInt();
		}

		int start = 0;
		int end = arr[n - 1];
		int result = 0;
		while (start <= end) {
			int total = 0;
			int mid = (start + end) / 2;
			for (int i = 0; i < n; i++) {
				if (arr[i] > mid) {
					total += arr[i] - mid;
				}
			}
			if(total < m) { //더한 값이 m보다 작을 때
				end = mid - 1;
			}else { //떡의 양이 충분한 경우
				result = mid; // 최대값 저장
				
			}
		}

	}
}
