package Basic;

import java.util.LinkedList;

public class PoppingBalloon_14_1_3 {
    public static void solution(int[] data) {
        LinkedList<Integer> result = new LinkedList<>();
        LinkedList<int[]> ll = new LinkedList<>();
        for (int i = 0; i < data.length; i++) {
            ll.add(new int[]{i, data[i]});
        }

        int idx = 0;
        while(!ll.isEmpty()){ //remove했을 때, 양수와 음수의 움직임이 다르다. // 링크드리스트 remove경우 idx 하나씩 땡겨짐
            int[] val = ll.remove(idx);
            result.add(val[0] + 1);
            int size = ll.size();
            if (size == 0) break;
            if(val[1] >= 0){
                idx = (idx + val[1] - 1) % size;
            }else{
                idx = (idx + val[1] + size) % size;
            }
        }

        System.out.println(result);
    }

    public static void main(String[] args) {
        int[] balloon = {3, 2, 1, -3, -1};
        solution(balloon);

        System.out.println();
        balloon = new int[]{3, 2, -1, -2};
        solution(balloon);
    }
}
