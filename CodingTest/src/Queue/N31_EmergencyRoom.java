package Queue;

import java.util.ArrayList;
import java.util.Scanner;

public class N31_EmergencyRoom {
    public static void main(String[] args){ //내 풀이 !! // 안정정렬 vs불안정정렬

        Scanner stdIn = new Scanner(System.in);
        ArrayList<int[]> al = new ArrayList<int[]>();   //ArrayList를 큐처럼 사용했음.  !!! 주의 => 큐는 LinkedList가 성능이 뛰어남 !!
        ArrayList<int[]> resultAl = new ArrayList<int[]>();
        int n = stdIn.nextInt();
        int m = stdIn.nextInt();
        //[] arr = int arr[n];

        for(int i = 0; i<n; i++){
            int arrVal = stdIn.nextInt();
            int[] arr = {i, arrVal};
            al.add(arr);
        }
        int len = al.size();
        int idx = 0;
        while(al.size() != 0){
            //System.out.println("test");
            int[] tmpArr = al.get(0);

            for(int i = 1; i<al.size(); i++){
                //System.out.println("al.size() == " + al.size());
                if(tmpArr[1] < al.get(i)[1]){

                    al.add(tmpArr);
                    break;
                }
                if(i == al.size()-1){
                    //System.out.println("if(i == al.size()-1)");
                    resultAl.add(tmpArr);
                }
            }
            al.remove(0);
        }


        for(int i = 0; i<resultAl.size(); i++){
            //System.out.println(resultAl.get(i)[0]);
            if(resultAl.get(i)[0] == m){
                System.out.println(i+1);
            }
        }



    }
}
