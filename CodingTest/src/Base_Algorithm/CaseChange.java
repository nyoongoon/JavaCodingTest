package Base_Algorithm;

import java.io.IOException;

public class CaseChange {
    public static void solution() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = System.in.read();
        if(input > 90){//low to upper
            System.out.println((char)(input - 32));
        }else{ //upper to low
            System.out.println((char)(input + 32));
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
