package Base_Algorithm;

public class HanoiTower {
    static StringBuffer sb = new StringBuffer();

    public static void solution(int n) {
        // n은 블럭 갯수
        hanoi(n, 1, 2, 3);
        System.out.println(sb);
    }

    public static void hanoi(int n, int start, int mid, int to) {
        if(n == 1){
            sb.append(start + "->" +to+"\n");
            return;
        }

        hanoi(n-1, start, to, mid);
        sb.append(start + "->" + to+"\n");
        hanoi(n-1, mid, start, to);
    }

    public static void main(String[] args) {
        // Test code
        //solution(2);
        //System.out.println();

        solution(3);
        //System.out.println();

        //solution(4);
    }
}
