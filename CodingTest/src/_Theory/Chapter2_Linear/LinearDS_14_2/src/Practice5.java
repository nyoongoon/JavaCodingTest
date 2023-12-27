package _Theory.Chapter2_Linear.LinearDS_14_2.src;

import java.util.*;

public class Practice5 {

    // 에외케이스 더 있나 파악 필요.. 더 짧은데 뒤에 있는 경우가 가능한기? -> 더 있는듯!

    public static ArrayList<Integer> solution(String[] gems) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        Set<String> set = new HashSet<>();
        for (String str : gems) {
            set.add(str);
        }
        int limit = set.size();
        boolean isFull = false;
        int rt = 0;
        int lt = 0;

        Map<String, Integer> map = new HashMap<>();
//        map.put(gems[rt++], 1);

        while (rt < gems.length && lt <= rt && lt < gems.length) {
//            System.out.println("lt == " + lt + ", rt == " + rt);

            if (!isFull) { //rt 증가
//                System.out.println("rt == " + rt);
                int cnt = map.getOrDefault(gems[rt], 0);
                map.put(gems[rt], cnt + 1);
                if (map.size() == limit) {
                    isFull = true;
                    list.add(new ArrayList<>(List.of(lt + 1, rt + 1)));
                } else {
                    rt++;
                }
            } else { // lt 증가
//                System.out.println("lt == " + lt);
                int cnt = map.get(gems[lt]);
                if (cnt - 1 == 0) {
                    map.remove(gems[lt]);
                } else {
                    map.put(gems[lt], cnt - 1);
                }
                if (map.size() < limit) {
                    isFull = false;
                    list.add(new ArrayList<>(List.of(lt + 1, rt + 1)));
                }
                lt++;

            }
        }

        list.sort((x, y) -> (x.get(1) - x.get(0) - (y.get(1) - y.get(0))));


//        for (List<Integer> ll : list){
//            System.out.println(ll.get(0) + ", "  + ll.get(1));
//        }


        return list.get(0);
    }

    public static void main(String[] args) {
        // Test code
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        System.out.println(solution(gems));

        gems = new String[]{"AA", "AB", "AC", "AA", "AC"};
        System.out.println(solution(gems));

        gems = new String[]{"XYZ", "XYZ", "XYZ"};
        System.out.println(solution(gems));

        gems = new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
        System.out.println(solution(gems));
    }
}
