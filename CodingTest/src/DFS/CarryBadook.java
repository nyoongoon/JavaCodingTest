package DFS;
import java.util.Scanner;
//inf 8-2
public class CarryBadook {
	public static int c;
	public static int n;
	public static int max = 0;

	public static void dfs(int level, int result, int[] weights) {
		// if (level == n) {
		if (result + weights[level] > c) { // 우선 판단!
			return;
		}
		// if (result + weights[level] > c) {
		if (level == n) {
			return;
		} else {
			dfs(level + 1, result, weights);
			result += weights[level];
			if (max < result)
				max = result;
			dfs(level + 1, result, weights);
		}

	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		c = stdIn.nextInt();
		n = stdIn.nextInt();
		int[] weights = new int[n];
		for (int i = 0; i < n; i++) {
			weights[i] = stdIn.nextInt();
		}
		int result = 0;
		dfs(0, result, weights);
		int answer = max;
		System.out.println(answer);
	}
}
