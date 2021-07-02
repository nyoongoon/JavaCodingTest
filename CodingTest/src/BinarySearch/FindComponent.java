package BinarySearch;
import java.util.Scanner;
//p.197
public class FindComponent {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int[] comp = new int[n];
		for(int i = 0; i<n; i++) {
			comp[i] = stdIn.nextInt();
		}
		
		int m = stdIn.nextInt();
		int[] client = new int[m];
		for(int i = 0; i<m; i++) {
			client[i] = stdIn.nextInt();
		}
		int result;
		// 부품 찾기
		for(int i = 0; i<m; i++) {
			int target = client[i];
			// 이진탐색하기
			// 결과 출력하기
			result = biSearch(comp, target, 0, n-1);
			if(result != -1) {
				System.out.print("yes ");
			}else {
				System.out.print("no ");
			}
		}
	}
	
	public static int biSearch(int[]comp, int target, int start, int end) {
		if(start>end) {
			return -1;
		}
		int mid = (start + end) / 2;
		if(comp[mid] == target) {
			return mid;
		}else if(comp[mid] > target){
			return biSearch(comp, target, start, mid-1);
		}else { 	//comp[mid] < target
			return biSearch(comp, target, mid+1, end);
		}
	}
}
