package DFS;
import java.util.Scanner;

public class CreateGame {
	int n;
	int m;

	public static void main(String[] args) {
		CreateGame cg = new CreateGame();
		// 상하좌우 위치문제 = 배열로 표현하자
		Scanner stdIn = new Scanner(System.in);
		cg.n = stdIn.nextInt();
		cg.m = stdIn.nextInt();
		int a = stdIn.nextInt();
		int b = stdIn.nextInt();
		int d = stdIn.nextInt(); // direction
		int[][] map = new int[cg.n][cg.m];

		for (int i = 0; i < cg.n; i++) {
			for (int j = 0; j < cg.m; j++) {
				map[i][j] = stdIn.nextInt();
			}
		}
		
		for (int i = 0; i < cg.n; i++) {
			for (int j = 0; j < cg.m; j++) {
			System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
		int count = 0; // 네방향 실패 카운트
		while (true) {
			count++;
			System.out.print("카운트 횟수: " + count);
			System.out.println();
			System.out.print("현재 방향: "+d);
			System.out.println();
			//cg.turnLeft(a, b, d, map, count);
			//턴레프트
			if (d == 0) {// 북쪽일 때 서쪽으로 가기.
				d = 3;
				if (map[a][b - 1] == 0) {
					map[a][b] = 2; // 가본곳 == 2
					b -= 1;
					count = 0; // 움직였으면 count = 0;
				}
			} else if (d == 1) { // a - 1
				d = 0;
				if (map[a - 1][b] == 0) {
					map[a][b] = 2; // 가본곳 == 2
					a -= 1;
					count = 0; // 움직였으면 count = 0;
				}

			} else if (d == 2) { // b + 1
				d = 1;
				if (map[a][b + 1] == 0) {
					map[a][b] = 2; // 가본곳 == 2
					b += 1;
					count = 0; // 움직였으면 count = 0;
				}
			} else if (d == 3) {// a+1
				d = 2;
				if (map[a + 1][b] == 0) {
					map[a][b] = 2; // 가본곳 == 2
					a += 1;
					count = 0; // 움직였으면 count = 0;
				}
			}
			
			if (count == 4) { // 한바퀴 돌았다면
				System.out.println("카운트 4 이상");
				// 방향 유지 뒤로 한칸가기
				count = 0;
				if (d == 0) {
					a += 1;
					if (map[a][b] == 1) {
						break;
					}
				
				} else if (d == 1) {
					b -= 1;
					if (map[a][b] == 1) {
						break;
					}
					
				} else if (d == 2) {
					a -= 1;
					if (map[a][b] == 1) {
						break;
					}
				
				} else {// d == 3)
					b += 1;
					if (map[a][b] == 1) {
						break;
					}
					
				}

			}
		}
		
		System.out.println("반복문 탈출");
		for (int i = 0; i < cg.n; i++) {
			for (int j = 0; j < cg.m; j++) {
			System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
		int result = 0;
		for (int i = 0; i < cg.n; i++) {
			for (int j = 0; j < cg.m; j++) {
				if(map[i][j] == 2 ) {
					result++;
				}
			}
		}
		System.out.println(result);
	}

	public void turnLeft(int a, int b, int d, int[][] map, int count) {

		if (d == 0) {// 북쪽일 때 서쪽으로 가기.
			d = 3;
			if (b - 1 > 0 && b - 1 < this.m - 1 && b - 1 == 0) {
				map[a][b] = 2; // 가본곳 == 2
				b -= 1;
				count = 0; // 움직였으면 count = 0;
			}
		} else if (d == 1) { // a - 1
			d = 0;
			if (a - 1 > 0 && a - 1 < this.n - 1 && a - 1 == 0) {
				map[a][b] = 2; // 가본곳 == 2
				a -= 1;
				count = 0; // 움직였으면 count = 0;
			}

		} else if (d == 2) { // b + 1
			d = 1;
			if (b + 1 > 0 && b + 1 < this.m - 1 && b + 1 == 0) {
				map[a][b] = 2; // 가본곳 == 2
				b += 1;
				count = 0; // 움직였으면 count = 0;
			}
		} else if (d == 3) {// a+1
			d = 2;
			if (a + 1 > 0 && a + 1 < this.n - 1 && a + 1 == 0) {
				map[a][b] = 2; // 가본곳 == 2
				a += 1;
				count = 0; // 움직였으면 count = 0;
			}
		}
	}
}
