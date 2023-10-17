package Base_Algorithm.Chapter2_Linear.LinearDS_13.src;// Practice3
// 참고 - Hashtable? HashMap? 비교

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Practice3 {
    public static void main(String[] args) {
        // Hashtable
        Hashtable<Integer, Integer> ht = new Hashtable<>();
        ht.put(0, 10);
        System.out.println(ht.get(0));

        // HashMap
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 10);
        System.out.println(hm.get(0));

        //다형성
        Map<Integer, Integer> map1 = ht;
        Map<Integer, Integer> map2 = hm;

        //해시 테이블은 null을 키로 가지지 못함
        /*ht.put(null, -999);
        System.out.println(ht.get(null));*/ //에러 발생 !!

        hm.put(null, -999);
        System.out.println(hm.get(null));

        // Hashtable 과 HashMap의 차이
        // 공통 : 둘 다 Map 인터페이스를 구현한 것
        // 차이 :
            // Key에 Null을 사용 여부
            // Hashtable : X
            // HashMap : O

            // Thread-safe
            // Hashtable : O (멀티 스레드 환경에서 우수)
            // HashMap : X (싱글 스레드 환경에서 우수)
            // => 코테, 실무에서도 HashMap을 사용하되, synchronizedMap, ConcurrentHashMap 등으로
            // 참고) synchronizedMap, ConcurrentHashMap

               --> 블로그 글 작성하기
    }
}
