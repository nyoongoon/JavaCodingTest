package Base_Algorithm.Chapter1_Math;

import java.util.HashSet;
import java.util.Set;

public class Math_TEST_01_02 {
    static int result;

    public static int solution(String[] names) {

        Set<String> set = new HashSet<>();
        for (String name : names) {
            set.add(name);
        }

        result = 0;
        System.out.println(set.size());
        boolean[] visited = new boolean[set.size()];
        combi(set.size(), 4, 0, visited);

        return result;
    }

    public static void combi(int n, int r, int depth, boolean[] visited) {
        if(r == 0){
            result ++;
            return;
        }
        if(depth == visited.length){
            return;
        }

        visited[depth] = true;
        combi(n, r-1, depth + 1, visited);
        visited[depth] = false;
        combi(n, r, depth + 1, visited);

    }



    public static void main(String[] args) {
        String[] names = {"제로", "베이스", "자바", "스쿨", "자바", "베이스",
                "베이스", "백엔드", "화이팅",};
        System.out.println(solution(names));
//        System.out.println(solution1(names));
    }
}
