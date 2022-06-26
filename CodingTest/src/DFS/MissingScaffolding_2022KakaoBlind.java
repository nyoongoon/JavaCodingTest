package DFS;
import java.util.*;
public class MissingScaffolding_2022KakaoBlind { /// 실패함.... 테스트 케이스에서 이상한 움직임이 나옴 !!!


    static int max = Integer.MAX_VALUE;
    public int solution(int[][] board, int[] aloc, int[] bloc) {

        makeDfs(board, aloc, bloc, 0);
        return max-1;

    }

    public static void makeDfs(int[][] board, int[] aloc, int[] bloc, int turns){



        if(board[aloc[0]][aloc[1]] == 0 || board[bloc[0]][bloc[1]] == 0){
            max = Math.min(max, ++turns);
            return;
        }

        turns++; //여기서 턴이 오르면 안 됨
        // turns가 홀수면 a // 짝수면 b

        int[] newAloc = Arrays.copyOf(aloc, aloc.length);
        int[] newBloc = Arrays.copyOf(bloc, bloc.length);
        ArrayList<GameResult> al = new ArrayList<>();

        if(turns % 2 != 0){

            al = moveResult(board, newAloc, turns ,bloc);  // loc 결과 판단 // 최대 4개의 결과 값.
        }else{

            al = moveResult(board, newBloc, turns, aloc);  // loc 결과 판단 // 최대 4개의 결과 값.
        }

        // 여기서(재귀 건너서) 패배 할건지, moveResult에서 패배할건지

        if(al.size() == 0){

            max = Math.min(max, turns);

            return;
        }else{

            for(GameResult gr : al){

                if(turns % 2 != 0){ //a 턴일 때 b를 확인

                    newAloc = gr.loc;

                }else{

                    newBloc = gr.loc;

                }

                makeDfs(gr.board, newAloc, newBloc, turns);

            }

        }

    }

    public static ArrayList<GameResult> moveResult(int[][] board, int[] loc, int turns, int[] opposit){
        // 4개의 상태를 반환해야함.
        ArrayList<GameResult> al = new ArrayList<>();

        int [][] canMove = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for(int i = 0; i<canMove.length; i++){

            int newY= loc[0] + canMove[i][0];
            int newX = loc[1] + canMove[i][1];

            if(0<= newX&& newX < board[0].length &&  //x가 맞나..?
                    0<=newY && newY < board.length && board[newY][newX]  == 1){ // y가 맞나 ..?

                int[][] newBoard = new int[board.length][board[0].length];
                for(int j = 0; j<board.length; j++){
                    for(int k = 0; k<board[j].length; k++){
                        newBoard[j][k] = board[j][k];
                    }
                }

                newBoard[loc[0]][loc[1]] = 0;
                int[] newLoc = {newY, newX};

                GameResult gr = new GameResult(newBoard, newLoc);
                al.add(gr);
            }else{
                //실패
            }
        }

        if(al.size() > 2){ // 다른 방법이 있는 경우
            for(int i = 0; i<al.size(); i++){
                if(al.get(i).loc[0] == opposit[0] && al.get(i).loc[1] == opposit[1]){
                    al.remove(i);
                }
            }
        }

        return al;

    }


    public static class GameResult{
        int[][] board;
        int[] loc;
        GameResult(int[][] board, int[] loc){
            this.board = board;
            this.loc = loc;
        }
    }

}
