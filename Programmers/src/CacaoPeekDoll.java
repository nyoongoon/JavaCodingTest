import java.util.Stack;

public class CacaoPeekDoll {
    public int solution(int[][] board, int[] moves){
        Stack<Integer> stk = new Stack<Integer>();

        int answer = 0;
        int target;
        int a, b;
        for(int i = 0; i<moves.length; i++){
            target = moves[i] - 1;
            for(int j = 0; j<board.length; j++){
                if(board[j][target] == 0){

                }else{
                    stk.push(board[j][target]);
                    if(stk.size() > 1){
                        a = stk.pop();
                        b = stk.pop();
                        if(a == b){
                            answer += 2;
                        }else{
                            stk.push(b);
                            stk.push(a);
                        }
                    }
                    board[j][target] = 0;
                    //break문을 빠뜨렸음!!
                    break;
                }
            }
        }


        return answer;
    }
}