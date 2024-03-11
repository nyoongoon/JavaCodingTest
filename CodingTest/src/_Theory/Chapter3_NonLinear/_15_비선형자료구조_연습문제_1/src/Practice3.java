package _Theory.Chapter3_NonLinear._15_비선형자료구조_연습문제_1.src;

import java.util.*;

public class Practice3 {
    public static ArrayList<ArrayList<String>> solution(ArrayList<ArrayList<String>> accounts) {
        Map<String, List<Set<String>>> map = new HashMap<>();

        for (int i = 0; i < accounts.size(); i++) {

            ArrayList<String> strings = accounts.get(i);

            String name = strings.get(0);
            if (!map.containsKey(name)) {
                map.put(name, new ArrayList<>(new HashSet<>()));
            }

            List<Set<String>> setList = map.get(name); //TODO

            Set<String> tempSet = new HashSet<>();
            for (int j = 1; j < strings.size(); j++) {
//                tempSet = new HashSet<>();
                String email = strings.get(j);
                tempSet.add(email);
            }

            boolean isPlusSet = false;
            for (Set<String> set : setList) {
                for (String email : tempSet) {
                    if (set.contains(email)) {
                        set.addAll(tempSet);
                        isPlusSet = true;
                        break;
                    }
                }
            }
            if (!isPlusSet) {
                setList.add(tempSet);
            }

            map.put(name, setList);
        }
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<Set<String>>> entry : map.entrySet()) {

            for (Set<String> innerSet : entry.getValue()) {
                ArrayList<String> innerList = new ArrayList<>();
                innerList.add(entry.getKey());
                for(String str : innerSet){
                    innerList.add(str);
                }
                result.add(innerList);
            }

        }
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
