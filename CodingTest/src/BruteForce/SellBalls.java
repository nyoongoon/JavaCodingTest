package BruteForce;

import java.util.Arrays;

public class SellBalls { // can not solve .. !

	public static void main(String[] args) {
		int[] inventory = {1000000000};
		int orders= 20;
		int output = maxProfit(inventory, orders);
		System.out.println(output);
	}
	//1000000007
	//550169267
	//707568720
	
	public static int maxProfit(int[] inventory, int orders) {
		int result = 0;
		long answer = 0;
		Arrays.sort(inventory);
		while (inventory[0] != inventory[inventory.length - 1]) {
			for (int i = inventory.length - 1; i > 0; i--) {
				while (inventory[i - 1] < inventory[i]) { // 같으면 멈추기 && inventory[i] >= 0
					
					// System.out.println("up answer+=" + inventory[i]);
					for(int j = i; j<inventory.length; j++) {
						if (result == orders) {
							//return Math.toIntExact((answer % ((long) Math.pow(10, 9) + 7)));
							//return (int) (answer %= 1000000007);
						}
						
						answer+=inventory[j]%1000000007;
						inventory[j] -= 1; // 이전 인덱스보다 작을 떄까지 하나 씩 빼기.
						result++;

					}
					//answer += inventory[i];
					//inventory[i] -= 1; // 이전 인덱스보다 작을 떄까지 하나 씩 빼기.
					//result++;
				}
			}
		}
		// 첫 값과 끝 값이 같아졌다면 하나씩 빼면 됨
		while (true) {
			for (int i = 0; i < inventory.length; i++) {
				if (result == orders) {
					//return Math.toIntExact((answer % ((long) Math.pow(10, 9) + 7)));
					return (int) (answer %= 1000000007);
				}

				// System.out.println("down answer+=" + inventory[i]);
				answer += inventory[i]%1000000007;
				if (inventory[i] < 1) {
					//return Math.toIntExact((answer % ((long) Math.pow(10, 9) + 7)));
					return (int) (answer %= 1000000007);
				}
				inventory[i] -= 1; // 이전 인덱스보다 작을 떄까지 하나 씩 빼기.

				result++;
			}
		}
	}
}
