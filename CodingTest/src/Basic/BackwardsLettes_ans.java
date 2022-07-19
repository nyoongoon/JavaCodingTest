package Basic;

import java.io.IOException;

public class BackwardsLettes_ans {
    public static void solution(int num) throws IOException {
        int numResvere = 0;
        boolean isMinus = false;
        if(num < 0){
            isMinus = true;
            num *= -1;
        }

        while(num > 0){
            int r = num % 10;
            num /= 10;
            numResvere = numResvere * 10 + r;
        }
        System.out.println(isMinus ? numResvere * -1 : numResvere);
    }

    public static void main(String[] args) throws IOException {
        // Test code
        solution(12345);
        solution(-12345);
        solution(100);
        solution(0);
    }
}
