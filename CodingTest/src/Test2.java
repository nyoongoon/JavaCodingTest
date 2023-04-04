import java.util.LinkedList;

public class Test2 {


    public static void main(String[] args) {
        String s1 = "baabaa";
        System.out.println(solution(s1));
        System.out.println();
        String s2 = "cdcd";
        System.out.println(solution(s2));
    }


    public static int solution(String s) {
        char[] chars = s.toCharArray();
        LinkedList<Character> ll = new LinkedList<>();

        for (int i = 0; i < chars.length; i++) {
            if(ll.isEmpty()){
                ll.add(chars[i]);
                continue;
            }

            if (ll.peekLast() == chars[i]) {
                if (ll.peekLast() != null) {
                    ll.pollLast();
                }
            } else {
                ll.add(chars[i]);
            }
        }

        if (ll.size() == 0) {
            return 1;
        } else{
            return 0;
        }

    }


}
