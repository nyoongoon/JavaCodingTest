package String;
import java.util.Scanner;

public class FindChar_inf_1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine().toLowerCase();
		char[] chars = str.toCharArray();
		char c  = in.next().toLowerCase().charAt(0);
		int count = 0;
		
		for(int i = 0; i<chars.length; i++) {
			if(chars[i]==c) {
				count++;
			}
		}
		
		
		System.out.println(count);
		
	}
}
