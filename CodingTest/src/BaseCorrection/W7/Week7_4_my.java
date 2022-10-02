package BaseCorrection.W7;

import java.util.ArrayList;

public class Week7_4_ans {
    public static void main(String[] args) {
        Week7_4_ans w = new Week7_4_ans();
        String nums = "14152944";
        w.solution(nums);
    }

    public int[] solution(String nums) {

        recur(nums, new ArrayList<>());
        return null;
    }

    public void recur(String nums, ArrayList<Integer> piboArr) { //각각 숫자의 마지막 자리 인덱스.
        if (piboArr.size() == 0) {
            for (int i = 0; i < nums.length(); i++) { //추후 절반으로 나눌 수 있겠음. !
                piboArr.add(i);
                recur(nums, piboArr);
                piboArr.remove(0);
            }
        }

        if (piboArr.size() == 1) {
            for (int i = piboArr.get(0) + 1; i < nums.length()-piboArr.get(0) + 1; i++) { //추후 절반으로 나눌 수 있겠음. !
                piboArr.add(i);
                recur(nums, piboArr);
                piboArr.remove(1);
            }
        }

        if (piboArr.size() >= 2) { //2인 경우가 아니라 2 이상을 봐야함
            // 리턴 조건...
            int n = piboArr.size();
            if(piboArr.get(n-2) >= piboArr.get(n-1)  || piboArr.get(n-1) + 1>= nums.length()){
                System.out.println("return");
                return;
            }else{
                System.out.println("here");
            }
            int first = Integer.parseInt(nums.substring(piboArr.get(0), piboArr.get(n-2) + 1));
            if(piboArr.size()>=3){
                first = Integer.parseInt(nums.substring(piboArr.get(n-3)+1, piboArr.get(n-2) + 1));
            }

            int second = Integer.parseInt(nums.substring(piboArr.get(n-2) + 1, piboArr.get(n-1) + 1));
            String sumStr = String.valueOf(first + second);
            System.out.println("first == " + first);
            System.out.println("second == " + second);
            System.out.println("sumStr == " + sumStr);



            System.out.println("nums.substring(piboArr.get(1)+1, sumStr.length()+1) == " + nums.substring(piboArr.get(n-1) + 1, piboArr.get((n-1)) + sumStr.length() + 1));
            if (sumStr.equals(nums.substring(piboArr.get(n-1) + 1, piboArr.get((n-1)) + sumStr.length() + 1))) {
                piboArr.add(piboArr.get((n-1)) + sumStr.length() + 1);
                recur(nums, piboArr);
            }else{
                return;
            }

        }

    }

    public boolean check(String nums, ArrayList<Integer> piboArr) {

        return true;
    }
}
