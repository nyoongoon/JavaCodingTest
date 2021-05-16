

public class DifferentBIt {
	public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        int idx = 0;
        for(long n : numbers) {
            int i = 0;
            //i번째 원소가 1인지 확인!!
            //0이 되지 않으려면 1이 겹치치 않아야함
            while((n & (1l << i)) != 0) i++;
            //i번째 원소가 1인 변수 m
            long m = 1l << i;
            //i가 0 이면 n + 1 아니면 n + (m >>1) 
            answer[idx++] = i == 0 ? n + 1 : (n + (m >> 1));
            
            /*
             	1. 0번째 원소가 0일때 --> +1
             	2. i번쨰 원소가 0일때 i번째 0과 i번째 1을 순서 바꾸기
             */
        }
        return answer;
    }
}
