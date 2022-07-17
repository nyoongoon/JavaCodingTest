package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N31_EmergencyRoom_inf { // 강의 풀이
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        int n = stdIn.nextInt();
        int m = stdIn.nextInt();
        int[] arr = new int[n];

        for(int i = 0 ; i<arr.length; i++){
            arr[i] = stdIn.nextInt();
        }

        int answer = 0;
        Queue<Person> q = new LinkedList<>();
        for(int i = 0; i<arr.length; i++){
            q.offer(new Person(i, arr[i]));
        }

        while(!q.isEmpty()){
            Person tmp = q.poll();
            for(Person x : q){ // Queue가 Collection을 상속받고 있으므로 Iterater 가짐 => 향상된 for문 사용 가능
                if(x.priority>tmp.priority){ // 꺼낸값보다 안의 값이 더 큰 경우.
                    q.offer(tmp);
                    tmp=null; //제거해서 뒤로 붙이기. // 자동으로 큐에서 사라지나봄 ..?
                    break;
                }
            }
            if(tmp != null){ // 결과값으로 저장
                answer++;
                if(tmp.id==m){
                    System.out.println(answer);
                    return;
                }
            }
        }

    }
}
class Person{
    int id;
    int priority;
    public Person(int id, int priority){
        this.id = id;
        this.priority = priority;
    }
}