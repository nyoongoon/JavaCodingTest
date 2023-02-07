package Base_Algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class JewerlyShopping_ans_14_2_5 {
    public static ArrayList<Integer> solution(String[] gems) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < gems.length; i++) {
            set.add(gems[i]);
        }
        int n = set.size();

        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<int[]> al = new ArrayList<>();
        int left = 0;
        int right = 0;
        boolean canCheck = false;

        while (true) {
            if (map.size() != n) {
                if (left == gems.length - 1) {
                    break;
                }
                int cnt = map.getOrDefault(gems[left], 0);
                map.put(gems[left], cnt + 1);
                left++;
                if (map.size() == n) {
                    canCheck = true;
                }

            } else {
                int cnt = map.get(gems[right]);
                if (cnt == 1) {
                    map.remove(gems[right]);
                } else {
                    map.put(gems[right], cnt - 1);
                }
                right++;
                if (map.size() == n) {
                    canCheck = true;
                }
            }
            if (canCheck) {
                al.add(new int[]{left, right});
                canCheck = false;
            }
        }

        int min = Integer.MAX_VALUE;
        int minIdx = 0;
        for (int i = 0; i < al.size(); i++) {
            if(min > al.get(0)[0] - al.get(0)[1]){
                min = al.get(0)[0] - al.get(0)[1];
                minIdx = i;
            }
        }
        //return Arrays.stream(al.get(minIdx)).boxed().collect(Collectors.toList());
        return null;
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
