package String;

import java.util.Scanner;

public class FindChar_inf_1_A {

	public int solution(String str, char t) {
		int answer = 0;
		// 대문자로 바꾸기
		str = str.toUpperCase();
		t = Character.toUpperCase(t);
		System.out.println(str);

//		for (int i = 0; i < str.length(); i++) {
//			if (str.charAt(i) == t) {
//				answer++;
//			}
//			return answer;
//		}
		
		for(char x : str.toCharArray()) { // <-- **배열 생성하고 바로 포문**
			if(x == t) {
				answer++;
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {
		FindChar_inf_1_A T = new FindChar_inf_1_A();
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		char c = kb.next().charAt(0); // 스트링을 인덱스로 받기

		System.out.print(T.solution(str, c));
	}
}
