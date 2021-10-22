package String;
import java.util.Scanner;

public class ReverseString {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		stdIn.nextLine(); // 버퍼 비워주기
		String[] strs = new String[n];
		for (int i = 0; i < n; i++) {
			strs[i] = stdIn.nextLine();
		}

		for (int i = 0; i < n; i++) {
			int forward = 0;
			int backward = strs[i].length() - 1;
			char[] chars = strs[i].toCharArray();
			while (forward < backward) {
				char temp = chars[forward];
				chars[forward++] = chars[backward];
				chars[backward--] = temp;
			}
			strs[i] = chars.toString();
			
		}
		
		for(int i = 0; i<n; i++) {
			System.out.println(strs[i]);
		}
		
		
		
	}
}
