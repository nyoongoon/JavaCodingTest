import java.util.ArrayList;
import java.util.Scanner;

public class Test {

    static int[] valueMemo;
    //static int[] kMemo;
    static int[] arrA;
    static int[] arrP;
    static int n;
    static int k;
    public static void main(String[] args){
        // 0, 1, ...n개의 마을
        // 0, 1, ... n개의 도로
        Scanner stdIn = new Scanner(System.in);
        n = stdIn.nextInt();
        k = stdIn.nextInt();
        arrA = new int[n];
        arrP = new int[n];
        valueMemo = new int[n];
        ArrayList<Integer> al = new ArrayList<>();


        for(int i = 0; i<arrA.length; i++){
            arrA[i] = stdIn.nextInt();
        }

        for(int i = 0; i<arrA.length; i++){
            arrP[i] = stdIn.nextInt();
        }

        recursive(0, 0, al);

       /* for(int i = 0; i<valueMemo.length; i++){
            System.out.println(valueMemo[i]);
        }*/

        int max = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            max = Math.max(max, valueMemo[i]);
        }
        System.out.println(max);
    }

    public static void recursive(int target, int point, ArrayList<Integer> al){
        /*System.out.println("recursive(int target, al)");
        System.out.println("recursive(" + target +", al)");*/
        int nowPoint = 0;
        for(int p : al){
            nowPoint += p;
        }

        if(nowPoint > k || target > n){
            return;
        }



        valueMemo[target] = Math.max(valueMemo[target], point+arrP[target]);
        //System.out.println("valueMemo[target] == " + valueMemo[target]);


        for(int i = target+1; i<n; i++){
            al.add(arrA[target]);
            recursive(i, valueMemo[target], al);
            al.remove(al.size()-1);
        }

        //System.out.println();
    }
}
