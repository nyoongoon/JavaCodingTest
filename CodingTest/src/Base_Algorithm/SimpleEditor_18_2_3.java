package Base_Algorithm;

import java.util.LinkedList;

public class SimpleEditor_18_2_3 {
    public static String solution(String input, String cmd) {
        LinkedList<Character> ll = new LinkedList<>();

        for(char c : input.toCharArray()){
            ll.add(c);
        }
        // 마지막 단어의 인덱스 == input.length()-1  =>  중간삽입인경우 add(idx, ele); 마지막 삽입(idx>=input.length()) 인 경우 add();
        int cursor = input.length();
        // L(idx+=1), D(idx-=1), B(remove(idx-1), P (add)

        for (int i = 0; i < cmd.length(); i++) {
            char curChar = cmd.charAt(i);
            if('L' == curChar){
                if(cursor-1>=0){
                    cursor -= 1;
                }

            }else if('D' == curChar){
                if(cursor + 1 <= input.length()){
                    cursor +=1;
                }
            }else if('B' == curChar){
                if(cursor-1>=0){ // 커서가 0 은 될 수 있으나 0일때 삭제는 안먹힘
                    //System.out.println("remove : " + ll.get(cursor-1));
                    cursor -=1;
                    ll.remove(cursor);
                }
            }else if('P' == curChar){
                i+=2;
                char insertChar = cmd.charAt(i);
                if(cursor >= input.length()){
                    ll.add(insertChar);
                }else{
                    ll.add(cursor, insertChar);
                }
            }
        }

        String result ="";
        for(char c : ll){
            result += c;
        }

        return result;
    }

    public static void main(String[] args) {
        // test code
        System.out.println(solution("aba", "L B"));
        System.out.println(solution("abcd", "P x L P y"));
        System.out.println(solution("abc", "L L L P x L B P y"));
        System.out.println(solution("a", "B B L L D D P a P b P c"));
    }
}
