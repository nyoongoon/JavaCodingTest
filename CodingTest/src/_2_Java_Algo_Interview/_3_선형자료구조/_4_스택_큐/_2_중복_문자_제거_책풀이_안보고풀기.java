package _2_Java_Algo_Interview._3_선형자료구조._4_스택_큐;

import java.util.*;

/**
 * conter 다루는 시점, Set을 쓴것 이 조금 다름
 */
public class _2_중복_문자_제거_책풀이_안보고풀기 {
    public static void main(String[] args) {

    }

    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> counter = new HashMap<>();
        Set<Character> seen = new HashSet<>();
        Deque<Character> stack = new ArrayDeque<>();

        //개수 업데이트
        for (char c : s.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }

        for (char c : s.toCharArray()) {
            if (seen.contains(c)) {
                counter.put(c, counter.get(c) - 1);
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > c && counter.get(stack.peek()) > 0) {
                seen.remove(stack.peek());
                stack.pop();
            }
            stack.push(c);
            counter.put(c, counter.get(c) - 1);
            seen.add(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.removeLast());
        }

        return sb.toString();
    }
}
