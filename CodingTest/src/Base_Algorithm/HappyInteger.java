package Base_Algorithm;

import java.util.HashSet;
import java.util.LinkedList;

public class HappyInteger {
    public static boolean solution(int n) {
        HashSet<Integer> set = new HashSet<>();

        int num = n;
        //boolean runFlag = true;
        while(true){
            //System.out.println("num == " + num);
            if(set.contains(num)){
                return false;
            }else{
                set.add(num);
            }

            LinkedList<Integer> ll = new LinkedList<>();
            while(num>0){
                ll.addFirst(num%10);
                num /= 10;
            }
            // ll 꺼내기
            int happy = 0;
            for (int i = 0; i < ll.size(); i++) {
                //System.out.println("ll.get == " + ll.get(i));
                happy += (int)Math.pow(ll.get(i), 2);
            }
            //System.out.println("happy == " + happy);
            num = happy;
            if(happy == 1){
                return true;
            }
        }
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution(19));
        System.out.println(solution(2));
        System.out.println(solution(61));
    }
}
