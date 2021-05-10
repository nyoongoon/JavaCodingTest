//왜  틀렸는지 다시 풀어보기
public class ProgrammersGymClothes {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        for (int i = 0; i < reserve.length; i++) {
            for (int j = 0; j < lost.length; j++) {
                if (reserve[i] == lost[j]) {
                    answer++;
                    reserve[i] = 9999;
                    lost[j] = 9999;
                }
            }
        }
        for (int i = 0; i < reserve.length; i++) {
            for (int j = 0; j < lost.length; j++) {
                if (reserve[i] - 1 == lost[j]) {
                    lost[j] = 9999;
                    reserve[i] = 9999;
                    answer++;
                } else if (reserve[i] + 1 == lost[j]) {
                    lost[j] = 9999;
                    reserve[i] = 9999;
                    answer++;
                }
            }
        }


        return answer;
    }
}

