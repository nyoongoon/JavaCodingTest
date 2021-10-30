package String;

import java.util.Scanner;

public class removeDuplicates_LeetCode_1047 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		String str = stdIn.nextLine();
		String answer = removeDuplicates(str);
		System.out.println(answer);
	}
	public static String removeDuplicates(String s) {
		String answer = "";
		for (int i = 0; i < s.length(); i++) {
			char cha = s.charAt(i);
			// answer의 마지막 인덱스 요소 검사
			if (answer.length() == 0) { //처음 요소 그냥 추가
				answer += cha;
			} else {
				char check = answer.charAt(answer.length() - 1);
				if (check == cha) { // 같으면
					answer = answer.substring(0, answer.length() - 1); // 더하지 않고 있던 마지막 요소 자르기
				} else { // 다르면 추가
					answer += cha;
				}
			}
		}
		return answer;

	}
}
