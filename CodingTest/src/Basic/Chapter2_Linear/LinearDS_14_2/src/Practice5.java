package LinearDS_14_2.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Practice5 {
    public static ArrayList<Integer> solution(String[] gems) {
        // 한번 돌면서 String 배열 이름 중복 제거한 해시 테이블 생성
        // 두번째 돌면서 -> 슬라이딩 윈도우 + 해시테이블 => 해시테이블의 길이가 첫번째 길이와 같은지.
        // 두번째 거꾸로 돌기 -> 낮은 시작 인덱스가 필요.
        int[] result = new int[2];
        HashMap<String, Integer> allMap = new HashMap<>();
        for (int i = 0; i < gems.length; i++) {
            int cnt = allMap.getOrDefault(gems[i], 0);
            allMap.put(gems[i], cnt + 1);
        }
        // 좌 <<-- 우
        HashMap<String, Integer> windowMap = new HashMap<>();
        int left = gems.length - 1;
        int right = gems.length - 1;

        int minLen = Integer.MAX_VALUE;
        while (true) {

            //while(windowMap.size() != allMap.size() && left > 0){ //모든 값 저장될떄까지 left 이동
            while (windowMap.size() != allMap.size() && left >= 0) { //모든 값 저장될떄까지 left 이동
                //System.out.println("left == " + left);
                System.out.println("left--");
                int cnt = windowMap.getOrDefault(gems[left], 0);
                windowMap.put(gems[left], cnt + 1);
                //if (left >= 0) left--;
                left--;
            }

            while (windowMap.size() == allMap.size()&& right >= 0) { //사이즈가 같으면 오른쪽 하나씩 제거시도
                System.out.println("right--");
                //System.out.println("right == " + right);
                int cnt = windowMap.get(gems[right]);
                if (cnt == 1) {
                    windowMap.remove(gems[right]);
                } else {
                    windowMap.put(gems[right], cnt - 1);
                }
                if (right > 0) right--;
            }

            if (minLen > right - left) { // minLen => left에서 right까지 거리
                minLen = right - left;
                result[0] = left + 2;
                result[1] = right + 2;
                //   System.out.println("put => " +result[0] +", " + result[1] );
            }
            if (left == -1 && windowMap.size() != allMap.size()) {
                break;
            }
        }

        return (ArrayList) Arrays.stream(result).boxed().collect(Collectors.toList());
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
