package _Theory.Chapter3_NonLinear._15_비선형자료구조_연습문제_1.src;

import java.util.*;

public class Practice4_ans {//TODO 여기서부터 문제풀이 보기..!

    public static int solution(String[] deadends, String target) {
        int cnt = 0;
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curNum = queue.poll();
//                System.out.println(curNum);
                if (!visited.add(curNum)) {
                    continue;
                }
                if (curNum.equals(target)) {
                    return cnt;
                }
                for (String nextNums : getNextNums(curNum.toCharArray())) {
                    if (!visited.contains(nextNums)) {
                        queue.add(nextNums);
                    }
                }
            }
            cnt++;
        }

        return -1;
    }

    private static List<String> getNextNums(char[] cArr) {
        List<String> nums = new ArrayList<>();
        for (int i = 0; i < cArr.length; i++) {
            char c = cArr[i];
            cArr[i] = c == '9' ? '0' : (char) (c + (char) 1);
            nums.add(String.valueOf(cArr));
            cArr[i] = c == '0' ? '9' : (char) (c - (char) 1);
            nums.add(String.valueOf(cArr));
            cArr[i] = c;
        }
        return nums;
    }


    public static void main(String[] args) {
        // Test code
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        System.out.println(solution(deadends, "0202"));

        deadends = new String[]{"8888"};
        System.out.println(solution(deadends, "0009"));

    }

}
