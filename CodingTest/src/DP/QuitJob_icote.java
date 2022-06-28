package DP;

import java.util.Scanner;

public class QuitJob_icote { // 못풀었음 !!!

    // 서로 영향을 받지 않아야하는 데이터들이 서로 영향을 받고 있음 ...!!!

    public static void main(String[] args) {

        Scanner stdIn = new Scanner(System.in);

        int n = stdIn.nextInt();
        int[] arrT = new int [n+1];
        int[] arrP = new int [n+1];
        int[] copyP = new int [n+1];

        for(int i = 1 ; i<n; i++){
            arrT[i] = stdIn.nextInt();
            //arrP[i] = stdIn.nextInt();
            copyP[i] = stdIn.nextInt();
        }

        //for(int i = 1; i < n; i++){
        for(int i = 1; i < n+1; i++){
            int day = i;
            int nowMoney = copyP[day];
            arrP[day] = Math.max(arrP[day], arrP[day] + nowMoney);
            day += arrT[day];
            while(day < n+1){ // <n+2 ..?
                // 못 가는 날 빼고 다 넣기(max)
                if(arrP[day] != 0){
                    arrP[day] = Math.max(arrP[day], arrP[day] + nowMoney);
                }else{
                    arrP[day] = copyP[day] + nowMoney;
                }

                day++;
            }
        }

        // 7 일이 t1 인 일은 할 수 있음.
        int max = Integer.MIN_VALUE;
        System.out.println();
        for(int i : arrP){
            System.out.print(i + " ");
            max = Math.max(max, i);
        }
        System.out.println();
        System.out.println(max);
    }
}
