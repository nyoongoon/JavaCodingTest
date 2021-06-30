package Sort;
import java.util.Scanner;

//p.178
public class UpToDown {
	public static int n; // 수열의 갯수

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		// 내림차순 --> 퀵정렬을 내림차순으로 정렬해보기
		n = stdIn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = stdIn.nextInt();
		}

		quick(0, arr.length - 1, arr);

		for (int i = 0; i < n; i++) {
			System.out.print(arr[i]);
		}
	}

	public static void swap(int a, int b, int[] arr) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;

	}

	// 내림차순 주의
	public static void quick(int start, int end, int[] arr) {
		if (start >= end) {
			//원소가 1개인 경우 종료
		} else {
			int pivot = start;
			int left = start+1;
			int right = end;
			// 작은 수 찾기
			while (arr[left] > arr[pivot] && left < end) {
				left++;
			}
			//큰 수 찾기
			while (arr[right] < arr[pivot] && right>start+1) {
				right--;
			}
			if (left <= right) {
				swap(left, right, arr);
			} else {
				swap(right, pivot, arr);
				quick(start, right-1, arr);
				quick(right+1, end, arr);
			}
		}
	}

}
