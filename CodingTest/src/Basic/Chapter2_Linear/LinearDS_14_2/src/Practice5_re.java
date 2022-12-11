package LinearDS_14_2.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Practice5_re {
    public static ArrayList<Integer> solution(String[] gems) { //!! 슬라이딩 윈도우에서, 추가한 인덱스, 뺴는 인덱스 구분 잘하기 !!!
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < gems.length; i++) {
            set.add(gems[i]);
        }
        int n = set.size();
        if(n == 1){
            return new ArrayList<>(Arrays.asList(1, 1));
        }

        HashMap<String, Integer> map = new HashMap<>();
        boolean isCandidate = false;
        int right = 0;
        int left = 0;
        map.put(gems[0], 1);

        while(true){
            if(isCandidate == false){

                right++;
                if(right > gems.length - 1){
                    break;
                }
                int cnt = map.getOrDefault(gems[right], 0);
                map.put(gems[right], cnt + 1);

            }else{
                left++; // left는 뺴는 값이기 때문에 left-1로 인덱스계산
                int cnt = map.get(gems[left - 1]);
                if(cnt == 1){
                    isCandidate = false;
                    map.remove(gems[left - 1]);
                }else{
                    map.put(gems[left - 1], cnt - 1);
                }
            }

            if(map.size() == n){
                isCandidate = true;
                result.add(new ArrayList<>(Arrays.asList(left + 1, right + 1)));
            }
        }

        int min = Integer.MAX_VALUE;
        int minIdx = 0;
        for (int i = 0; i < result.size(); i++) {
            if(min > result.get(i).get(1) - result.get(i).get(0)){
                min = result.get(i).get(1) - result.get(i).get(0);
                minIdx = i;
            }
        }

        return result.get(minIdx);
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
