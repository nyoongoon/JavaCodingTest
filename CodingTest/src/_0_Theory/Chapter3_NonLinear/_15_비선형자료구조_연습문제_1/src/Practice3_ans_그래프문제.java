package _0_Theory.Chapter3_NonLinear._15_비선형자료구조_연습문제_1.src;

import java.util.*;

public class Practice3_ans_그래프문제 { // 그래프로 풀 수 있다. 이메일이 각 노드, 같은 인물이면 간선 연결.
    // 그래프 구현 && dfs로 그래프 출력 !!
    public static ArrayList<ArrayList<String>> solution(ArrayList<ArrayList<String>> accounts) {
        Map<String, Set<String>> graph = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();
        for (ArrayList<String> list : accounts) {
            String name = list.get(0);

            for (int i = 1; i < list.size(); i++) {
                String email = list.get(i);

                if (!graph.containsKey(email)) {
                    graph.put(email, new HashSet<>());
                }
                // 이메일-이름 맵추가
                emailToName.put(email, name);
                if (i == 1) {
                    continue;
                }
                // 양방향 간선 추가
                graph.get(email).add(list.get(i - 1));
                graph.get(list.get(i - 1)).add(email);
            }
        }

        // 그래프 dfs 순회
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        for (Map.Entry<String, String> entry : emailToName.entrySet()) {

            if (visited.add(entry.getKey())) {
                ArrayList<String> resultList = new ArrayList<>();
                dfs(graph, entry.getKey(), visited, resultList);

                resultList.add(0, entry.getValue());
                result.add(resultList);
            }

        }
        return result;
    }

    private static void dfs(Map<String, Set<String>> graph, String email, Set<String> visited, List<String> resultList) {
        resultList.add(email);

        for (String str : graph.get(email)) {
            if (visited.add(str)) {
                dfs(graph, str, visited, resultList);
            }
        }
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
