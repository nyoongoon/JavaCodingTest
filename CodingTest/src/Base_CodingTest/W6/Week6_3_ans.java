package Base_CodingTest.W6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Week6_3_re {
    public static void main(String[] args) {
        Week6_3_re w = new Week6_3_re();
        String[] ingredients = {"생닭", "인삼", "소주", "대추"};
        String[] items = {"물", "인삼", "커피", "생닭", "소주", "사탕", "생닭", "대추", "쌀"};
        System.out.println((w.solution(ingredients, items)));
    }

    public int solution(String[] ingredients, String[] items) {
        int answer = 0;
        int minLen = Integer.MAX_VALUE;

        Set<String> set = new HashSet<>();

        for(String s : ingredients){
            set.add(s);
        }

        Map<String, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        boolean isLeft = false;

        while(right<items.length){

            if(set.size() == map.size()){ // 사이즈가 같으면 left 올리기
                minLen = Math.min(minLen, right-left);
                if(!set.contains(items[left])){
                    left++;
                    continue;
                }

                int cnt = map.get(items[left]);
                if (cnt == 1){
                    map.remove(items[left]);
                }else{
                    map.put(items[left], cnt - 1);
                    left++;
                }

            }else{
                if(!set.contains(items[right])){
                    right++;
                    continue;
                }

                int cnt = map.getOrDefault(items[right], 0);
                map.put(items[right], cnt + 1);
                right++;

                if(set.size() == map.size()){
                    minLen = Math.min(minLen, right-left);
                }
            }
        }
        return minLen;
    }
}