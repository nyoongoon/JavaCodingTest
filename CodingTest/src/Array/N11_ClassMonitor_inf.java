import java.util.Scanner;

public class N11_ClassMonitor_inf {
    public int solution(int n, int[][] arr){
        int answer =  0;
        int max = Integer.MIN_VALUE;

        for(int i = 1; i<=n; i++){
            int cnt = 0;
            for(int j=1; j<=n; j++){
                for(int k = 1; k<=5; k++){
                    if(arr[i][k] == arr[j][k]){
                        cnt++;
                        break;
                    }
                }
            }
            if(cnt > max){
                max = cnt;
                answer = i;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        //0번 사용하지 않음.
        //for i 학생 //i==j 체크안해도 결과는 크기 비교라 상관 없음.
        //for j 학생
        //for k 학급 //같을 경우 break -> 나는 중복 체크 배열을 썼는데 이 방법이 더 좋음.
        N11_ClassMonitor_inf T = new N11_ClassMonitor_inf();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] arr = new int[n+1][6];
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=5; j++){
                arr[i][j] = kb.nextInt();
            }
        }
        System.out.print(T.solution(n, arr));
    }
}
