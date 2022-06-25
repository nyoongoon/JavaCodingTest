package DFS;
import java.util.*;
public class MissingScaffolding_2022KakaoBlind { /// 실패함.... 테스트 케이스에서 이상한 움직임이 나옴 !!!

        //static int turns = 1;
        static int max = Integer.MIN_VALUE;
        public int solution(int[][] board, int[] aloc, int[] bloc) {
            int deps = 0;
            // 처음캐릭터 위치 발판 있는 곳.
            // 발반으로만 이동 --> bfs..?
            // 발판은 밝고 있던 캐릭터가 다른 발판을 밝으면 사라짐 !
            // 상하좌우 인접한 4칸
            // 갈 곳이 없으면 패배
            // 같은 발판위에서 상대 플레이어 캐릭터가 이동, 내 발판 사라지면 패배.
            // A가 시작

            // 1. 트리 그리기 -> 움직임 함수 만들기

            // 2. 재귀 타고 올라가기. ==> 최대 깊이 구하기. (dfs)..


            //while(true){
            // turns 홀짝 구하기 => aloc, bloc 번갈아서
            //System.out.println("makeDfs 실행");
            makeDfs(board, aloc, bloc, 1);
            //}




            return max;
        }

        public static void makeDfs(int[][] board, int[] aloc, int[] bloc, int turns){
            // turns가 홀수면 a // 짝수면 b
            int[] newAloc = Arrays.copyOf(aloc, aloc.length);
            int[] newBloc = Arrays.copyOf(bloc, bloc.length);
            ArrayList<GameResult> al = new ArrayList<>();
            if(turns % 2 != 0){
                //loc = aloc;

                al = moveResult(board, newAloc);  // loc 결과 판단 // 최대 4개의 결과 값.
            }else{

                al = moveResult(board, newBloc);  // loc 결과 판단 // 최대 4개의 결과 값.
            }

            // 여기서(재귀 건너서) 패배 할건지, moveResult에서 패배할건지




            if(al.size() == 0){ // 결과값이 없으면 turn 저장
                // System.out.println("moveResult결과 없음 ");
                // System.out.println("al.size() == " + al.size());
                // System.out.println();

                //max = Math.max(max, turns);
                return;
            }else{
                // 4개의 결과값에 대해 밑에 다 돌아야함. 보드상태, loc위치.  4개씩
                // System.out.println("moveResult결과 있음 ");
                // System.out.println("al.size() == " + al.size());
                // System.out.println();
                for(GameResult gr : al){

                    if(turns % 2 != 0){
                        newAloc = gr.loc;
                        System.out.println("now turns == " + turns);
                        System.out.println("aloc[0] == " + newAloc[0]);
                        System.out.println("aloc[1] == " + newAloc[1]);
                        max = Math.max(max, turns);
                        System.out.println("max turns == " + max);
                        System.out.println();
                        // System.out.println("aloc = gr.loc 통과");
                        //System.out.println("gr.board[0] == ")
                    }else{
                        newBloc = gr.loc;
                        System.out.println("now turns == " + turns);
                        System.out.println("bloc[0] == " + newBloc[0]);
                        System.out.println("bloc[1] == " + newBloc[1]);
                        max = Math.max(max, turns);
                        System.out.println("max turns == " + max);
                        System.out.println();
                    }

                    makeDfs(gr.board, newAloc, newBloc, ++turns);

                }

            }









        }

        public static ArrayList<GameResult> moveResult(int[][] board, int[] loc){

            // 4개의 상태를 반환해야함.
            ArrayList<GameResult> al = new ArrayList<>();

            int [][] canMove = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
            for(int i = 0; i<canMove.length; i++){

                int newX = loc[0] + canMove[i][0];
                int newY = loc[1] + canMove[i][1];

                if(0<= newX&& newX < board.length &&
                        0<=newY && newY < board[0].length && board[newX][newY]  == 1){
                    //성공
                    //board[loc[0]][loc[1]] = 0; // 적용하면 안되지 ! // array copy
                    //int[][] newBoard = System.arraycopy(board);
                    int[][] newBoard = new int[board.length][board[0].length];
                    for(int j = 0; j<board.length; j++){
                        for(int k = 0; k<board[j].length; k++){
                            newBoard[j][k] = board[j][k];
                        }
                    }

                    newBoard[loc[0]][loc[1]] = 0;

                    //loc[0] = newX;
                    //loc[1] = newY;
                    int[] newLoc = Arrays.copyOf(loc, loc.length);
                    newLoc[0] = newX;
                    newLoc[1] = newY;
                    GameResult gr = new GameResult(newBoard, newLoc);
                    al.add(gr);
                }else{
                    //실패


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
