package Base_Algorithm;

import java.util.*;

public class AbsoluteDifference_ans_18_3_3 {

    public static void solution(int[] arr, int k, int x) {
        //절대값 차이 map
        // key:절대값차이, value : 해당값리스트
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int diff = Math.abs(x - arr[i]);
            ArrayList<Integer> cur = map.get(diff); // 절대값 차이 있는지 확인
            if(cur == null){ //없으면
                map.put(diff, new ArrayList<>(Arrays.asList(arr[i]))); // 컬렉션 스트림 생성 !!!
            }else{
                //작은 숫자를 앞으로
                int idx = cur.size(); // 큰값은 마지막에 들어가야 하므로 기본위치 마지막으로 설정
                for (int j = 0; j < cur.size(); j++) {
                    if(cur.get(j) > arr[i]){  //기존에 있는 값이 더 큰 경우
                        idx = j;
                        break;
                    }
                }
                cur.add(idx, arr[i]); // 앞에 추가됨 (기존 인덱스값 뒤로 밀려남)
            }
        }
        //출력용 ArrList
        ArrayList<Integer> result = new ArrayList<>();
        int cnt = 0;
        while(map.size() > 0 ){
            int minDiff = map.keySet().stream().min((a, b) -> a - b).get(); // 이 코드 무엇이지 ..?
            //minDiff는 map 값중 가장 최소 값 받음
            ArrayList<Integer> cur = map.get(minDiff); // Array의 값이 복수 개 있을 수도
            map.remove(minDiff); //꺼내왔으므로 삭제
            while(cur.size() > 0){
                result.add(cur.get(0)); // 작은 것부터
                cur.remove(0);
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
