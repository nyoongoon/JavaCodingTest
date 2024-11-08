package _0_Theory.Chapter3_NonLinear._14_트라이_연습문제.src;// Practice3
// 문자열 배열 strs 와 targets 가 주어졌을 때
// targets 내의 단어 중 한 문자만 바꾸면 strs 중의 단어가 되는지 판별하는 프로그램을 작성하세요.

// 입출력 예시
// 입력 strs: "apple", "banana", "kiwi"
// 입력 target: "applk", "bpple", "apple"
// 출력: true, true, false


public class Practice3 {
    public static void solution(String[] strs, String[] targets) {
        Trie trie = new Trie();
        for (String s : strs) {
            trie.insert(s);
        }

        for (String target : targets) {
            System.out.println(check(trie.root, target, 0, true));
        }
    }

    public static void main(String[] args) {
        // Test code
        String[] strs = {"apple", "banana", "kiwi"};
        String[] targets = {"applk", "bpple", "apple", "banan", "kiww"};
        solution(strs, targets);    // true, true, false, false, true
    }


    // flag와 리턴값은 같은 것이 아님?? flag는 한 번 건너 뛰었는지에 대한 여부
    public static boolean check(Node node, String target, int idx, boolean flag) {
        if (target.length() > idx) {
            char c = target.charAt(idx);

            if (node.child.containsKey(c)) {
                // 내 문제풀이의 버그 찾기 --> 아마도 이 부분? 부모에서 false가 나더라도 판단이 달라질 경우가 있다?
                // true면 true반환이지만, false이더라도 true가 되는 케이스가 존재한다면 이렇게 메소드 결과값 바로리턴 안됨!
                // return check(node.child.get(c), target, idx + 1, flag); //false일때 케이스가 있어야 dfs가 가능. --> 이부분 틀림
                if (check(node.child.get(c), target, idx + 1, flag)) {
                    System.out.println(c);
                    return true; // if조건이 false인 경우에도 로직이 더 필요한 경우 메소드 즉시 리턴하지 않는다!
                }
            }
            // 중간에 하나 빈 경우에 대해서 처리..
            if (flag) { // 모두 같은 경우 마지막length넘긴 상태에서 이리로 들어와서 true로 넘어감 -> 아래 child != c 하는 이유
                for (Character child : node.child.keySet()){
                    //child != c의 경우는 ??????????
                    return child != c && check(node.child.get(child), target, idx + 1, false); // 이 로직에선 하위 노드의 결과가 상위노드로 바로 전달됨
                }
            }
            return false; //하위노드에 값없고 플래그도 사용하였으면 false반환.
        }

        return !flag && node.isTerminal; //마지막 노드에 대한 판단.
    }
}
