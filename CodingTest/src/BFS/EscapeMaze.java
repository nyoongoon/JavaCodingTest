package BFS;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//p.152
//병렬적으로 최단거리 구하기 --> BFS! --> 큐 사용!
public class EscapeMaze {
	public static int n;
	public static int m;
	public static int[][] maze;
	public static Queue<int[]> queue = new LinkedList<>();
	

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		n = stdIn.nextInt();
		m = stdIn.nextInt();
		// 미로를 받을 배열 필요
		maze = new int[n][m];
		char[][] mazeChar = new char[n][m];
		stdIn.nextLine(); // 버퍼 비우기
		for (int i = 0; i < n; i++) {
			String mazeString = stdIn.nextLine();
			for (int j = 0; j < m; j++) {
				mazeChar[i][j] = mazeString.charAt(j);
			}
		}
		// 병렬적 진행 ->BFS -> 큐 필요
		// 시작값 큐에 넣기
		int[] start = { 0, 0 };
		queue.offer(start);
		boolean flag = false; // 스탑 플래그
		int count = 1; //시작 칸 세기
		while (true) {
			if (flag == true) {
				break;
			}
			count++;	// 큐 비울때마다 카운트 세기
			int size = queue.size();
			int[][] position = new int[size][2];
			// 큐에서 값 뺴기
			for (int i = 0; i < size; i++) {
				position[i] = queue.poll();
				//큐에서 뺸 값으로 탐색하기
				flag = escape(position[i][0], position[i][1], mazeChar);
				if (flag == true) {
					break;	//n-1, m-1을 찾았다면 종료
				}
			}
		}
	
		System.out.println(count);
	}

	public static boolean escape(int a, int b, char[][] mazeChar) {
		// 상하좌우 살피기
		// 상
		if (a - 1 >= 0 && mazeChar[a - 1][b] == '1') {
			// n-1, m-1인가요?
			if (a - 1 == n - 1 && b == m - 1) {
				return true;
			}
			// 갈 수 있다면 (1이라면) 큐에 넣기
			int[] temp = { a - 1, b };
			queue.offer(temp);

		}
		// 하
		if (a + 1 < n && mazeChar[a + 1][b] == '1') {
			// n-1, m-1인가요?
			if (a + 1 == n - 1 && b == m - 1) {
				return true;
			}
			// 갈 수 있다면 (1이라면) 큐에 넣기
			int[] temp = { a + 1, b };
			queue.offer(temp);
		}
		// 좌
		if (b - 1 >= 0 && mazeChar[a][b - 1] == '1') {
			// n-1, m-1인가요?
			if (a == n - 1 && b - 1 == m - 1) {
				return true;
			}
			// 갈 수 있다면 (1이라면) 큐에 넣기
			int[] temp = { a, b - 1 };
			queue.offer(temp);
		}
		// 우
		if (b + 1 < m && mazeChar[a][b + 1] == '1') {
			// n-1, m-1인가요?
			if (a == n - 1 && b + 1 == m - 1) {
				return true;
			}
			// 갈 수 있다면 (1이라면) 큐에 넣기
			int[] temp = { a, b + 1 };
			queue.offer(temp);
		}
		return false;
	}
}
