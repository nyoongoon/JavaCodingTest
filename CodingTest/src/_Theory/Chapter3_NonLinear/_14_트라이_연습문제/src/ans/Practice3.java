package _Theory.Chapter3_NonLinear._14_트라이_연습문제.src.ans;// Practice3
// 문자열 배열 strs 와 targets 가 주어졌을 때
// targets 내의 단어 중 한 문자만 바꾸면 strs 중의 단어가 되는지 판별하는 프로그램을 작성하세요.

// 입출력 예시
// 입력 strs: "apple", "banana", "kiwi"
// 입력 target: "applk", "bpple", "apple"
// 출력: true, true, false


public class Practice3 {
    public static void solution(String[] strs, String[] targets) {
        Practice2.Trie trie = new Practice2.Trie();
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
    public static boolean check(Practice2.Node node, String target, int idx, boolean flag) {
        if (target.length() > idx) {
            char c = target.charAt(idx);

            if (node.child.containsKey(c)) {
                if (check(node.child.get(c), target, idx + 1, flag)) {
                    return true; // if조건이 false인 경우에도 로직이 더 필요한 경우 메소드 즉시 리턴하지 않는다!
                }
            }
            if (flag) {
                for (Character child : node.child.keySet()){
                    if(child != c && check(node.child.get(child), target, idx + 1, false)){ // 이 로직에선 하위 노드의 결과가 상위노드로 바로 전달됨
                        return true;
                    }
                }
            }
            return false; //하위노드에 값없고 플래그도 사용하였으면 false반환.
        }

        return !flag && node.isTerminal; //마지막 노드에 대한 판단.
    }
}
