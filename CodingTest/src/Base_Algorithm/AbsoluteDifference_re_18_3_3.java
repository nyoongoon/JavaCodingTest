package Base_Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class AbsoluteDifference_re_18_3_3 {
    public static void solution(int[] arr, int k, int x) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int ele : arr){
            int abs = Math.abs(x - ele);
            ArrayList al = map.get(abs);
            if(al == null){
                map.put(abs, new ArrayList<>(Arrays.asList(ele)));
            }else{
                al.add(al.size(), ele);
            }
        }


        ArrayList<Integer> result = new ArrayList<>(); // 출력용
        int cnt = 0;
        // map의 키가 작은 것부터 ...
        while(map.size() > 0){
            int minDiff = map.keySet().stream().min((a, b)-> a-b).get();
            ArrayList<Integer> valList = map.get(minDiff);
            map.remove(minDiff);
            while(valList.size() > 0){
                result.add(valList.get(0));
                valList.remove(0);
                cnt++;
                if(cnt == k){
                    break;
                }
            }
            if(cnt == k){
                break;
            }
        }

        Collections.sort(result);
        System.out.println(result);

    }
    public static void main(String[] args) {
        // Test code
        int[] arr = {1, 2, 3, 4, 5};
        solution(arr, 4, 3);

        arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        solution(arr, 5, 5);

        arr = new int[]{2, 4};
        solution(arr, 1, 3);

        arr = new int[]{2, 4};
        solution(arr, 3, 3);
    }
}
