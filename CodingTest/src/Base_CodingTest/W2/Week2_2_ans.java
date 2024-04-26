package Base_CodingTest.W2;


import java.util.Stack;

public class Week2_2_ans {

    public static void main(String[] args) {
        int[] a = {8, 2, 6, 3, 4, 1, 5, 7, 2, 8};
        int[] b = {2, 0, 0, 6, 3, 4, 5, 3, 6, 7}; //[1, 0, 2, 6, 9, 7, 6, 1, 0, 9, 5]
        int[] result = solution(a, b);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static int[] solution(int[] a, int[] b) {
        Stack<Integer> stk = new Stack<>();
        int maxLen = Math.max(a.length, b.length);
        int offsetA = maxLen - a.length;
        int offsetB = maxLen - b.length;
        int overflow = 0;


        for (int i = maxLen - 1; i >= 0; i--) {
            int valA = (i - offsetA < 0) ? 0 : a[i - offsetA];
            int valB = (i - offsetB < 0) ? 0 : b[i - offsetB];
            int cur = valA + valB + overflow;
            if(cur >= 10){
                overflow = 1;
                cur -= 10;
            }else{
                overflow = 0;
            }
            stk.push(cur);
        }
        int resultLen = maxLen;
        if(overflow == 1){
            resultLen++;
            stk.push(1);
        }

        int[] resultArr = new int[resultLen];
        for (int i = 0; i < resultArr.length; i++) {
            resultArr[i] = stk.pop();
        }




        return resultArr;
    }
}
