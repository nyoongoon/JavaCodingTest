package Sort;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//두개의 값을 갖고 있는 객체를 ArrayLis로 받은 후, Collections.sort() 이용하기! 
public class PrintAsLowScore2 {
	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<>();
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		stdIn.nextLine();
		String str;
		for (int i = 0; i < n; i++) {
			str = stdIn.nextLine();
			String[] arr = str.split(" ");
			int score = Integer.parseInt(arr[1]);
			String name = arr[0];
			list.add(new Student(score, name));
		}
		
		Collections.sort(list);
		
		for(Student st : list) {
			System.out.println(st.getName());
		}
	}
}

class Student implements Comparable<Student> {
	String name;
	int score;

	public Student(int score, String name) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return this.name;
	}

	public int getScore() {
		return this.score;
	}

	@Override
	public int compareTo(Student st) {
		if (this.score < st.score) {
			return -1;
		}
		return 1;
	}
}
