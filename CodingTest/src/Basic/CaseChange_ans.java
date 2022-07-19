package Basic;

import java.io.IOException;
import java.util.Scanner;

public class CaseChange_ans {

    public static void solution(){
        Scanner sc = new Scanner(System.in);
        char input = sc.nextLine().charAt(0);
        int output = 0;

        int step = (int)'a' - (int)'A';

        if(input >= 'a' && input <= 'z'){
            output = (int)input - step;
            System.out.println((char)output);
        }else if(input >= 'A' && input<='Z'){
            output = (int)input + step;
            System.out.println((char)output);
        }else{
            System.out.println("error");
        }
    }
    public static void reference() {
        int a = (int)'a';
        System.out.println("a = " + a);
        int z = (int)'z';
        System.out.println("z = " + z);
        int A = (int)'A';
        System.out.println("A = " + A);
        int Z = (int)'Z';
        System.out.println("Z = " + Z);
        int etc = (int)'%';
        System.out.println("etc = " + etc);
    }

    public static void main(String[] args) throws IOException {
        reference();    // 아스키 코드 참고
        solution();
    }
}
