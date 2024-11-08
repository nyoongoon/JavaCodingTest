package _0_Theory.Chapter3_NonLinear._11_우선순위큐.src;// Practice 2
// 문자열 사전식 오름차순

import java.util.PriorityQueue;

class Person2 {
    String name;
    int age;

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class Practice2 {
    public static void solution(String[] name, int[] age) {

    }

    public static void main(String[] args) {
        PriorityQueue<Person2> pq = new PriorityQueue<>((Person2 p1, Person2 p2) -> p1.name.compareTo(p2.name));

        String[] name = {"A", "B", "C", "D", "E"};
        int[] age = {30, 20, 45, 62, 35};

        solution(name, age);

        PriorityQueue<Person2> pq5 = new PriorityQueue<>((x, y) -> x.name.compareTo(y.name)); //오름차순
    }
}
