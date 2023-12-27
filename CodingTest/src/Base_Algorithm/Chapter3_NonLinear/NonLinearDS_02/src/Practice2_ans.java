package Base_Algorithm.Chapter3_NonLinear.NonLinearDS_02.src;// Practice2

// 각각의 에지에 가중치가 있는 포화 이진 트리가 있다.
// 루트에서 각 리프까지의 경로 길이를 모두 같게 설정하고,
// 이 때, 모든 가중치들의 총합이 최소가 되도록 하는 프로그램을 작성하세요.
public class Practice2_ans { // 후위 순회 --> 트리 문제 풀때 무슨 순회인지 먼저 파악하기 !


    public static void solution(int h, int[] w) { // 후위 순회..  // 엣지를 노드처럼 활용.
        // 정답 문제 풀이대로 풀어보고 -> 블로그에 비교하기
        BT bt = new BT(h, w);
        bt.postOrder(1, 0);
        System.out.println(bt.res);
    }

    //       1
    //   2+7  3+9  4  5
    //  77 99 12 34

    public static void main(String[] args) {
        // Test code
        int h = 2; //트리의 높이
        int[] w = {2, 2, 2, 1, 1, 3}; // 트리에서 각각 에지의 가중치
        solution(h, w);
        System.out.println();

        h = 3;
        w = new int[]{1, 2, 1, 3, 2, 4, 1, 1, 1, 1, 1, 1, 1, 1};
        solution(h, w);
    }

    static class BT {
        int h;
        int arr[];
        int res;

        BT(int h, int w[]) {
            this.h = h;
            this.arr = new int[(int) Math.pow(2, h + 1)];
            for (int i = 2; i < (int) Math.pow(2, h + 1); i++) {
                arr[i] = w[i - 2];
            }
        }

        public int postOrder(int idx, int h) {
            if (h == this.h) {
                res += arr[idx];
                return arr[idx];
            }

            // 0 1 2 3 4 5 6
            // x x a b c d e
            int left = postOrder(idx * 2, h + 1);
            int right = postOrder(idx * 2 + 1, h + 1);

            res += arr[idx] + Math.abs(left - right);
            return arr[idx] + Math.max(left, right);
        }
    }


}
