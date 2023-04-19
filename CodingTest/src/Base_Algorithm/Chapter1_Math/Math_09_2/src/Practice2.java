package Base_Algorithm.Chapter1_Math.Math_09_2.src;

public class Practice2 {
    public static int solution(String str) {
        char[] chars = str.toCharArray();
        return recur(chars, 0, chars.length - 1, 0);
    }


    public static int recur(char[] chars, int left, int right, int dept) {
        while(left < right){
            if(chars[left] != chars[right]){
                if(dept == 0){
                    if(recur(chars, left+1, right, dept+1) == 0 ||
                        recur(chars, left, right-1, dept+1) == 0){
                        return 1;
                    }
                }
                return 2;
            }else{
                left++;
                right--;
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        // Test code
        String[] str = {"abba", "summuus", "xabba", "xabbay", "comcom", "comwwmoc", "comwwtmoc"};
        System.out.println(solution("abba"));
        System.out.println(solution("summuus"));
        System.out.println(solution("xabba"));
        System.out.println(solution("xabbay"));
        System.out.println(solution("comcom"));
        System.out.println(solution("comwwmoc"));
        System.out.println(solution("comwwtmoc"));
    }
}
