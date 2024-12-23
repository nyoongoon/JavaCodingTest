package _2_Java_Algo_Interview._1_문자열;

import java.util.*;

public class _5_그룹_애너그램_책풀이 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();

        for (String str : strs) {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String key = String.valueOf(charArr);

            if (!result.containsKey(key)) {
                result.put(key, new ArrayList<>());
            }

            result.get(key).add(str);
        }

        return new ArrayList<>(result.values());
    }
}
