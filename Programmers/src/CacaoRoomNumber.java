import java.util.*;

public class CacaoRoomNumber {
    Map<Long, Long> map = new HashMap<>();
    public long[] solution(long k, long[] room_number) {

        long[] answer = new long[room_number.length];
        for(int i = 0; i< room_number.length; i++){
            answer[i] = find(room_number[i]) - 1;
        }

        return answer;
    }
    long find(long number){
        if(!map.containsKey(number)){
            //키가 없는 경우
            map.put(number, number + 1);
            return number + 1;
        }else{
            //키가 있는 경우
             long temp = find(map.get(number));
             map.put(number, temp);
             return temp;
        }
    }
}
