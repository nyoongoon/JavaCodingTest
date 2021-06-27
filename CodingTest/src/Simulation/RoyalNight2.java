package Simulation;
import java.util.Scanner;
//상하좌우 경우의 수를 이중 배열로 나타내 활용해보기!
public class RoyalNight2 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		String position = stdIn.nextLine();
		char colChar = position.charAt(0);
		// 알파벳으로 받은 칼럼을 숫자로 변환.
		int col = (int) (colChar - 96); // x
		int row = position.charAt(1) - '0'; // y
		System.out.println(col + " " + row);
		int count = 0;// 경우의 수

		// 상하좌우 경우의 수를 이중 배열로 나타내 활용해보기!

		int[][] move = { { -1, -2 }, { +1, -2 }, { -1, +2 }, { +1, +2 }, { -2, +1 }, { -2, -1 }, { +2, +1 },
				{ +2, -1 } };
		for (int i = 0; i < move.length; i++) {
			if (col + move[i][0] >= 1 && col + move[i][0] <= 8 
					&& row + move[i][1] >= 1 && row + move[i][1] <= 8) {
				count++;
			}
		}
	
		System.out.println(count);
	}
}
