package _2_Java_Algo_Interview._4_스택_큐;

import java.util.Set;
import java.util.TreeSet;

/**
 * 재귀를 이용한 분리
 * point)
 * - Set 재정의 -> 구현클래스 생성할 때 생성자에 Comparator 주입 ->Comparator<T>#compare(T o1, To2) 재정의
 * --> Comparator 함수형 인터페이스므로 람다 가능
 * <p>
 * ex) dbacdcbc
 * - 중복 문자를 제외한 알파벳순으로 문자열 입력값을 모두 정렬한 다음
 * -> 1. 가장 빠른 a부터 접미사 suffix를 분리해 확인한다
 * -> a는 가장 빠른 알파벳일 뿐만아니라 문자열에서 b,c,d도 뒤에 있기 때문에 가장 먼저 정답으로 추출할 수 있음
 * - 이제 a가 빠지고 cdcbc 상태에서 다음 알파벳 순서인 b를 추줄하면 뒤에 c가 없기 떄문에 추출 불가
 * -> 분리 가능 여부를 다음 코드와 같이 *전체 집합과 접미사 집합이 일치하는지 여부*로 판변
 * <p>
 * 일종의 분할 정복 형태로 접미사 suffix의 크기 줄어듬
 * -> suffix 크기는 점점 줄어들고 더이상 남아있지 않을 때 백트래킹 되면서 결과가 조합됨
 */
public class _2_중복_문자_제거_책풀이_재귀 {
    public static void main(String[] args) {

    }

    public Set<Character> toSortedSet(String s) {
        //todo 근데 재정의 안해도 되지 않나? 어차피 문자열 오름차순 -> String이 아니고 Character라 그런가?
        //문자열을 문자 단위 집합으로 저장할 변수 선언
//        Set<Character> set = new TreeSet<>(new Comparator<Character>() {
//            // 비교 메서드 재정의
//            @Override
//            public int compare(Character o1, Character o2) {
//                // 동일한 문자면 무시
//                if(o1 == o2){
//                    return 0;
//                }else if(o1 > o2){
//                    return 1;
//                }else{
//                    return -1;
//                }
//            }
//        });
        Set<Character> set = new TreeSet<>((x, y) -> x - y);
        // 문자열을 문자 단위로 집합에 저장, 정렬된 상태로 저장된다
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        return set;
    }

    public String removeDuplicateLetters(String s) {
        // 정렬된 문자열 집합 순회
        // s : dbacdcbc -> cdcbc -> db -> b
        // set : abcd -> bcd -> bd -> b
        for (char c : toSortedSet(s)) {
            // 해당 문자가 포함된 위치부터 접미사로 지정
            String suffix = s.substring(s.indexOf(c)); // acdcbc
            // 전체 집합과 접미사 집합이 일치하면 해당 문자 정답에 추가하고 재귀 호출 진행
            if (toSortedSet(s).equals(toSortedSet(suffix))) {
                return c + removeDuplicateLetters(suffix.replace(String.valueOf(c), ""));
            }
        }
        return "";
    }
}
