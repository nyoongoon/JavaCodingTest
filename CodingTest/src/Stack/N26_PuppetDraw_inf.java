package Stack;

import java.util.Scanner;
import java.util.Stack;

public class N26_PuppetDraw_inf { // 강의 풀이 !!!
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        int n = stdIn.nextInt();
        int[][] board = new int [n+1][n+1];

        for(int i = 1; i<board.length; i++){
            for(int j = 1; j<board[i].length; j++){
                board[i][j] = stdIn.nextInt();
            }
        }

        int m = stdIn.nextInt();
        int[] moves = new int[m];
        for(int i = 0; i<moves.length; i++){
            moves[i] = stdIn.nextInt();
        }

        Stack<Integer> stk = new Stack<Integer>();
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        for(int pos : moves){
            for(int i = 0; i<board.length; i++){
                if(board[i][pos-1] != 0){
                    int tmp=board[i][pos-1];
                    board[i][pos-1] = 0;
                    if(!stk.isEmpty() && tmp == stack.peek()){ // *** peek()를 사용하면 꺼내지 않고 값만 확인 가능 주의 !!! ***
                        answer += 2;
                        stack.pop();
                    }
                    else{
                        stk.push(tmp);
                        break;
                    }
                }
            }
        }

    }
}
