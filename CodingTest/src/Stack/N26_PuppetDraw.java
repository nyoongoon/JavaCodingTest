package Stack;

import java.util.Scanner;
import java.util.Stack;

public class N26_PuppetDraw { // 내 풀이 !!!
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

        for(int i = 0; i<moves.length; i++){
            int col = moves[i];
            for(int j = 1; j<board.length; j++){
                // System.out.println("board[j][col] == ");
                //System.out.println("board["+j+"]["+col+"] == "+board[j][col]);
                if(board[j][col] != 0){
                    //System.out.println("if(board[j][col] != 0)");
                    //if(!stk.empty() && stk.pop() == board[j][col]){
                    if(!stk.empty()){
                        int tip = stk.pop();
                        if( tip == board[j][col]){
                            //System.out.println("answer+=1");
                            answer += 2;
                        }else{
                            stk.push(tip);
                            stk.push(board[j][col]);
                        }
                    }else{
                        stk.push(board[j][col]);
                    }

                    board[j][col] = 0;
                    break;
                }
            }
        }

        System.out.println(answer);

    }
}
