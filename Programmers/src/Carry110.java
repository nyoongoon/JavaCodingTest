import java.util.ArrayList;
import java.util.List;

//틀린 이유 !!찾기 
public class Carry110 {


	public static String[] solution(String[] s) {
		String[] answer = new String[s.length];
		for (int k = 0; k < s.length; k++) {
			// 110의 갯수
			int num = 0;
			String str = s[k];
			List<Character> list = new ArrayList<Character>();
			for (int i = 0; i < str.length(); i++) {
				list.add(str.charAt(i));
			}
			int size = list.size();
			for (int j = list.size() - 3; j > 0; j--) {
				if (list.get(j) == '1' && list.get(j + 1) == '1' && list.get(j + 2) == '0') {
					list.remove(j + 2);
					list.remove(j + 1);
					list.remove(j);
					num++;
					size -= 3;
				}
			}

			/*
			 * while (size > 2 && list.get(size - 3) == '1' && list.get(size - 2) == '1' &&
			 * list.get(size - 1) == '0') { num++; list.remove(size - 1); list.remove(size -
			 * 2); list.remove(size - 3); size -= 3; }
			 */
			// 110 넣기

			int idx = 0;
			while (true) {
				if (idx >= size) {
					while (num > 0) {
						num--;
						list.add('0');
						list.add('1');
						list.add('1');
					}
					break;
				}
				if (size < 2) {
					if (list.get(idx) == 1) {
						// 앞에다 넣기
						list.add(idx, '0');
						list.add(idx, '1');
						list.add(idx, '1');
						num--;
						idx += 3;
					} else {
						// 뒤에다 넣기
						idx++;
						num--;
						list.add('0');
						list.add('1');
						list.add('1');
					}
				} else {
					// 0XX 일경우
					if (list.get(idx) == '0') {
						idx++;
					} else {
						// 10X일 경우
						// 111인 경
						if ((list.get(idx + 1) == '1') && (list.get(idx + 2) == '1')) {
							// 앞에다 넣기
							list.add(idx, '0');
							list.add(idx, '1');
							list.add(idx, '1');
							num--;
							idx += 3;
						} else {//111이 아닌 1XX인 경우
							// 뒤에다 넣기
							idx++;
							num--;
							list.add('0');
							list.add('1');
							list.add('1');
						}
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