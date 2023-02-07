package Base_Algorithm;

public class CatalanNumber {

    public static int solution(int n) {
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return 1;
        }
        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;


        //for (int i = 2; i <= n; i++) {
        for (int i = 2; i <= n; i++) {
            int tmp = 0;
            for (int j = 0; j < i; j++) {
                tmp += arr[j] * arr[i - 1 - j];
            }


            arr[i] = tmp;
        }


//        for(int x : arr){
//            System.out.print(x + " ");
//        }

        return arr[n];
    }


    public static void main(String[] args) {
        // Test code
        System.out.println(solution(0));
        System.out.println(solution(2));
        System.out.println(solution(5));
        System.out.println(solution(7));
    }
}
