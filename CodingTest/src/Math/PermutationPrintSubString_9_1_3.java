package Math;

import java.util.ArrayList;

public class PermutationPrintSubString_9_1_3 {
    // # 1 기본 permutation 방법
    public static boolean solution(String s1, String s2) {
        ArrayList<String> list = new ArrayList<>();
        boolean[] visited = new boolean[s1.length()];
        permutation(s1.toCharArray(), 0, s1.length(), s1.length(), visited, s1.toCharArray(), list);


        for (int j = 0; j < list.size(); j++) {
            System.out.println(list.get(j));
            if (s2.contains(list.get(j))) {
                return true;
            }
        }


        return false;
    }

    public static void permutation(char[] arr, int depth, int n, int r, boolean[] visited, char[] out, ArrayList<String> list) {
        if (depth == r) {
            list.add(new String(out));
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                out[depth] = arr[i];
                permutation(arr, depth + 1, n, r, visited, out, list);
                visited[i] = false;
            }
        }
    }


    // # 2 문제 규칙 찾아 해결
    public static boolean solution2(String s1, String s2) {

        return false;
    }

    public static void main(String[] args) {
        // Test code
        String s1 = "ab";
        String s2 = "adbak";
        System.out.println(solution(s1, s2));
        System.out.println(solution2(s1, s2));
        System.out.println();

        s1 = "ac";
        s2 = "car";
        System.out.println(solution(s1, s2));
        System.out.println(solution2(s1, s2));
        System.out.println();

        s1 = "ak";
        s2 = "aabbkk";
        System.out.println(solution(s1, s2));
        System.out.println(solution2(s1, s2));
    }
}
