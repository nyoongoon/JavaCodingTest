package _Theory.Chapter3_NonLinear.NonLinearDS_02.src;// Practice2

// 각각의 에지에 가중치가 있는 포화 이진 트리가 있다.
// 루트에서 각 리프까지의 경로 길이를 모두 같게 설정하고,
// 이 때, 모든 가중치들의 총합이 최소가 되도록 하는 프로그램을 작성하세요.
public class Practice2 { // 후위 순회 --> 트리 문제 풀때 무슨 순회인지 먼저 파악하기 !


    public static void solution(int h, int[] w) { // 후위 순회..  // 엣지를 노드처럼 활용.
        // 정답 문제 풀이대로 풀어보고 -> 블로그에 비교하기
        BT bt = new BT(w);
        bt.postOrder(0);
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
        int res;
        int[] arr;

        BT(int[] w) {
            arr = new int[w.length + 1];
            for (int i = 1; i < arr.length; i++) {
                                   // 0  1  2   3  4  5  6
                arr[i] = w[i - 1]; // * {2, 2, 2, 1, 1, 3};
                res += arr[i];
            }
        }

        public void postOrder(int idx) {
            if (idx >= arr.length) {
                return;
            }

            int left = idx * 2 + 1;
            int right = idx * 2 + 2;

//            System.out.println(left);
            postOrder(left);

            postOrder(right);

            if(left < arr.length && right <arr.length){

                //후위 순회..
                // 레프트 라이트 차이 만큼 하나 더하기
                res += Math.abs(arr[left] - arr[right]);
                arr[idx] = arr[idx] + Math.max(arr[left], arr[right]);
            }

        }
    }


}
