package _2_Java_Algo_Interview._1_문자열;

import java.util.*;

public class _5_그룹_애너그램_내풀이 {
    public static void main(String[] args) {
        //["eat","tea","tan","ate","nat","bat"]
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> lists = groupAnagrams(strs);
        System.out.println(lists);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> group = new HashMap<>();
        for(String str : strs){
            String key = getKey(str);
            if(group.containsKey(key)){
                ArrayList<String> list = group.get(key);
                list.add(str);
                group.put(key, list);
            }else{
                ArrayList list = new ArrayList<String>();
                list.add(str);
                group.put(key, list);
            }
        }

        List<List<String>> results = new ArrayList<>();
        for(Map.Entry entry : group.entrySet()){
            results.add((List)entry.getValue());
        }
        return results;
    }

    public static String getKey(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return Arrays.toString(chars);
    }
}
