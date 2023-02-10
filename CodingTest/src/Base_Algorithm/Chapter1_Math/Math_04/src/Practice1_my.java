package Base_Algorithm.Chapter1_Math.Math_04.src;// Practice1
// 1, 2, 3, 4 를 이용하여 세자리 자연수를 만드는 방법 (순서 O, 중복 x)의 각 결과를 출력하시오
// 방법 1

public class Practice1_my {
    static int result = 0;
    public static void main(String[] args) {
//      Test code
        int[] arr = {1, 2, 3, 4};

        Practice1 p = new Practice1();
        p.permutation(arr, 0, 4, 3);
        System.out.println(result);
    }

    void permutation(int[] arr, int depth, int n, int r) {
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            visited[i] = true;
            recur(arr, 1, n, r, visited);
            visited[i] = false;
        }
    }

    public void recur(int[] arr, int depth, int n, int r, boolean[] visited) {
        if (depth == r) {
            result++;
            return;
        }

//        int nowInt = arr[i];
        for (int i = 0; i < n; i++){
            if(visited[i] == false){
                visited[i] = true;
                recur(arr, depth + 1, n, r, visited);
                visited[i] = false;
            }
        }


    }
}
