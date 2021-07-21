package BFS;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//인프런 7-14 
//1.그래프 받기
//2. bfs -> 큐를 활용해서 count 세기
public class ShortestWayBFS2 {
	static int n;
	static int m;
	static int[][] graph;
	static int[] ch;
	static int[] result;
	static Queue<Integer> queue = new LinkedList<Integer>();

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		n = stdIn.nextInt();
		m = stdIn.nextInt();
		graph = new int[n + 1][n + 1];
		ch = new int[n + 1]; // 방문 체크
		result = new int[n + 1];
		int count = 1;
		for (int i = 0; i < m; i++) {
			int a = stdIn.nextInt();
			int b = stdIn.nextInt();
			graph[a][b] = 1;
		}
		queue.add(1);
		while (!queue.isEmpty()) {
			int len = queue.size();
			for (int i = 0; i < len; i++) {
				int cur = queue.poll();
				for (int j = 1; j < m + 1; j++) {
					if (graph[cur][j] == 1) {
						// 체크 배열 하나 더? -> count 저장용, 방문 체크 .
						if (ch[j] == 0) {
							queue.add(j);
							// 첫 방문일 경우
							ch[j] = 1;
							result[j] = count;
						}
					}
				}
			}
			count++;
		}
		for (int i = 2; i < m + 1; i++) {
			System.out.println(result[i]);
		}
	}
}
