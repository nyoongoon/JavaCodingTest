package Queue;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N30_CurriculumDesign {
    public static void main(String[] args){
        Queue<Character> queue = new LinkedList<>();
        Scanner stdIn = new Scanner(System.in);
        String str = stdIn.nextLine();
        String classList = stdIn.nextLine();

        for(char c : str.toCharArray()){
            queue.add(c);
        }

        char qVal = queue.poll();
        for(char clazz : classList.toCharArray()){

            if(clazz == qVal){
                if(queue.isEmpty()){
                    System.out.println("YES");
                    return;
                }
                qVal = queue.poll();
            }
        }

        System.out.println("NO");
    }
}
