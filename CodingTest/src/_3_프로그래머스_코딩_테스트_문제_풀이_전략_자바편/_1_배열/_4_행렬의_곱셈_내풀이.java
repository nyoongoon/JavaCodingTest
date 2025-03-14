package _3_프로그래머스_코딩_테스트_문제_풀이_전략_자바편._1_배열;

/**
 * 행렬의 곱셈으로 왼쪽 행렬의 행 개수와 오른쪽 행렬의 열 개수를 갖게 됨
 *
 * 책에서 정답 배열 크기를 arr[arr1.length][arr2[0].length]로 정함
 * arr1[0].length == arr2.length 행렬 곱셈 가능
 *
 */
public class _4_행렬의_곱셈_내풀이 {
    public static void main(String[] args) {

    }
    class Solution {
        public int[][] solution(int[][] arr1, int[][] arr2) {
            int[][] answer = new int[arr1.length][arr2[0].length];

            for(int k = 0; k<arr2[0].length; k++){
                for(int i = 0; i< arr1.length; i++){
                    for(int j = 0; j < arr1[0].length; j++){
                        answer[i][k] += arr1[i][j] * arr2[j][k];
                    }
                }
            }

            return answer;
        }
    }
}
