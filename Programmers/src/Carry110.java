import java.util.ArrayList;
import java.util.List;

//틀린 이유 !!찾기 
public class Carry110 {

	public static void main(String[] args) {
		String[] s = { "1110", "100111100", "0111111010" };
		solution(s);
		for (String str : s) {
			System.out.println(s);
		}
	}

	public static String[] solution(String[] s) {
		String[] answer = new String[s.length];
		for (int k = 0; k < s.length; k++) {
			// 110의 갯수
			String str = s[k];
			int num = 0;
			List<Character> list = new ArrayList<Character>();
			for (int i = 0; i < str.length(); i++) {
				list.add(str.charAt(i));
				int size = list.size();
				while (size > 2 && list.get(size - 3) == '1' && list.get(size - 2) == '1'
						&& list.get(size - 1) == '0') {
					num++;
					list.remove(size - 1);
					list.remove(size - 2);
					list.remove(size - 3);
					size -= 3;
				}
			}

			// num 만큼 111앞에 110넣기

			while (num > 0) {
				for (int i = 1; i < str.length() - 3; i++) {
					if (list.get(i) == '1' && list.get(i + 1) == '1' && list.get(i + 2) == '1') {
						list.add(i, '0');
						list.add(i, '1');
						list.add(i, '1');
						i += 3;
						num--;
					}
				}
			}

			String result = "";
			for (int i = 0; i < str.length(); i++) {
				result += list.get(i).toString();
			}

			answer[k] = result;

		}

		return answer;

	}
}
