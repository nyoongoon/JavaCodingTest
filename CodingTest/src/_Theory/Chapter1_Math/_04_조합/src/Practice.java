package _Theory.Chapter1_Math._04_조합.src;// Practice
// 1, 2, 3, 4 를 이용하여 세자리 자연수를 만드는 방법 (순서 X, 중복 x)의 각 결과를 출력하시오

public class Practice { //visited 배열이 true인 것들만 출력하는 개념
    public static void main(String[] args) {
//      Test code
        int[] arr = {1, 2, 3, 4};
        boolean[] visited = {false, false, false, false};

        Practice p = new Practice();
        p.combination(arr, visited, 0, 3);
    }

    public static void combination(int[] arr, boolean[] visited, int depth, int r) {
        if (r == 0) {
            //출력
            for (int i = 0; i < arr.length; i++) {
                if(visited[i]){
                    System.out.print(arr[i]);
                }
            }
            System.out.println();
            return;
        }
        if (depth == arr.length) {
            return; //배열 넘어가면 리턴
        }

        visited[depth] = true;
        combination(arr, visited, depth + 1, r - 1);
        visited[depth] = false;
        combination(arr, visited, depth + 1, r);
    }


}
