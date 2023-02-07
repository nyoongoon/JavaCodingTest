package Base_Algorithm;

import java.io.IOException;
import java.util.LinkedList;

public class BackwardsLetters {
    public static void main(String[] args) throws IOException {
        //입력된 정수 자료형의 숫자를 거꾸로 변환하는 프로그램을 작성하세요.
        LinkedList<Integer> ll = new LinkedList<>();
        boolean plus = true;
        while(true){
            int input = System.in.read();
            if(input == 10){
                break;
            }else if(input == 45){
                plus = false;
            }else{
                ll.addFirst(input-'0');
            }
        }
        if(plus == false){
            System.out.print("-");
        }

        for(Integer n : ll){
            System.out.print(n);
        }
    }
}
