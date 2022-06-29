package DP;

public class SoldierArrangement_ans {
    public static void main(String [] args){
        // 가장 긴 증가하는 부분수열 아이디어.
        //D[i] == array[i]를 마지막 원소로 가지는 부분 수열의 최대 길이.
        // 모든 0<= j < i 에 대하여, D[i] = max(D[i], D[j] + 1) if array [j] < array[i]
    }
}
