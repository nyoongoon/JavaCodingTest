package String;

public class WordInPharase_inf_3_A {
	public String solution(String str) {
		String answer = "";
		int m = Integer.MIN_VALUE; // 최솟값!
//		String[] s = str.split(" "); // split() 사용!
//		for(String x : s) {
//			int len = x.length();
//			if(len > m ) {
//				m = len;
//				answer = x;
//			}
//		}
		int pos;
		
		while((pos = str.indexOf(' ')) != -1) { //' ' 발견못하면 -1리턴
			String tmp = str.substring(0, pos);
			int len = tmp.length();
			if(len > m) {
				m=len;
				answer=tmp;
			}
			str = str.substring(pos+1); // substring()인자가 하나면 끝까지
		}
		// 마지막단어는 반복문에서 적용 못함
		if(str.length() > m) {//마지막 단어 처리
			answer=str;
		}
		
		return answer;
	}
	
	public static void main(String[]args) {
		
	}
}
