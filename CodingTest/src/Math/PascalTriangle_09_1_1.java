package Math;

import java.util.ArrayList;
import java.util.Arrays;

public class PascalTriangle_09_1_1 {
    public static ArrayList<ArrayList<Integer>> solution(int numRows) {
        ArrayList<ArrayList<Integer>> pascal = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {

            if(i == 1){
                ArrayList<Integer> al = new ArrayList<>(Arrays.asList(1));
                pascal.add(al);
            }else{
                ArrayList<Integer> prev =  pascal.get(pascal.size()-1);
                ArrayList<Integer> al = new ArrayList<>();

                for (int j = 1; j <= i; j++) {
                    if(j == 1 || j == i){
                        al.add(1);
                    }else{
                        al.add(prev.get(j-2) + prev.get(j-1));
                    }
                }
                pascal.add(al);
            }
        }
        return pascal;
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution(1));
        System.out.println(solution(2));
        System.out.println(solution(3));
        System.out.println(solution(4));
        System.out.println(solution(5));
    }
}
