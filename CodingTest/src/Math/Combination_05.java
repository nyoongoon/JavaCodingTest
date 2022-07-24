package Math;

public class Combination_05 {
    void combination(int[] arr, boolean[] visited, int depth, int n, int r) {
        if(depth == r){
            for (int i = 0; i < n; i++) {
                if(visited[i]){
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
            return;
        }

        for (int i = depth; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, depth+1, n, r);
            visited[i] = false;
        }


    }

    public static void main(String[] args) {
//      Test code
        int[] arr = {1, 2, 3, 4};
        boolean[] visited = {false, false, false, false};

        Combination_05 p = new Combination_05();
        p.combination(arr, visited, 0, 4, 3);
    }
}
