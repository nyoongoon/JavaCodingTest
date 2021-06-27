package Simulation;
import java.util.Scanner;

//p.115	
//시뮬레이션 유형 -> 문제에서 제시한 알고리즘을 한단계씩 차례대로 직접 수행
// !char를 int로 변환하는 방법!
// 상하좌우 문제에서 2중 배열 활용해보기!
public class RoyalNight {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		String position = stdIn.nextLine();
		char colChar = position.charAt(0);
		//알파벳으로 받은 칼럼을 숫자로 변환.
		int col = (int)(colChar - 96); //x
		int row = position.charAt(1) - '0'; //y
		System.out.println(col +" " + row );
		int count = 0 ;//경우의 수
		
		// 8가지 경우의 수를 세보기 
		if(col-1>=1 && col-1<=8 && row-2>=1 && row-2<=8) count++;
		if(col+1>=1 && col+1<=8 && row-2>=1 && row-2<=8) count++;
		if(col-1>=1 && col-1<=8 && row+2>=1 && row+2<=8) count++;
		if(col+1>=1 && col+1<=8 && row+2>=1 && row+2<=8) count++;
		if(col-2>=1 && col-2<=8 && row+1>=1 && row+1<=8) count++;
		if(col-2>=1 && col-2<=8 && row-1>=1 && row-1<=8) count++;
		if(col+2>=1 && col+2<=8 && row+1>=1 && row+1<=8) count++;
		if(col+2>=1 && col+2<=8 && row-1>=1 && row-1<=8) count++;
		
		System.out.println(count);
	}
}
