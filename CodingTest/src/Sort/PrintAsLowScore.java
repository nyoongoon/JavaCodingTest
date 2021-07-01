package Sort;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//p.180
//해쉬맵 정렬! map.keySet().toArray();로 Object배열 생성후 정렬.
public class PrintAsLowScore {
	public static void main(String[] args) {
		
		Map<Integer, String> map = new HashMap<>();
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		stdIn.nextLine();
		String str;
		for(int i = 0; i<n; i++) {
			str = stdIn.nextLine();
			String[] arr = str.split(" ");
			map.put(Integer.parseInt(arr[1]), arr[0]);
		}
		Object[] obj = map.keySet().toArray();
		Arrays.sort(obj);
		
		
		for(Object o : obj) {
			System.out.println(map.get(o));
		}
		
	}
}
