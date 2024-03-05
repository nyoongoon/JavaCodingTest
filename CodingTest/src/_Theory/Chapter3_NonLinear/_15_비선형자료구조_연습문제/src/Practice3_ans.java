package _Theory.Chapter3_NonLinear._15_비선형자료구조_연습문제.src;

import java.util.*;

public class Practice3_ans {
    public static ArrayList<ArrayList<String>> solution(ArrayList<ArrayList<String>> accounts) {

        return result;
    }

    public static void main(String[] args) {
        // Test code
        ArrayList<ArrayList<String>> accounts = new ArrayList<>();
        accounts.add(new ArrayList<>(Arrays.asList("John", "john@mail.com", "john_lab@mail.com")));
        accounts.add(new ArrayList<>(Arrays.asList("John", "john@mail.com", "john02@mail.com")));
        accounts.add(new ArrayList<>(Arrays.asList("Mary", "mary@mail.com")));
        accounts.add(new ArrayList<>(Arrays.asList("John", "johnnybravo@mail.com")));
        accounts = solution(accounts);
        for (ArrayList<String> item : accounts) {
            System.out.println(item);
        }
    }
}
