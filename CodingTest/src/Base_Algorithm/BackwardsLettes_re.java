package Base_Algorithm;

import java.io.IOException;

public class BackwardsLettes_re {
    public static void solution(int num) throws IOException {
        int result = 0;
        boolean isMinus = false;
        if(num < 0){
            isMinus = true;
            num*=-1;
        }
        while(num >= 1){
            result *= 10;
            result += num % 10;
            num = num / 10;
        }

        if(isMinus){
            System.out.println("-"+result);
        }else{
            System.out.println(result);
        }

    }

    public static void main(String[] args) throws IOException {
        // Test code
        solution(12345);
        solution(-12345);
        solution(100);
        solution(0);
    }
}
