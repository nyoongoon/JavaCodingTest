package _Theory.Chapter1_Math._04_조합.src;// Practice
// 1, 2, 3, 4 를 이용하여 세자리 자연수를 만드는 방법 (순서 X, 중복 x)의 각 결과를 출력하시오

/**
 * 조합 visited를 활용한 재귀로 풀기 -> 안넣고, 넣고.. 개념..
 */
public class Practice_re { //visited 배열이 true인 것들만 출력하는 개념
    static int result = 0;

    public static void main(String[] args) {
//      Test code
        int[] arr = new int[]{1, 2, 3, 4};
        boolean[] visited = new boolean[arr.length];

        combination(arr, visited, 0, 3);
    }

    private static void combination(int[] arr, boolean[] visited, int depth, int r) {
        if (r == 0) {
            for (int i = 0; i < arr.length; i++) {
                if (visited[i]) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
            return;
        }

        if (depth == arr.length) {
            return;
        }


        visited[depth] = true;
        combination(arr, visited, depth + 1, r - 1);
        visited[depth] = false;
        combination(arr, visited, depth + 1, r);

    }

}
