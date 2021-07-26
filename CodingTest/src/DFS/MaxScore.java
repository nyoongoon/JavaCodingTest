package DFS;
import java.util.Scanner;

// 다시 풀어보기
public class MaxScore {
	public static int m;
	public static int max = 0;

	public void dfs(int level, int score, int time, int[][] scoreAndTime) {
		if (time > m) {
			return;
		}

		if (level == scoreAndTime.length) {
			return;
		} else {
			if (max < score) {
				max = score;
			}

			dfs(level + 1, score + scoreAndTime[level][0], time + scoreAndTime[level][1], scoreAndTime); // 점수와 시간 더함
			dfs(level + 1, score, time, scoreAndTime); // 점수와 시간 안더함
		}
	}

	public static void main(String[] args) {
		MaxScore ms = new MaxScore();
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt(); // 문제의 갯수
		m = stdIn.nextInt(); // 시간 제한
		int[][] scoreAndTime = new int[n][2];
		for (int i = 0; i < n; i++) {
			scoreAndTime[i][0] = stdIn.nextInt(); // 점수
			scoreAndTime[i][1] = stdIn.nextInt(); // 시간
		}

		ms.dfs(0, scoreAndTime[0][0], scoreAndTime[0][1], scoreAndTime);
		int answer = max;
		System.out.println(answer);
	}
}
