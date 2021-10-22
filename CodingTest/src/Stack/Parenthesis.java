package Stack;
import java.util.Scanner;
import java.util.Stack;

public class Parenthesis {
	public static void main(String[] args) {
		
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		stdIn.nextLine();
		
		String[] strs = new String[n];
		for (int i = 0; i < strs.length; i++) {
			strs[i] = stdIn.nextLine();
		}
		
		
		for (int j = 0; j < strs.length; j++) {
			Stack<Character> stk = new Stack<>();
			boolean flag = true; //Yes
			for (int i = 0; i < strs[j].length(); i++) {
				char target = strs[j].charAt(i);
				if (target == '(') {
					stk.add(target);
				} else {
					// target==')'
					if(stk.size() != 0) {
						stk.pop();
					}else {
						//size ==0 && target == ')'
						flag = false;
						break;
					}
				}
			}
			if (stk.size() == 0 && flag == false) {
				System.out.println("NO");
			} else if(stk.size() == 0 && flag == true){
				System.out.println("YES");
			}else { // size != 0
				System.out.println("NO");
			}
		}
	}
}
