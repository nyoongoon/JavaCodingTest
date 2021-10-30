package ShotestPath;

import java.util.Scanner;

public class Tex_13907 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt(); // 도시의 수
		int m = stdIn.nextInt(); // 도로의 수
		int k = stdIn.nextInt(); // 세금 인상 횟수
		int s = stdIn.nextInt(); // 출발도시
		int d = stdIn.nextInt(); // 도착도시
		int[][] wage = new int[n][n];
		int[] times = new int[k]; //인상되는 세금
		
		for(int i = 0; i<m; i++) {
			int a = stdIn.nextInt(); //도시a
			int b = stdIn.nextInt(); //도시b
			int w = stdIn.nextInt(); //통행료
			wage [a][b] = w;
			wage [b][a] = w;
		}
		
		for(int i = 0; i<k; i++) {
			times[i] = stdIn.nextInt(); //인상되는 세금
		}
	}
}
