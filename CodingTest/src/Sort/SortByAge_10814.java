package Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SortByAge_10814 {
	public static void main(String[] args) {
		List<String> strings = new ArrayList<>();
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		stdIn.nextLine();

		for (int i = 0; i < n; i++) {
			String temp = stdIn.nextLine();
			strings.add(temp);
		}
		Collections.sort(strings, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				int num1 = Integer.parseInt(s1.substring(0, 2));
				int num2 = Integer.parseInt(s2.substring(0, 2));
				return num1 - num2;
			}
		});

		for (int i = 0; i < strings.size(); i++) {
			System.out.println(strings.get(i));
		}
	}
}
