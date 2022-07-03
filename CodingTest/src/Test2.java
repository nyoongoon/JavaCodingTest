import java.util.ArrayList;
import java.util.Scanner;

public class Test2 {
    static int n;
    static int k;
    static int[] memo;
    static int[] damageMemo;

    static int[] arrA;
    static int[] arrP;


    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        n = stdIn.nextInt();
        k = stdIn.nextInt();
        memo = new int[n];
        arrA = new int[n];
        arrP = new int[n];
        damageMemo = new int[n];

        for(int i = 0; i<n; i++){
            arrA[i] = stdIn.nextInt();
        }

        for(int i = 0; i<n; i++){
            arrP[i] = stdIn.nextInt();
        }


        recursive(n-1);

//        for(int i = 0; i < memo.length; i++){
//            System.out.println(memo[i]);
//        }
//        System.out.println();
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            max = Math.max(max, memo[i]);
        }
        System.out.println(max);
    }

    public static void recursive(int target){

//        System.out.println("recursive(int target");
//        System.out.println("recursive("+target+")");
//        System.out.println();
        if(target<0 || arrA[target] > k ){
            return;
        }




//        if(arrA[target] <= k){
//            memo[target] = Math.max(memo[target], arrP[target]);
//            damageMemo[target] = arrA[target];
//        }


        memo[target] = Math.max(memo[target], arrP[target]);
//        System.out.println(" memo[target] = Math.max(memo[target], arrP[target]);");
//        System.out.println(" memo["+target+"] = Math.max("+memo[target]+", "+arrP[target]+")");
        damageMemo[target] = arrA[target];
        int nowDamage = damageMemo[target];
        for(int i = target+1; i<n; i++){
            // A확인 후 최댓값 저장
           if(nowDamage+ damageMemo[i] <= k ){
               //memo[target] = Math.max(memo[target], memo[i] + arrP[target]);
               if(memo[target] < memo[i] + arrP[target]){
                   memo[target] = memo[i] + arrP[target];
                   damageMemo[target] = damageMemo[target] + damageMemo[i];
//                   System.out.println("damageMemo[target] = damageMemo[target] + damageMemo[i]");
//                   System.out.println("damageMemo["+target+"] = damageMemo["+target+"] + "+damageMemo[i]+")");
               }


           }

        }



        recursive(target-1);
    }
}
