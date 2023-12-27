package _Theory.Chapter1_Math.Math_09_1.src;

public class Practice3_my {
    // # 1 기본 permutation 방법
    static boolean answer = false;

    public static boolean solution(String s1, String s2) {
        char[] chars = s1.toCharArray();
        answer = false;
        permutation(chars, 0, s2);


        boolean[] visited = new boolean[chars.length];
        char[] out = new char[chars.length];
        permutation2(chars, 0, s2, visited, out);

        return answer;
    }

    // # 2 문제 규칙 찾아 해결 //슬라이딩 윈도우 + 순열의 개념 !!!
    public static boolean solution2(String s1, String s2){
        final int ALPHABET = 26;
        int[] cnt = new int[ALPHABET];
        for (int i = 0; i < s1.length(); i++) {
            cnt[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            boolean result = true;
            if(i >= s1.length()){
                cnt[s2.charAt(i - s1.length()) - 'a']++;
            }

            cnt[s2.charAt(i) - 'a']--;

            for (int j = 0; j < cnt.length; j++) {
                if(cnt[j] != 0){
                    result = false;
                    break;
                }
            }
            if(result){
                return true;
            }
        }
        return false;
    }


    public static void permutation(char[] chars, int depth, String s2) {
        if (depth == chars.length) {
            // 판단 로직
            String result = String.valueOf(chars);

            if (s2.contains(result)) {
                System.out.println(result);
                answer = true;
            }
        }

        for (int i = depth; i < chars.length; i++) {
            swap(chars, i, depth);
            permutation(chars, depth + 1, s2);
            swap(chars, i, depth);
        }

    }

    public static void permutation2(char[] chars, int depth, String s2, boolean[] visited, char[] out) {
        if (depth == chars.length) {
            // 판단 로직
            String result = String.valueOf(chars);

            if (s2.contains(result)) {
                System.out.println(result);
                answer = true;
            }
        }

        for (int i = 0; i < chars.length; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                out[depth] = chars[i];
                permutation2(chars, depth + 1, s2, visited, out);
                visited[i] = false;
            }
        }


    }

    public static void swap(char[] chars, int a, int b) {
        char tmp = chars[a];
        chars[a] = chars[b];
        chars[b] = tmp;
    }


    // # 2 문제 규칙 찾아 해결


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
