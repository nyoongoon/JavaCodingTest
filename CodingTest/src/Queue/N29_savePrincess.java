package Queue;

import java.util.ArrayList;
import java.util.Scanner;

public class N29_savePrincess { // ㄴㅐ 풀이 !! => 연결 리스트 사용 => 해설은 큐 사용!!!
    public static void main(String[] args){
        //Stack<Character> stk = new Stack<>();
        Scanner stdIn = new Scanner(System.in);
        int n = stdIn.nextInt();

        int k = stdIn.nextInt();

        ArrayList<Integer> al = new ArrayList<Integer>();
        for(int i = 0; i<n; i++){
            al.add(i+1);
        }

        int removeIdx = k-1;
        while(al.size() != 1){

            //System.out.println("al.get("+removeIdx+") ==" + al.get(removeIdx));
            al.remove(removeIdx);
            if(removeIdx + (k-1) >= al.size()){
                removeIdx = removeIdx + (k-1) - al.size(); //
                while(removeIdx >= al.size()){
                    removeIdx -= al.size();
                }
            }else{
                removeIdx += k-1;
            }

        }

        System.out.println(al.get(0));
    }
}
