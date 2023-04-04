import java.util.Arrays;

public class Test3 {


    public static void main(String[] args) {
        int[] a = {5, 1, 3, 7};
        int[] b = {2, 2, 6, 8};
        System.out.println(solution(a, b));

    }


    public static int solution(int[] a, int[] b) {
        int result = 0;
        Arrays.sort(a);
        Arrays.sort(b);
        for (int i = 0; i < a.length; i++) {
            if(a[i] < b[i]){
                result++;
            }
        }

        return result;
    }




}
