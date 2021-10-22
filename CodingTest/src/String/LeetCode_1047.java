package String;
import java.util.HashMap;

public class LeetCode_1047 {
	public static void main(String[] args) {
		LeetCode_1047 obj = new LeetCode_1047();
		String s = "azxxzy";
		System.out.println(obj.removeDuplicates(s));
	}

	public String removeDuplicates(String s) {
		String answer = "";
		for (int i = 0; i < s.length(); i++) {
			char cha = s.charAt(i);	
			// answer의 마지막 인덱스 요소 검사
			if (answer.length() == 0) { //answer가 비어있으면 무조건 넣기
				answer += cha;
			} else { //answer가 비어있지 않으면
				char check = answer.charAt(answer.length() - 1); //answer의 마지막 글자
				if (check == cha) { // answer의 마지막 글자와 판단하는 값이 같으면
					answer = answer.substring(0, answer.length() - 1); // answer의 마지막 요소 삭제
				} else { // 다르면 합치기
					answer += cha;
				}
			}
		}
		return answer;

	}
}
